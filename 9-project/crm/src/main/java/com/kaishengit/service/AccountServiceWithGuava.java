package com.kaishengit.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.kaishengit.dao.AccountDao;
import com.kaishengit.entity.Account;

public class AccountServiceWithGuava {

	private static AccountDao accDao = new AccountDao();
	private static LoadingCache<Integer, Account> cache = CacheBuilder
			.newBuilder()
			.maximumSize(100)
			.expireAfterWrite(10, TimeUnit.SECONDS)
			.build(new CacheLoader<Integer, Account>() {
				// 当缓存中不存在该对象时，需要做什么（从db中获取）
				@Override
				public Account load(Integer id) {
					return accDao.findById(id);
				}
				
			});
			
	
	
	public Account findById(int accountId) {
//		return accDao.findById(accountId);
		return cache.getUnchecked(accountId);
	}
	
}
