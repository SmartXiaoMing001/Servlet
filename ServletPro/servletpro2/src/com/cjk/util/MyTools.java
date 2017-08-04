package com.cjk.util;

import java.io.UnsupportedEncodingException;

public class MyTools {
	
	//utf-8 tool!!!
	public static String getNewString(String str){
		try {
			return new String(str.getBytes("iso-8859-1"),"gb2312");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
