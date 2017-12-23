package com.kaishengit.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.analysis.function.Abs;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

public class StandardNumberUtil2 {
	
	private static Map<Integer,Double> tmaps = new HashMap<>();
	
	static {
		tmaps.put(1,63.657);
        tmaps.put(2,9.925);
        tmaps.put(3,5.841);
        tmaps.put(4,4.604);
        tmaps.put(5,4.032);
        tmaps.put(6,3.707);
        tmaps.put(7,3.499);
        tmaps.put(8,3.355);
        tmaps.put(9,3.250);
        tmaps.put(10,3.169);
        tmaps.put(11,3.106);
        tmaps.put(12,3.055);
        tmaps.put(13,3.012);
        tmaps.put(14,2.977);
        tmaps.put(15,2.947);
        tmaps.put(16,2.921);
	}
	
	public static double getStandardNum(List<Double> numList) {

		double[] nums = new double[numList.size()];
		for (int i = 0; i < numList.size(); i++) {
			nums[i] = numList.get(i);
		}
		return getStandardNum(nums);
	}

	public static double getStandardNum(double[] nums) {

		Mean mean = new Mean(); // 算术平均值
		StandardDeviation standardDeviation = new StandardDeviation();// 标准差
		
		//剔除0.0
		for(double num : nums) {
			if(num < 0.01) {
				
			}
		}
		
		double meanValue = mean.evaluate(nums);
		double standardValue = standardDeviation.evaluate(nums);

		System.out.println("算数平均值: " + meanValue);
		System.out.println("标准差s1: " + standardValue);

		List<Double> lists = new ArrayList<>();

		Abs abs = new Abs();// 绝对值
		for (double num : nums) {
			// 计算每个样本的统计量k0的值 k0 = |样本值 - 算术平均值| / 标准差
			double k0 = abs.value(num - meanValue) / standardValue;
			if (k0 < tmaps.get(nums.length)) {
				lists.add(num);
			}
		}

		// 排除异常数据之后计算算术平均值
		double res = getMeanResult(lists);

		return res;
	}

	private static double getMeanResult(List<Double> lists) {

		double sum = 0.0;
		for (Double res : lists) {
			sum += res;
		}
		return sum / lists.size();
	}

}
