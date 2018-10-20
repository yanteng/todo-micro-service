package com.example.training.todoservice.utils;

import java.util.Date;

public class DateUtils {
    public static Boolean equals(Date d1,Date d2){
        if(d1 == d2)
            return true;
        if(d1==null || d2==null)
            return false;
        return d1.equals(d2);
    }
}
