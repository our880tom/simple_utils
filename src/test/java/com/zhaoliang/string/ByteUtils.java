package com.zhaoliang.string;

import java.io.UnsupportedEncodingException;

public class ByteUtils{
	public static void main(String[] args) {
		String s = "ÎÒµÄ";
		try {
			System.out.println(s.getBytes("GBK").length);
		} catch (UnsupportedEncodingException e) {
		}
	}
}
