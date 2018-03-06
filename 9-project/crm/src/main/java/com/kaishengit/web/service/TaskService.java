package com.kaishengit.web.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kaishengit.entity.Task;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.util.Config;
import com.kaishengit.web.dao.TaskDao;

public class TaskService {
	TaskDao taskDao = new TaskDao();
	
	public void saveTask(String taskName, String finishTime, int accountId) {
		
		Task task = new Task();
		try {
			task.setTitle(taskName);
			task.setAccountId(accountId);
			task.setStatus(Config.TASK_STATUS_UNDONE);
			
			// 将字符串按照一定的格式转化成日期
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date finishDate = format.parse(finishTime);
			// 将日期类型按照一定的格式转化成对应的字符串
			//String str = format.format(finishDate);
			
			task.setFinishTime(finishDate);
			taskDao.save(task);
		} catch (ParseException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

}
