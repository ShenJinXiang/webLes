package com.likestar.exam.junit.test;

import org.junit.Test;

import com.likestar.exam.dao.IStudentDao;
import com.likestar.exam.dao.StudentDao;
import com.likestar.exam.entity.Student;
import com.likestar.exception.StudentNotException;

/**
 * 
 * StudentDao 测试
 * @author ShenJinXiang
 *
 */
public class StudentDaoTest {

	@Test
	public void addTest() {
		IStudentDao stuDao = new StudentDao();
		Student stu = new Student();
		stu.setExamid("555");
		stu.setGrade(83);
		stu.setIdcard("222");
		stu.setLocation("太原");
		stu.setName("刘备");
		stuDao.addStu(stu);
	}
	
	@Test
	public void findTest() {
		IStudentDao stuDao = new StudentDao();
		Student stu = stuDao.findByExamId("555");
		System.out.println(stu);
	}
	
	@Test
	public void delTest() {
		IStudentDao stuDao = new StudentDao();
		try {
			stuDao.delStudentByName("刘备");
			System.out.println("删除成功！");
		} catch (StudentNotException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
