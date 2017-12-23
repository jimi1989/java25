package com.kaishengit.test;

public class Test {

	public static void main(String[] args) {
		
//		double[] values = {6.02,5.70,6.09,5.97,5.76,6.10,4.83,4.79,5.52,5.98,5.37,6.01,6.00,6.06,6.08,5.76};
		double[] values = {11.07,1.05,1.07,1.08,1.08,1.08,1.09,1.08,1.08,1.03,1.08,1.08,0.00,0.00,0.00,0.00};
		double res = StandardNumberUtil.getStandardNum(values);
		System.out.println(res);
	
	}
	
}
