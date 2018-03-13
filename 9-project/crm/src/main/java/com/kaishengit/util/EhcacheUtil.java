package com.kaishengit.util;

import java.io.Serializable;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public class EhcacheUtil {

	private static CacheManager cacheManager = new CacheManager();
	
	/**
	 * 获得ehcache对象
	 * @param cacheName
	 * @return
	 */
	public Ehcache getEhcache(String cacheName) {
		return cacheManager.getEhcache(cacheName);
	}
	
	/**
	 * 向对应缓存对象中存储数据
	 * @param cache
	 * @param key
	 * @param value
	 */
	public void setCache(Ehcache cache, Object key, Object value) {
		Element element = new Element(key, value);
		cache.put(element);
	}
	
	public void setCache(Ehcache cache, Serializable key, Serializable value) {
		Element element = new Element(key, value);
		cache.put(element);
	}
	
	public void setCache(String cacheName, Object key, Object value) {
		Element element = new Element(key, value);
		getEhcache(cacheName).put(element);
	}
	
	public void setCache(String cacheName, Serializable key, Serializable value) {
		Element element = new Element(key, value);
		getEhcache(cacheName).put(element);
	}
	
	/**
	 * 从缓存中取值
	 * @param cache
	 * @param key
	 * @return
	 */
	public Object getCache(Ehcache cache, Object key) {
		Element element = cache.get(key);
		return element == null ? null : element.getObjectValue();
	}
	
	public Object getCache(Ehcache cache, Serializable key) {
		Element element = cache.get(key);
		return element == null ? null : element.getObjectValue();
	}
	
	public Object getCache(String cacheName, Object key) {
		Element element = getEhcache(cacheName).get(key);
		return element == null ? null : element.getObjectValue();
	}
	
	public Object getCache(String cacheName, Serializable key) {
		Element element =  getEhcache(cacheName).get(key);
		return element == null ? null : element.getObjectValue();
	}
	
	/**
	 * 根据key值删除缓存中的值
	 * @param cache
	 * @param key
	 */
	public void removeByKey(Ehcache cache, Object key) {
		cache.remove(key);
	}
	
	public void removeByKey(String cacheName, Object key) {
		getEhcache(cacheName).remove(key);
	}
	
	public void removeByKey(Ehcache cache, Serializable key) {
		cache.remove(key);
	}
	
	public void removeByKey(String cacheName, Serializable key) {
		getEhcache(cacheName).remove(key);
	}
	
	/**
	 * 删除对应缓存中所有的数据
	 * @param cache
	 */
	public void removeAll(Ehcache cache) {
		cache.removeAll();
	}
	public void removeAll(String cacheName) {
		getEhcache(cacheName).removeAll();
	}
}
