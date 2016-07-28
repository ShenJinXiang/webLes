package com.shenjinxiang.parse.main;

import com.shenjinxiang.parse.utils.Md2Html;

public class ParseMd {

	public static void main(String[] args) {
		String path = "src/test.md";
		Md2Html.asHtml(path);
	}
}
