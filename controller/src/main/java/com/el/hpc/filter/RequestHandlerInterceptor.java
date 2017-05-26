package com.el.hpc.filter;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 *
 * @User : Hapic
 * @Date : 2017/5/26 9:36
 * 请求过滤器
 */
public class RequestHandlerInterceptor implements HandlerInterceptor {
    private Map<String,Long> requestMap=new HashMap<>();
    Table<String, String, Long> dateIpMap = HashBasedTable.create();
    SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String remoteAddr = httpServletRequest.getRemoteAddr();
        return isThrough(remoteAddr);
        

    }

    private boolean isThrough(String remoteAddr) {
        return true;

       /* Long lastDate = dateIpMap.get(getDay(), remoteAddr);
        long currentM = System.currentTimeMillis() / 1000;
        if(lastDate==null || lastDate<=0){
            dateIpMap.put(getDay(),remoteAddr,currentM);
        }else {
            return currentM-lastDate>5;
        }*/



    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public String getDay(){
        return sdfDays.format(new Date());
    }
}
