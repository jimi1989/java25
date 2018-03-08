package com.kaishengit.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.kaishengit.dao.DiskDao;
import com.kaishengit.entity.Disk;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.util.Config;

public class DiskService {

	DiskDao diskDao = new DiskDao();
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
	public void saveNewFile(InputStream input, String name, long fileSize, int pId, int accountId) {
		Disk disk = new Disk();
		disk.setName(name);
		disk.setpId(pId);
		disk.setAccountId(accountId);
		disk.setFileSize(FileUtils.byteCountToDisplaySize(fileSize));
		
		disk.setDownloadCount(Disk.INIT_DOWNLOAD_COUNT); //初始下载次数
		disk.setType(Disk.DISK_TYPE_FILE);

		// 文件上传
		String saveName = UUID.randomUUID() + name.substring(name.lastIndexOf("."));
		String filePath = Config.get("file.upload.path");
		try {
			OutputStream out = new FileOutputStream(new File(filePath,saveName));
			IOUtils.copy(input, out);
			out.flush();
			out.close();
			input.close();
		} catch (IOException e) {
			throw new ServiceException("文件上传失败");
		}
		
		// 数据库写入记录
		disk.setSaveName(saveName);
		diskDao.save(disk);
	}

}
