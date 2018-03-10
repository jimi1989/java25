package com.kaishengit.dao;

import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kaishengit.entity.Disk;
import com.kaishengit.util.DbHelp;

public class DiskDao {

	public void save(Disk disk) {
		String sql = "insert into t_disk (name, pid, type, account_id, file_size, download_count, save_name, md5) values (?,?,?,?,?,?,?,?)";
		DbHelp.executeUpdate(sql, disk.getName(), disk.getpId(), disk.getType(), disk.getAccountId(), disk.getFileSize(), disk.getDownloadCount(), disk.getSaveName(), disk.getMd5());
	}

	public List<Disk> findListByPId(int pId) {
		String sql = "select * from t_disk where pid = ? order by type asc";
		return DbHelp.query(sql, new BeanListHandler<>(Disk.class, new BasicRowProcessor(new GenerousBeanProcessor())), pId);
	}

	public Disk findById(int id) {
		String sql = "select * from t_disk where id = ?";
		return DbHelp.query(sql, new BeanHandler<>(Disk.class, new BasicRowProcessor(new GenerousBeanProcessor())), id);
	}

	public Disk findByMd5(String md5) {
		String sql = "select * from t_disk where md5 = ?";
				return DbHelp.query(sql, new BeanHandler<>(Disk.class, new BasicRowProcessor(new GenerousBeanProcessor())), md5);
	}

	public void deleteById(int id) {
		String sql = "delete from t_disk where id = ?";
		DbHelp.executeUpdate(sql, id);
	}

}
