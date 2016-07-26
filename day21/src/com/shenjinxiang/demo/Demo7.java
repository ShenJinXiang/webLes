package com.shenjinxiang.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo7 {

	public static void main(String[] args) throws IOException {
		String path = "src/test.md";
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line = null;
		List<String> list = new ArrayList<String>();
		while((line = br.readLine()) != null) {
			list.add(line);
		}
		List<String> result = toHtmlList(list);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/config.html")));
		for(String l : result) {
			bw.write(l);
		}
		br.close();
		bw.flush();
		bw.close();
	}


	private static List<String> toHtmlList (List<String> list) {
		List<String> result = new ArrayList<>();
		result.add("<!doctype html>\n");
		result.add("<html>\n");
		result.add("<head>\n");
		result.add("<meta charset=utf-8>\n");
		result.add("</head>\n");
		result.add("<body>\n");
		boolean isCode = false;
		for(String line : list) {
			if(!isCode) {
				if(line != null && line.startsWith("######")) {
					result.add("<h6>" + line.substring(6).trim() + "</h6>\n");
				} else if(line != null && line.startsWith("#####")){
					result.add("<h5>" + line.substring(5).trim() + "</h5>\n");
				} else if(line != null && line.startsWith("####")){
					result.add("<h4>" + line.substring(4).trim() + "</h4>\n");
				} else if(line != null && line.startsWith("###")){
					result.add("<h3>" + line.substring(3).trim() + "</h3>\n");
				} else if(line != null && line.startsWith("##")){
					result.add("<h2>" + line.substring(2).trim() + "</h2>\n");
				} else if(line != null && line.startsWith("#")){
					result.add("<h1>" + line.substring(1).trim() + "</h1>\n");
				} else if(line != null && ("***".equals(line.trim()) || "---".equals(line.trim()))) {
					result.add("<br><hr><br>\n");
				} else if(line != null && line.startsWith("```")) {
					result.add("<pre class='line-numbers language-" + line.substring(3).trim() + "'>\n");
					result.add("<code>\n");
					isCode = true;
				} else {
					result.add(line + "\n");
				}
				
			} else {
				if(line != null && "```".equals(line.trim()) ) {
					result.add("</code>\n");
					result.add("</pre>\n");
					isCode = false;
				} else {
					result.add(line + "\n");
				}
			}
		}
		result.add("</body>\n");
		result.add("</html>");
		return result;
	}
}
