package com.method.inject;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;
/**
 * 1）首先定义MethodReplacer实现，完全替换掉被替换方法的方法体及返回值，其中reimplement方法重定义方法 功能，参数obj为被替换方法的对象，method为被替换方法，args为方法参数；最需要注意的是不能再 通过“method.invoke(obj, new String[]{"hehe"});” 反射形式再去调用原来方法，这样会产生循环调用；如果返回值类型为Void，请在实现中返回null：
 * 2）配置如下，首先定义MethodReplacer实现，使用< replaced-method >标签来指定要进行替换方法，属性name指定替换的方法名字，replacer指定该方法的重新实现者，子标签< arg-type >用来指定原来方法参数的类型，必须指定否则找不到原方法
 * 
 * @author Administrator
 *
 */
public class PrinterReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args)
			throws Throwable {
		  System.out.println("Print Replacer. He");  
	        //注意此处不能再通过反射调用了,否则会产生循环调用，知道内存溢出  
	        //method.invoke(obj, new String[]{"hehe"});  
	        return null;
	}

}
