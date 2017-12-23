package com.kaishengit.test;

import com.kaishengit.util.FileUtil;

public class Test {

	public static void main(String[] args) {
		
		int totalSpace = FileUtil.getFilesTotalSpace("d:/img");
		System.out.println("total:" + FileUtil.getReadSpace(totalSpace));
		System.out.println("end");
//		File file = new File("d:/jars");
		
		/*boolean res = file.mkdirs();
		System.out.println(res);*/
		
		/*File[] files = file.listFiles();
		
		for(File f : files) {
			if(f.isFile()){
				System.out.println(f.getName());
			} else {
				System.out.println("["+f.getName()+"]");
			}
		}*/
		
		
		/*String[] names = file.list();
		for(String name : names) {
			File subFile = new File(file, name); 
			if(subFile.isFile()) {
				System.out.println(name);
			} else {
				System.out.println("["+name+"]");
			}
		
		}*/
		
		
//		File file = new File("d:/img/1.txt");
//		
//		System.out.println(file.length()); // 文件大小
		
		// 作业：把字节数转化成人类可读的大小 23MB  145GB
//		System.out.println(file.getFreeSpace()); // 可用大小
//		System.out.println(file.getTotalSpace()); // 总大小
		
//		System.out.println(file.isFile());
//		System.out.println(file.isDirectory());
//		System.out.println(file.isHidden());
		
		
		
		
		
		// 存在则删除
		/*if(file.exists()) {
			file.delete();
		}
		
		try {
			boolean res = file.createNewFile();
			System.out.println(res);
		} catch(IOException e) {
			e.printStackTrace();
		}*/
		
//		System.out.println(file.getName()); // 文件名
//		System.out.println(file.getAbsolutePath()); // 文件全路径
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		boolean res = file.delete();
//		System.out.println("res:" + res);
		
		
		
//		File file= new File("d:/jars/abcd.mp3");
//		File file = new File("d:/jars","abc.mp3");
		
//		File file = new File("d:/jars");
//		File subFile = new File(file, "abc.mp3");
		
//		System.out.println(file.canRead());
//		System.out.println(file.canWrite());
//		System.out.println(file.canExecute());
		
		
		
		
		
		
		
		
		//win
//		String path = "D:\\wopit";
//		System.out.println(path);
		// linux and win
//		String path = "d:/topit";
//		System.out.println(path);
	}

}
