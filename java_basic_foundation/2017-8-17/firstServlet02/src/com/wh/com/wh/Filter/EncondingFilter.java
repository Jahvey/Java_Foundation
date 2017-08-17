package com.wh.com.wh.Filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncondingFilter  implements Filter {


    String encoding = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("EncondingFilter 启动了。。。");
        encoding = filterConfig.getInitParameter("encoding");
        encoding = encoding==null?"UTF-8":encoding;

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//以下三行代码 只适合post
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//        filterChain.doFilter(request,response);

        request.setCharacterEncoding("UTF-8");
        HttpServletRequest req = (HttpServletRequest)request;
        if(req.getMethod().equals("GET")){
            ChineseCodeErrorRequest ccer = new ChineseCodeErrorRequest(req,encoding);
            req = ccer;
        }
        response.setContentType("text/html;charset=UTF-8");
        filterChain.doFilter(req, response);


    }

    @Override
    public void destroy() {
        System.out.println("EncondingFilter销毁了....");

    }
}
