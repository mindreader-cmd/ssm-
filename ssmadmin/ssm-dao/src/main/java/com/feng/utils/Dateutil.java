package com.feng.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dateutil {
    public  static String DatetoStr(Date date,String format){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        String datestr = simpleDateFormat.format(date);
        return datestr;
    }

    public  static Date StrtoDate(String str,String format){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(str);
        Date date=null;
        try {
           date= simpleDateFormat.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
