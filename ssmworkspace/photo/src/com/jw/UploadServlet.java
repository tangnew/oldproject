package com.jw;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		int yourMaxMemorySize = 10000000;
		int yourMaxRequestSize = yourMaxMemorySize;
		File yourTempDirectory = new File("D:/up/temp");
		// Set factory constraints
		factory.setSizeThreshold(yourMaxMemorySize);
		factory.setRepository(yourTempDirectory);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set overall request size constraint
		upload.setSizeMax(yourMaxRequestSize);

		// Parse the request
		try {
			List<FileItem> items = upload.parseRequest(request);
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();

				if (item.isFormField()) {
					processFormField(item);
				} else {
					processUploadedFile(item);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("./image.html?date="+System.currentTimeMillis());
	}

	private void processUploadedFile(FileItem item) {
		String fieldName = item.getFieldName();
		String fileName = item.getName();
		String contentType = item.getContentType();
		boolean isInMemory = item.isInMemory();
		long sizeInBytes = item.getSize();
		fileName = "1.jpg";
		File uploadedFile = new File("D:/workspace/eclipseworkspace/webworkspace/photo/WebContent/image/"+fileName);
		try {
			System.out.println(fileName);
			item.write(uploadedFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	private void processFormField(FileItem item) {
		String name = item.getFieldName();
		String value = item.getString();

	}

}
