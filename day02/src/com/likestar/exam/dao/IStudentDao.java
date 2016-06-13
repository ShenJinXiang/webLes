package com.likestar.exam.dao;

import com.likestar.exam.entity.Student;
import com.likestar.exception.StudentNotException;

public interface IStudentDao {

	/**
	 * 添加学生
	 * @param stu
	 */
	public void addStu(Student stu);
	
	/**
	 * 查找
	 * @param examid
	 * @return
	 */
	public Student findByExamId(String examid);
	
	/**
	 * 删除
	 * @param name
	 */
	public void delStudentByName(String name) throws StudentNotException;
}
