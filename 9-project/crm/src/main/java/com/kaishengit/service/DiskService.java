package com.kaishengit.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.kaishengit.dao.DiskDao;
import com.kaishengit.entity.Disk;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.util.Config;

public class DiskService {

	DiskDao diskDao = new DiskDao();
	String filePath = Config.get("file.upload.path");
	/**
	 * 新建文件夹
	 * @param name
	 * @param pId
	 * @param accountId
	 */
	public void saveDiskDir(String name, int pId, int accountId) {
		Disk disk = new Disk();
		disk.setName(name);
		disk.setpId(pId);
		disk.setType(Disk.DISK_TYPE_FOLDER);
		disk.setAccountId(accountId);
		
		diskDao.save(disk);
	}
	/**
	 * 根据pId查询对应层级的文件和文件夹
	 * @param pId
	 * @return
	 */
	public List<Disk> findDiskListByPId(int pId) {
		
		return diskDao.findListByPId(pId);
	}
	
	/**
	 * 根据id查询对应的文件夹对象disk
	 * @param pId
	 * @return
	 */
	public Disk findDiskById(int id) {
		return diskDao.findById(id);
	}
	/**
	 * 保存上传的文件
	 * @param name
	 * @param fileSize
	 * @param parseInt
	 * @param accountId
	 */
	public void saveNewFile(String saveName, String name, long fileSize, int pId, int accountId, String md5) {
		Disk disk = new Disk();
		disk.setName(name);
		disk.setpId(pId);
		disk.setAccountId(accountId);
		disk.setFileSize(FileUtils.byteCountToDisplaySize(fileSize));
		disk.setMd5(md5);
		
		disk.setDownloadCount(Disk.INIT_DOWNLOAD_COUNT); //初始下载次数
		disk.setType(Disk.DISK_TYPE_FILE);
		// 数据库写入记录
		disk.setSaveName(saveName);
		diskDao.save(disk);
	}
	
	public void uploadFile(InputStream input, String saveName) {
		/*String md5 = "";
		try {
			md5 = DigestUtils.md5Hex(input);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// 当input二进制流进行md5加密后，该二进制将会改变
		Disk disk = diskDao.findByMd5(md5);
		if(disk == null ) {
			// 文件上传
		} */
		
		// 文件上传
		try {
			OutputStream out = new FileOutputStream(new File(filePath,saveName));
			IOUtils.copy(input, out);
			out.flush();
			out.close();
			input.close();
		} catch (IOException e) {
			throw new ServiceException("文件上传失败");
		}
	}
	
	/**
	 * 通过md5查找文件
	 * @param md5
	 * @return
	 */
	public Disk findDiskByMd5(String md5) {
		return diskDao.findByMd5(md5);
	}
	
	
	/**
	 * 保存disk
	 * @param disk
	 */
	public void saveFile(Disk disk) {
		diskDao.save(disk);
	}
	
	/**
	 * 递归删除文件或者文件夹
	 * @param id
	 * @return pid 用于回显
	 */
	public int deleteDiskById(String id) {
		if(!StringUtils.isNumeric(id)) {
			throw new ServiceException("参数异常");
		}
		
		Disk disk = diskDao.findById(Integer.parseInt(id));
		if(disk == null) {
			throw new ServiceException("参数异常");
		}
		
		deleteDisk(disk);
		return disk.getpId();
	}
	
	/**递归删除
	 * @param id
	 */
	private void deleteDisk(Disk disk) {
		List<Disk> diskList = new ArrayList<>();
		// 根据disk的id查看该文件夹下是否存在子文件和文件夹
		diskList = diskDao.findListByPId(disk.getId());
		
		for(Disk d : diskList) {
			deleteDisk(d);
		}
		
		// 删除数据库
		diskDao.deleteById(disk.getId());
		// 删除文件
		if("file".equals(disk.getType())) {
			File file = new File(filePath,disk.getSaveName());
			if(file.exists()) {
				file.delete();
			}
		}
	}

	
	
}
