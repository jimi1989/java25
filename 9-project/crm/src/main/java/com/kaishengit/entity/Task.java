package com.kaishengit.entity;

import java.sql.Timestamp;
import java.util.Date;

import org.joda.time.DateTime;

public class Task {

	private int id;
	private String title;
	private Date finishTime;
	private int status;
	private int accountId;
	private Timestamp createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * 判断任务是否过期
	 * @return true:已过期 false:未过期
	 */
	public boolean isOverTime() {
		DateTime dateTime = new DateTime(getFinishTime());
		return dateTime.isBeforeNow();
	}
	
}
