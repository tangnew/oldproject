package com.resource;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

/**
 * 内置resource:ByteArrayResource\InputStreamResource它们的isOpen永远是true,表示只能读取一次该字节流
 * 。 FileSystemResource、ClassPathResource：
 * ClassPathResource代表classpath路径的资源，将使用ClassLoader进行加载资源。classpath
 * 资源存在于类路径中的文件系统中或jar包里，且“isOpen”永远返回false，表示可多次读取资源
 * UrlResource\ServletContextResource\VfsResource他们的isOpen均是false,都可以多次读取资源
 * @author Administrator
 * 
 */
public class ByteResourceTest {
	@Test
	public void testByteArrayResource() {
		Resource resource = new ByteArrayResource("Hello World!".getBytes());
		if (resource.exists()) {
			dumpStream(resource);
		}
	}

	private void dumpStream(Resource resource) {
		InputStream is = null;
		try {
			// 1.获取文件资源
			is = resource.getInputStream();
			// 2.读取资源
			byte[] descBytes = new byte[is.available()];
			is.read(descBytes);
			System.out.println(new String(descBytes));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 3.关闭资源
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
