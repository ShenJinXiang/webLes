package com;

import com.qysoft.utils.Base64Util;

public class demo {

	public static void main(String[] args) {
		String str = "57qz56iO5Lq66K+G5Yir5Y+3ezkxMTQwMjAwNzE1OTUxODExQ33kuI3lkIjms5XmiJbmsqHmnInphY3nva7vvIE=";
		String result = Base64Util.decode(str);
		System.out.println(result);
	}
}
