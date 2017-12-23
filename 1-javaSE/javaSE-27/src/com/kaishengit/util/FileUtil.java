package com.kaishengit.util;

import java.io.File;

public class FileUtil {

	public final static long ONE_KB = 1024;
	public final static long ONE_MB = ONE_KB * 1024;
	public final static long ONE_GB = ONE_MB * 1024;
	
	
	/**
	 * 展示多层文件夹的文件名
	 * @param path
	 */
	public static void showFile(String path) {
		File file = new File(path);

		if(file.isFile()) {
			System.out.println(file.getName());
		} else {
			File[] files = file.listFiles();
			if(files != null) {
				for(File f : files) {
					showFile(f.getAbsolutePath());
				}
			}
		}
	}
	
	/**
	 * 删除多层非空文件夹
	 * @param path
	 */
	public static void deleteFile(String path) {
		File file = new File(path);

		if(file.isFile()) {
			System.out.println(file.getName());
		} else {
			File[] files = file.listFiles();
			if(files != null) {
				for(File f : files) {
					deleteFile(f.getAbsolutePath());
				}
			}
		}
		file.delete();
	}
	
	private static int total = 0;
	/**
	 * 获得非空文件夹大小
	 * @param path
	 * @return
	 */
	public static int getFilesTotalSpace(String path) {
		File file = new File(path);

		if(file.isFile()) {
			total += file.length();
		} else {
			File[] files = file.listFiles();
			if(files != null) {
				for(File f : files) {
					getFilesTotalSpace(f.getAbsolutePath());
				}
			}
		}
		return total;
	}
	
	/**
	 * 获得字节数对应的人类可读的大小  234MB 56GB
	 * @param space
	 * @return
	 */
	public static String getReadSpace(long space) {
		
		if(space / ONE_GB > 0) {
			return space / ONE_GB + "GB";
		} else if (space / ONE_MB > 0) {
			return space / ONE_MB +"MB";
		} else if (space / ONE_KB > 0) {
			return space / ONE_KB + "KB";
		} else {
			return space + "B";
		}
		
		
	}
	
	
}
