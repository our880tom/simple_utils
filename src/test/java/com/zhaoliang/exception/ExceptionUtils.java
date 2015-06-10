package com.zhaoliang.exception;

public class ExceptionUtils {
	
	public void method1() throws Exception{//非运行时异常 throw 和 throws 必须同在
		throw new Exception();
	}
	
	public void method2(){
		throw new RuntimeException();
	}
	
	public void method3() throws RuntimeException{//运行时异常不需要抛出，抛出也不需要捕获
		throw new RuntimeException();
	}
	
	public static void main(String[] args) {
		ExceptionUtils u = new ExceptionUtils();
		u.method3();//运行时异常不需要捕获
		try {
			//非运行时异常必须捕获
			u.method1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
