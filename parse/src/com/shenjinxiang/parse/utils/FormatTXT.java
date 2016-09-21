package com.shenjinxiang.parse.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class FormatTXT {

	public static void format(String mdPath) {
		BufferedReader br = null;
		OutputStreamWriter os = null;
		try {
			File mdFile = new File(mdPath);
			String fileName = mdFile.getName();
			String path = mdFile.getParentFile().getAbsolutePath();
			String htmlFilePath = path + File.separator + fileName.substring(0, fileName.lastIndexOf(".")) + ".txt";
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
			List<String> htmlList = getTxt(mdList);
			for(String html : htmlList) {
				os.write(html);
				System.out.println(html);
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

	private static List<String> getTxt(List<String> mdList) {
		List<String> list = new ArrayList<String>();
		for(int index = 0; index < mdList.size(); index++) {
			System.out.println("index -> " + (index + 1));
			list.add(handlerTxt(mdList.get(index)));
		}
		return list;
	}

	private static String handlerTxt(String line) {
		if("".equals(line)) {
			return line + "\n";
		}
		if(!line.startsWith("NC_")) {
			return line + "\n";
		}
		if(line.indexOf("Name=") != line.lastIndexOf("Name=")) {
			String line1 = line.substring(0, line.lastIndexOf("Name="));
			String line2 = (line.indexOf(";", line.lastIndexOf("Name=") + 1) == -1) ? "" :line.substring(line.indexOf(";", line.lastIndexOf("Name=") + 1));
			return line1 + line2 + "\n";
		}
		
		return line + "\n";
	}
	
	public static void main(String[] args) {
		String line = "NC_008054	GenBank	gene	3217	3450	.	+	1	ID=Ldb0003;Name=Ldb0003;Dbxref=GeneID:4084477;Name=Ldb0003";
		String line1 = line.substring(0, line.lastIndexOf("Name="));
		String line2 = (line.indexOf(";", line.lastIndexOf("Name=") + 1) == -1) ? "" :line.substring(line.indexOf(";", line.lastIndexOf("Name=") + 1));
		String str = line1 + line2;
		System.out.println(line);
		System.out.println(str);
	}

}
