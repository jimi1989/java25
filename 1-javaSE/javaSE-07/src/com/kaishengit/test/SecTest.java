package com.kaishengit.test;

import org.apache.commons.math3.analysis.function.Abs;
import org.apache.commons.math3.analysis.function.Sqrt;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.moment.Variance;

public class SecTest {

	public static void main(String[] args) {
		/*double[] values = new double[] { 0.33, 1.33, 0.27333, 0.3, 0.501, 0.444, 0.44, 0.34496, 0.33, 0.3, 0.292,
				0.667 };*/
//		double[] values = new double[] {1.05,1.05,1.06,1.06,1.05,1.09,1.09,1.08,1.08,1.08,1.08,1.09,1.09,1.08,1.09 };
		double[] values = new double[] {1.10,1.10,1.09,1.08,1.08,1.07,1.04,1.06,1.08,1.07,1.08,1.07,1.06,1.05,1.03,1.09 };
		
		System.out.println("数组长度N:" + values.length);

		Mean mean = new Mean(); // 算术平均值
		Variance variance = new Variance();// 方差
		StandardDeviation StandardDeviation = new StandardDeviation();// 标准差

		double meanValue = mean.evaluate(values);
		double varianceValue = variance.evaluate(values);
		double standardValue = StandardDeviation.evaluate(values);

		System.out.println("算数平均值: " + meanValue);
		System.out.println("方差：" + varianceValue);
		System.out.println("标准差s1: " + standardValue);

		System.out.println("----------------------------");
		Sqrt sqrt = new Sqrt();//平方根
		Abs abs = new Abs(); // 绝对值
		
		double t = 2.947;
		double derta = t * standardValue / sqrt.value(values.length);
		System.out.println("derta:" + derta);
		
		
		for(int i = 0; i < values.length; i++) {
			double res = abs.value(values[i] - meanValue);
			System.out.println(values[i] + "-->" + res);
			if(res > derta) {
				System.out.println(values[i] + "为异常数据 ");
			}
				
		}
		
		
	}

}
