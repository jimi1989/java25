package com.kaishengit.web.dao;

import com.kaishengit.entity.Task;
import com.kaishengit.util.DbHelp;

public class TaskDao {

	public void save(Task task) {
		String sql = "insert into t_task (title, finish_time, status, account_id) values (?,?,?,?)";
		DbHelp.executeUpdate(sql, task.getTitle(), task.getFinishTime(), task.getStatus(), task.getAccountId());
	}

}
