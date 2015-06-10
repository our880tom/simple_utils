package com.zhaoliang.interfacetest;

public interface TestInterface {
	void test();
	default void test2(){
		System.out.println("xxxxx");
	}
	
	default void test3(){
		
	}
}
