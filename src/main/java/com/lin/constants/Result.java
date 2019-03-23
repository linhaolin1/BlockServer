package com.lin.constants;

public class Result {
	public static final int OK = 0;
	public static final int ERROR_SYSTEM = 1;

	public static String getMsg(int result) {
		switch (result) {
		case OK:
			return "";
		case ERROR_SYSTEM:
			return "系统错误";
		default:
			return "";
		}
	}
}
