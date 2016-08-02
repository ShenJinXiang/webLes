package forLove;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Md2Html {
	
	private static CodeStatus status = CodeStatus.DEFAULT;

	public static String asHtml(String mdPath) {
		BufferedReader br = null;
		try {
			File mdFile = new File(mdPath);
			br = new BufferedReader(new FileReader(mdFile));
			String line = null;
			StringBuffer sb = new StringBuffer();
			while((line = br.readLine()) != null) {
				sb.append(handlerHtml(line));
			}
			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
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
			} else if(line.trim().length() > 4 && line.trim().startsWith("**") && line.trim().endsWith("**")) {
				return "<b>" + line.trim().substring(2, line.trim().length() - 2) + "<b>\n";
			}
			return "<p>" + line + "</p>\n";
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
		return "<p>" + line + "</p>\n";
	}
}
