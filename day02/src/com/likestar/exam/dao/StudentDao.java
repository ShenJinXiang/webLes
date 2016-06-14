package com.likestar.exam.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.likestar.exam.entity.Student;
import com.likestar.exam.exceptions.StudentNotException;
import com.likestar.utils.XMLUtils;

public class StudentDao implements IStudentDao{

	@Override
	public void addStu(Student stu) {
		try {
			Document document = XMLUtils.getDocument();
			
			Element student = document.createElement("student");
			student.setAttribute("idcard", stu.getIdcard());
			student.setAttribute("examid", stu.getExamid());
			Element name = document.createElement("name");
			Element location = document.createElement("location");
			Element grade = document.createElement("grade");
			
			name.setTextContent(stu.getName());
			location.setTextContent(stu.getLocation());
			grade.setTextContent(stu.getGrade() + "");
			
			student.appendChild(name);
			student.appendChild(location);
			student.appendChild(grade);
			
			document.getDocumentElement().appendChild(student);
			
			XMLUtils.writeXML(document);
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Student findByExamId(String examid) {
		try {
			Document document = XMLUtils.getDocument();
			NodeList list = document.getElementsByTagName("student");
			for(int i = 0; i < list.getLength(); i++) {
				Element student = (Element) list.item(i);
				if(student.getAttribute("examid").equals(examid)) {
					Student stu = new Student();
					stu.setExamid(examid);
					stu.setIdcard(student.getAttribute("idcard"));
					stu.setName(student.getElementsByTagName("name").item(0).getTextContent());
					stu.setLocation(student.getElementsByTagName("location").item(0).getTextContent());
					stu.setGrade(Double.parseDouble(student.getElementsByTagName("grade").item(0).getTextContent()));
					return stu;
				}
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delStudentByName(String name) throws StudentNotException {
		try {
			Document document = XMLUtils.getDocument();
			NodeList list = document.getElementsByTagName("name");
			for(int i = 0; i < list.getLength(); i++){
				if(list.item(i).getTextContent().equals(name)) {
					list.item(i).getParentNode().getParentNode().removeChild(list.item(i).getParentNode());
					XMLUtils.writeXML(document);
					return;
				}
			}
			throw new StudentNotException(name + "不存在");
		} catch (StudentNotException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
}
