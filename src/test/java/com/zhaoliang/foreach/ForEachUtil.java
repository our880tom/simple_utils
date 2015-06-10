package com.zhaoliang.foreach;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class ForEachUtil {
	public static void main(String[] args) {
		ArrayListMultimap<String, String> map = ArrayListMultimap.create();
		map.put("1", "2");
		map.put("1", "2");
		map.put("2", "3");
		map.put("3", "4");
		map.asMap().forEach((key,val) ->{
			val.forEach(list ->{
				System.out.println(key+""+list);
			});
		});
	}
	
	public static void Multimap2MapAndPrint(Multimap<String, String> multimap){
		multimap.asMap().forEach((key,val) ->{
			val.forEach(list ->{
				System.out.println(key+""+list);
			});
		});
	}
}
