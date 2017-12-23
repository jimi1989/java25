package com.kaishengit.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardNumberUtil {

	private static Map<Integer, Double> tmaps = new HashMap<>();

	static {
		tmaps.put(1, 63.657);
		tmaps.put(2, 9.925);
		tmaps.put(3, 5.841);
		tmaps.put(4, 4.604);
		tmaps.put(5, 4.032);
		tmaps.put(6, 3.707);
		tmaps.put(7, 3.499);
		tmaps.put(8, 3.355);
		tmaps.put(9, 3.250);
		tmaps.put(10, 3.169);
		tmaps.put(11, 3.106);
		tmaps.put(12, 3.055);
		tmaps.put(13, 3.012);
		tmaps.put(14, 2.977);
		tmaps.put(15, 2.947);
		tmaps.put(16, 2.921);
	}

	public static double getStandardNum(double[] nums){
		List<Double> lists = new ArrayList<>();
		
		for(double num : nums) {
			lists.add(num);
		}
		return getStandardNum(lists);
	}
	
	public static double getStandardNum(List<Double> numList) {
		// 排序
		Collections.sort(numList);

		// 剔除0.0
		for (int i = 0; i < numList.size(); i++) {
			if (numList.get(i) <= 0.0) {
				numList.remove(i);
			}
		}

		cleanMax(numList, numList.size() - 1);
		cleanMin(numList, 0);
		
		return getMean(numList);
	}

	private static void cleanMax(List<Double> numList,int index) {
		
		// 怀疑数据放入临时变量
		double temp = numList.get(index);
		// 去掉下标为index的值
		numList.remove(index);
		// 计算平均数
		double mean = getMean(numList);
		// 计算标准差
		double standard = getStandardDeviation(numList,mean);

		double derta = tmaps.get(numList.size()) * standard;
		
		System.out.println("平均数：" + mean + "，标准差：" + standard + ", derta:" + derta);
		
		// 对比|temp-（去掉temp后）平均值| > derta 为异常数据
		if(Math.abs(temp - mean) > derta) {
			cleanMax(numList, numList.size() - 1);
		} else {
			numList.add(temp);
		}		
	}
	
	private static void cleanMin(List<Double> numList,int index) {
		
		// 怀疑数据放入临时变量
		double temp = numList.get(index);
		// 去掉下标为index的值
		numList.remove(index);
		// 计算平均数
		double mean = getMean(numList);
		// 计算标准差
		double standard = getStandardDeviation(numList,mean);

		double derta = tmaps.get(numList.size()) * standard;
		
		System.out.println("平均数：" + mean + "，标准差：" + standard + ", derta:" + derta);
		
		// 对比|temp-（去掉temp后）平均值| > derta 为异常数据
		if(Math.abs(temp - mean) > derta) {
			cleanMin(numList, 0);
		} else {
			numList.add(0, temp);
		}		
		
	}
	

	/**
	 * 计算算数平均数
	 * 
	 * @param numList  计算算数平均数的集合
	 * 
	 * @return 算术平均数
	 */
	private static double getMean(List<Double> lists) {
		if (lists == null) {
			return 0.0;
		}

		if (lists.size() < 1) {
			return 0.0;
		}

		double sum = 0.0;
		for (Double res : lists) {
			sum += res;
		}
		return sum / lists.size();
	}

	/**
	 * 获得去掉下标为index的list集合的标准值
	 * @param numList 
	 * @param mean 算数平均值
	 * @param index 可能为异常数据的值，可能为当前数组最大值，或者最小值
	 * @return 标准值
	 */
	private static double getStandardDeviation(List<Double> numList, double mean) {

		//　计算差值平方和
		double variance = 0.0;
		for(double num : numList) {
			variance += Math.pow((num - mean), 2); //方差　＝　sum((元素值　- 平均数)^２)
		}
		
		//返回标准差＝方差的平方根=(差值平方和/n-1)的平方根
		return Math.sqrt(variance / (numList.size() - 1));
	}

}
