package com.exam.utils;

import java.io.File;

/**
 * Created by JW.
 * User: JW
 * Date: Nov 21, 2016 
 * Time: 10:43:21 AM
 *
 * com.exam.utils.FileUtils
 */
public class FileUtils {

	public static boolean isExistOfFile(String filePath, String fileName) {
		File file = new File(filePath, fileName);
		boolean isExist = file.exists();
		return isExist;
	}

}
