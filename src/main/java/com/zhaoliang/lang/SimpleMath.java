package com.zhaoliang.lang;
/**
 * 
 * @author zhaoliang
 *
 */
public class SimpleMath {
	/**
	 * 二分法求平方根
	 * @param x
	 * @param epsilon
	 * @return 
	 */
	public static double squareRootBi(double x, double epsilon) {
		if (x < 0)
			throw new RuntimeException("number must > 0");
		if (epsilon < 0)
			throw new RuntimeException("epsilon must > 0");

		double low = 0;
		double high = Math.max(1, x);
		double guess = (low + high) / 2.0;
		int count = 0;

		while (Math.abs(guess * guess - x) > epsilon && count < 100) {
			if (guess * guess > x) {
				high = guess;
			} else {
				low = guess;
			}
			guess = (high + low) / 2.0;
			count++;
		}

		return guess;
	}

	/**
	 * 牛顿法求平方根
	 * @param x
	 * @param epsilon
	 * @return
	 */
	public static double squareRootNR(double x, double epsilon) {
		if (x < 0)
			throw new RuntimeException("number must > 0");
		if (epsilon < 0)
			throw new RuntimeException("epsilon must > 0");

		double guess = 1;
		int count = 0;
		while (Math.abs(guess * guess - x) > epsilon && count < 100) {
			guess = (guess + x / guess) / 2.0;
			count++;
		}
		return guess;
	}

	public static void main(String[] args) {
		System.out.println(SimpleMath.squareRootNR(0.75, 0.1));
		// java.lang.Math.sqrt(a);
	}
}
