package com.ai.ge.util;


import java.lang.reflect.Method;
import java.util.*;

public class CoreUtils {

	public static boolean isEmpty(String temp) {
		return (temp == null || temp.trim().length() == 0);
	}

	public static boolean isEmpty(Collection<?> temp) {
		return (temp == null || temp.size() == 0);
	}

	public static boolean isEmpty(Map<?, ?> temp) {
		return (temp == null || temp.isEmpty());
	}

	public static boolean isEmpty(String[] temp) {
		return (temp == null || temp.length == 0);
	}

	public static boolean isEmpty(Object temp) {
		return (temp == null);
	}

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}

	public static String getIntCode(int size){
		String str="0123456789";
		Random random=new Random();
		StringBuffer sf=new StringBuffer();
		for(int i=0;i<size-1;i++){
			sf.append(str.charAt(random.nextInt(10)));
		}
		return sf.toString();
	}

	public static Map<String,String> checkParamNull(Object obj,String[] paramArr,String[] showArr)
	{
		Map<String,String> result = new HashMap<String,String>();
		result.put("code","0");
		result.put("msg","0000");
		if(paramArr == null || paramArr.length == 0)
		{
			return result;
		}
		if(obj == null)
		{
			result.put("code","1003");
			result.put("msg","参数对象为空或json转换异常！");
			return result;
		}
		Map<String, Object> map = new ReflectUtil().getClassInfo(obj);
		Object value;
		for(int i = 0; i < paramArr.length;i ++ )
		{
			String par = paramArr[i];
			value = map.get(par);
			if(value == null ||
					(value instanceof String && "".equals(String.valueOf(value).trim())))
			{
				result.put("code","1004");
				result.put("msg", showArr[i] + "为空！");
				return result;
			}
		}
		return result;
	}

	public static boolean copyProperties(Object from, Object to){
		try {
			copyPropertiesExclude(from,to,null);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static void copyPropertiesExclude(Object from, Object to, String[] excludsArray) throws Exception {
		List<String> excludesList = null;
		if(excludsArray != null && excludsArray.length > 0) {
			excludesList = Arrays.asList(excludsArray); //构造列表对象
		}
		Method[] fromMethods = from.getClass().getDeclaredMethods();
		Method[] toMethods = to.getClass().getDeclaredMethods();
		Method fromMethod = null, toMethod = null;
		String fromMethodName = null, toMethodName = null;
		for (int i = 0; i < fromMethods.length; i++) {
			fromMethod = fromMethods[i];
			fromMethodName = fromMethod.getName();
			if (!fromMethodName.contains("get"))
				continue;
			//排除列表检测
			if(excludesList != null && excludesList.contains(fromMethodName.substring(3).toLowerCase())) {
				continue;
			}
			toMethodName = "set" + fromMethodName.substring(3);
			toMethod = findMethodByName(toMethods, toMethodName);
			if (toMethod == null)
				continue;
			Object value = fromMethod.invoke(from);
			if(value == null)
				continue;
			//集合类判空处理
			if(value instanceof Collection) {
				Collection newValue = (Collection)value;
				if(newValue.size() <= 0)
					continue;
			}
			toMethod.invoke(to, value);
		}
	}

	/**
	 * 从方法数组中获取指定名称的方法
	 *
	 * @param methods
	 * @param name
	 * @return
	 */
	public static Method findMethodByName(Method[] methods, String name) {
		for (int j = 0; j < methods.length; j++) {
			if (methods[j].getName().equals(name))
				return methods[j];
		}
		return null;
	}

	public static void main(String[] args)
	{
		System.out.println(getUUID());
	}
}
