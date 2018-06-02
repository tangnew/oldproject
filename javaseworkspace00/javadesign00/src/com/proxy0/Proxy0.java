package com.proxy0;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Proxy0 {
	public static void main(String[] args) throws Exception {
		JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager sjfm = jc.getStandardFileManager(null, null, null);
		
		
		//编译的文件
		Iterable<? extends JavaFileObject> jfo = sjfm.getJavaFileObjects(new File("a"));
		
		//获取到编译任务
		CompilationTask t = jc.getTask(null, sjfm, null, null, null, jfo);
		
		//编译任务开始
		t.call();
		
		try {
			sjfm.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//加进进内存
		URL[] urls = new URL[]{new URL("dd"),new URL("dd")};
		URLClassLoader urlClassLoader = new URLClassLoader(urls);
		urlClassLoader.loadClass("com.test.A.clas");
		urlClassLoader.close();
		System.out.println(jc.getClass().getName());
		System.out.println(System.getProperty("user.dir"));
	}
}
