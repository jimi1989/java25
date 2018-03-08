package com.kaishengit.service;

import java.util.List;

import com.kaishengit.dao.DiskDao;
import com.kaishengit.entity.Disk;

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

}
