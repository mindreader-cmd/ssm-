package com.feng.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.domain.Product;
import com.feng.service.ProduceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/product")
public class IProductController {
    @Autowired
    ProduceService produceService;
    //查询所有
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(defaultValue = "1")Integer currentpage, @RequestParam(defaultValue = "3")Integer pagecount){
        ModelAndView modelAndView=new ModelAndView();
        PageHelper.startPage(currentpage,pagecount);
        List<Product> products = produceService.findAll();
        PageInfo<Product> pageInfo=new PageInfo<Product>(products);
        modelAndView.addObject("productList", pageInfo.getList());
        modelAndView.addObject("pageinfo", pageInfo);
        modelAndView.setViewName("product-list");
//        System.out.println("findAll");
        return modelAndView;
    }

    //添加产品
    @RequestMapping("/addproduct")
    public ModelAndView addproduct(Product product){
        //执行添加
        produceService.addProduct(product);
        //添加后重新回到展示页
        return new ModelAndView("redirect:findAll");
    }


    //删除产品
    @RequestMapping("/deleteproduct")
    public void deteleproduct(Product product, HttpServletRequest request, String[] ids, HttpServletResponse response) throws IOException {
        ModelAndView modelAndView=new ModelAndView();
        //获取选中的id
        for(int i=0;i<ids.length;i++){
           ids[i]=ids[i].replace("[","");
            ids[i]=ids[i].replace("]","");
            ids[i]=ids[i].replace("\"","");
        }
        //根据id执行删除
        for(int i=0;i<ids.length;i++){
            produceService.deleteByid(ids[i]);
        }
//        produceService.deleteProduct();
        //删除后重新回到展示页
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(),"true");
    }
}
