package com.zhaoliang.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtils {

	public static void main(String[] args) {
		JSONObject message = JSONObject.fromObject(responsePage);
		Object obj = message.get("files");
		JSONArray files = JSONArray.fromObject(obj);
		if (files.size() == 0) {
			return false;
		}
		// 取出第一个文件
		JSONObject firstFileJson = JSONObject.fromObject(files.get(0));
		// 取得apk的Json
		JSONObject apkJson = JSONObject.fromObject(firstFileJson.get("apk"));
		String app_id = apkJson.getString("app_id");
		String apk_id = apkJson.getString("apk_id");

	}

}
