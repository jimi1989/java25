package com.kaishengit.util;

import java.io.Serializable;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public class EhcacheUtil {

	private static CacheManager cacheManager = new CacheManager();
	
	private String cacheName;
	private Ehcache ehcache;
	
	
	public EhcacheUtil(String cacheName) {
		this.cacheName = cacheName;
	}
	
	/**
	 * 获得ehcache对象
	 * @param cacheName
	 * @return
	 */
	public Ehcache getEhcache() {
		if(ehcache == null) {
			ehcache = cacheManager.getEhcache(cacheName);
		}
		return ehcache;
	}
	
	/**
	 * 向对应缓存对象中存储数据
	 * @param cache
	 * @param key
	 * @param value
	 */
	public void setCacheValue(Object key, Object value) {
		Element element = new Element(key, value);
		getEhcache().put(element);
	}
	
	public void setCacheValue( Serializable key, Serializable value) {
		Element element = new Element(key, value);
		getEhcache().put(element);
	}
	
	/**
	 * 从缓存中取值
	 * @param cache
	 * @param key
	 * @return
	 */
	public Object getCacheValue(Object key) {
		Element element = getEhcache().get(key);
		return element == null ? null : element.getObjectValue();
	}
	
	public Object getCacheValue(Serializable key) {
		Element element = getEhcache().get(key);
		return element == null ? null : element.getObjectValue();
	}
	
	/**
	 * 根据key值删除缓存中的值
	 * @param cache
	 * @param key
	 */
	public void removeByKey(Object key) {
		getEhcache().remove(key);
	}
	
	public void removeByKey(Serializable key) {
		getEhcache().remove(key);
	}
	
	/**
	 * 删除对应缓存中所有的数据
	 * @param cache
	 */
	public void removeAll() {
		getEhcache().removeAll();
	}
}
