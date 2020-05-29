package com.ai.ge.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ReflectUtil {
	
	/**
     * Get Class field and value Map
     * @return
     */
    public Map<String, Object> getClassInfo(Object obj)
    {
        Map<String ,Object>  fieldsAndValues = new HashMap<String, Object>();
        Field [] fields = obj.getClass().getDeclaredFields();
        for(int i=0; i< fields.length; i++)
        {
            Field f = fields[i];
            Object value = getFieldValue(obj ,f.getName());
            fieldsAndValues.put(f.getName(),value);
        } 
      return fieldsAndValues;
    }  
    
    
    
    private  Object getFieldValue(Object owner, String fieldName)
    {
        return invokeMethod(owner, fieldName,null);
    }
    
    
    /**
     * 
     * 执行某个Field的getField方法
     * 
     * @param owner 类
     * @param fieldName 类的属性名称
     * @param args 参数，默认为null
     * @return 
     */
    private   Object invokeMethod(Object owner, String fieldName, Object[] args)
    {
        Class<? extends Object> ownerClass = owner.getClass();
        
        //fieldName -> FieldName  
        String methodName = fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);
        
        Method method = null;
        try 
        {
            method = ownerClass.getMethod("get" + methodName);
        } 
        catch (SecurityException e) 
        {

            //e.printStackTrace();
        } 
        catch (NoSuchMethodException e) 
        {
            // e.printStackTrace();
            return "";
        }
        
        //invoke getMethod
        try
        {
            return method.invoke(owner);
        } 
        catch (Exception e)
        {
            return "";
        }
    }

}
