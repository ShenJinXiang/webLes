package com.likestar.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.likestar.exam.entity.Person;

public class PersonDemo {

	/**
	 * 定义一个Person对象，并写入 person.data 文件中
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Test
	public void test1() throws FileNotFoundException, IOException {
		Person person = new Person("张三", 12, "北京", "一个好人！");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.data"));
		out.writeObject(person);
		out.flush();
		out.close();
	}
	
	/**
	 * 从person.data文件中获取数据并放入Person对象 p1中
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void test2() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.data"));
		Person p1 = (Person) in.readObject();
		System.out.println(p1);
		in.close();
	}
}
