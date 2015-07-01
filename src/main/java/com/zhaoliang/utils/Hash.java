package com.zhaoliang.utils;

import java.nio.charset.Charset;

import com.google.common.hash.Hashing;

public class Hash{
	public String Md5(String parameter,String charset){
		return Hashing.md5().hashString(parameter , Charset.forName(charset)).toString();
	}
}