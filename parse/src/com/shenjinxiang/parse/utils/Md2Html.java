package com.shenjinxiang.parse.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.shenjinxiang.parse.core.CodeStatus;

public class Md2Html {
	
	private static CodeStatus status = CodeStatus.DEFAULT;
	
	public static void asHtml(String mdPath) {
		BufferedReader br = null;
		OutputStreamWriter os = null;
		try {
			File mdFile = new File(mdPath);
			String fileName = mdFile.getName();
			String path = mdFile.getParentFile().getAbsolutePath();
			String htmlFilePath = path + File.separator + fileName.substring(0, fileName.lastIndexOf(".")) + ".html";
			File htmlFile = new File(htmlFilePath);
			if(!htmlFile.exists()) {
				htmlFile.createNewFile();
			}
			br = new BufferedReader(new FileReader(mdFile));
			os = new OutputStreamWriter(new FileOutputStream(htmlFile), "utf-8");
			String line = null;
			List<String> mdList = new ArrayList<String>();
			while((line = br.readLine()) != null) {
				mdList.add(line);
			}
			List<String> htmlList = getHtml(mdList);
			for(String html : htmlList) {
				os.write(html);
				
			}
			os.flush();
		} catch (FileNotFoundException e) {
			System.out.println("md文件未找到");
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("md关闭错误");
				}
			}
			
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static List<String> getHtml(List<String> mdList) {
		List<String> list = new ArrayList<String>();
		list.add("<!doctype html>");
		list.add("<html>\n");
		list.add("<head>\n");
		list.add("<meta charset='utf-8'>\n");
		list.add("</head>\n");
		list.add("<body>\n");
		for(String line : mdList) {
			list.add(handlerHtml(line));
		}
		list.add("</body>\n");
		list.add("</html>\n");
		
		return list;
	}

	private static String handlerHtml(String line) {
		if(status == CodeStatus.DEFAULT) {
			if(line.startsWith("######")) {
				return "<h6>" + line.substring(6).trim() + "</h6>\n";
			} else if(line.startsWith("#####")) {
				return "<h5>" + line.substring(5).trim() + "</h5>\n";
			} else if(line.startsWith("####")) {
				return "<h4>" + line.substring(4).trim() + "</h4>\n";
			} else if(line.startsWith("###")) {
				return "<h3>" + line.substring(3).trim() + "</h3>\n";
			} else if(line.startsWith("##")) {
				return "<h2>" + line.substring(2).trim() + "</h2>\n";
			} else if(line.startsWith("#")) {
				return "<h1>" + line.substring(1).trim() + "</h1>\n";
			} else if("---".equals(line.trim()) || "***".equals(line.trim())) {
				return "<br><hr><br>\n";
			} else if(line.trim().startsWith("```")) {
				status = CodeStatus.CODE;
				return "<pre class='line-number language-" + line.trim().substring(3).trim() + "'>\n<code>\n";
			} else if(line.trim().length() >= 2 && line.trim().charAt(0) == '*' && line.trim().charAt(1) != '*') {
				status = CodeStatus.UL;
				return "<ul>\n<li>" + line.trim().substring(1) + "</li>\n";
			}
			return line + "\n";
		} else if(status == CodeStatus.CODE) {
			if(line.trim().equals("```")) {
				status = CodeStatus.DEFAULT;
				return "</code>\n</pre>\n";
			}
			return line + "\n";
		} else if(status == CodeStatus.UL) {
			if(line.length() == 0) {
				status = CodeStatus.DEFAULT;
				return "</ul>\n";
			}
			if(line.trim().startsWith("*")) {
				return "<li>" + line.trim().substring(1) + "</li>\n";
			}
			return "<li>" + line.trim() + "</li>\n";
		}
		return line + "\n";
	}
}
