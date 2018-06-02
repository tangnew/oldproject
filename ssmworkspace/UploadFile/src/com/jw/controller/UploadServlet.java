package com.jw.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 968905093922522873L;
	/**
	 * 存放文件的临时目录
	 */
	private File tempDir;
	/**
	 * 存放文件的最终目录
	 */
	private String finalDir;

	/**
	 * 最大内存值
	 */
	private int maxMemorySize = 1024 * 1024 * 1024;

	/**
	 * 存储的单个文件最大值
	 */
	private int maxRequestFileSize = 1024 * 1024 * 1024;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		tempDir = new File(config.getInitParameter("tempDir"));
		finalDir = config.getInitParameter("finalDir");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean isUpFile = ServletFileUpload.isMultipartContent(req);
		if (isUpFile) {
			uploadFile(req, resp);
		}
	}

	private void uploadFile(HttpServletRequest req, HttpServletResponse resp) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(maxMemorySize);
		factory.setRepository(tempDir);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(maxRequestFileSize);

		try {
			List<FileItem> items = upload.parseRequest(req);
			for (FileItem item : items) {
				if (!item.isFormField()) {// 是不是普通表单值，如果不是的话，这表示文件
					String fileName = item.getName();
					int length = fileName.lastIndexOf(".");
					String suffix = fileName.substring(length);
					String uuid = UUID.randomUUID().toString();
					fileName = uuid + suffix;// 产生文件名

					String finalFileAbsolutePath = finalDir + "/" + fileName;
					File uploadedFile = new File(finalFileAbsolutePath);
					FileUtils.copyInputStreamToFile(item.getInputStream(),
							uploadedFile);

					System.out.println("upload file=" + finalFileAbsolutePath);
					resp.sendRedirect("./up.jsp?fileName=" + fileName);// todo
																		// 只取一个文件，暂时不做多个文件上传。这里做get请求是为了简单，最好是做post请求
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
