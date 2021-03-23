package com.feng.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.domain.Order;
import com.feng.domain.Product;
import com.feng.service.OrderService;
import com.feng.service.ProduceService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    //查询所有
    @RequestMapping("/findAll")
    public ModelAndView findAll(Integer currentpage, Integer pagecount){
        ModelAndView modelAndView=new ModelAndView();
//        String currentpage = request.getParameter("currentpage");
//        String pagecount = request.getParameter("pagecount");
        List<Order> orderList =orderService.findAll(currentpage,pagecount);
//        modelAndView.addObject("ordersList", orderList);
//        modelAndView.addObject("pagecount",pagecount);
//        modelAndView.addObject("currentpage",currentpage);
        PageInfo pageInfo=new PageInfo(orderList);
        modelAndView.addObject("pageinfo",pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }

    @RequestMapping("/findById")
    public ModelAndView findOrdersDetails(@RequestParam(name = "id") String id){
        ModelAndView modelAndView=new ModelAndView();
//        String currentpage = request.getParameter("currentpage");
//        String pagecount = request.getParameter("pagecount");
        Order orders =orderService.findById(id);
        System.out.println(orders.getTravellers());
//        modelAndView.addObject("ordersList", orderList);
//        modelAndView.addObject("pagecount",pagecount);
//        modelAndView.addObject("currentpage",currentpage);
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }

//    //添加产品
//    @RequestMapping("/addproduct")
//    public ModelAndView addproduct(Product product){
//        //执行添加
//        produceService.addProduct(product);
//        //添加后重新回到展示页
//        return new ModelAndView("redirect:findAll");
//    }
//
//
//    //删除产品
//    @RequestMapping("/deleteproduct")
//    public void deteleproduct(Product product, HttpServletRequest request, String[] ids, HttpServletResponse response) throws IOException {
//        ModelAndView modelAndView=new ModelAndView();
//        //获取选中的id
//        for(int i=0;i<ids.length;i++){
//           ids[i]=ids[i].replace("[","");
//            ids[i]=ids[i].replace("]","");
//            ids[i]=ids[i].replace("\"","");
//        }
//        //根据id执行删除
//        for(int i=0;i<ids.length;i++){
//            produceService.deleteByid(ids[i]);
//        }
////        produceService.deleteProduct();
//        //删除后重新回到展示页
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValue(response.getWriter(),"true");
//    }
}
