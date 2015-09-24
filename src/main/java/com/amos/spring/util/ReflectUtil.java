/**
 * Copyright  2013-6-17 第七大道-技术支持部-网站开发组
 * 自主运营平台WEB 下午5:58:33
 * 版本号： v1.0
*/

package com.amos.spring.util;

import org.springframework.util.Assert;

import java.lang.reflect.Method;

/**
 * <li>类描述：</li>
 * <li>创建者： amos.zhou</li>
 * <li>项目名称： platform-manage</li>
 * <li>创建时间： 2013-6-17 下午5:58:33</li>
 * <li>版本号： v1.0 </li>
 */
public class ReflectUtil {

	/**
	 * 
	 * <li>创建时间： 2013-6-17 下午6:01:41</li>
	 * <li>创建人：amos.zhou </li>
	 * <li>方法描述 : 寻找方法名唯 一的方法</li>
	 * @param clazz
	 * @param name
	 * @return
	 */
	public static Method findUniqueMethod(Class<?> clazz, String name) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.notNull(name, "Method name must not be null");
		Class<?> searchType = clazz;
		while (searchType != null) {
			Method[] methods = (searchType.isInterface() ? searchType.getMethods() : searchType.getDeclaredMethods());
			for (Method method : methods) {
				if (name.equals(method.getName())) {
					return method;
				}
			}
			searchType = searchType.getSuperclass();
		}
		return null;
	}
}
