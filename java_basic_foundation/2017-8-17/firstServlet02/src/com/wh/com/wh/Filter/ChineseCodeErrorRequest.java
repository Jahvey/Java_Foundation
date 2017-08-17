package com.wh.com.wh.Filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

public class ChineseCodeErrorRequest extends HttpServletRequestWrapper {
    private String encoding = null;
    public ChineseCodeErrorRequest(HttpServletRequest request,String encoding) {
        super(request);
        this.encoding = encoding;
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if(value!=null){
            value = changeValue(value,encoding);
        }
        return value;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if(values == null){
            return null;
        }
        for(int i=0;i<values.length;i++){
            values[i] = changeValue(values[i], encoding);
        }
        return values;
    }

    /*@Override
    public Map getParameterMap() {
        Map<String,String[]> map = super.getParameterMap();
        Map result = new HashMap();
        Set<Map.Entry<String,String[]>> entrySet = map.entrySet();
        for(Map.Entry<String,String[]> set : entrySet){
            String name = set.getKey();
            String[] values = set.getValue();
            for(int i=0;i<values.length;i++){
                values[i] = values[i];
            }
            result.put(name, values);
        }
        return result;
    }*/  //不知道怎么回事,不用覆写也不会出现乱码,覆写后倒是出现乱码...

    private String changeValue(String value,String encoding) {
        try {
            value = new String(value.getBytes("ISO8859-1"),encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
}
