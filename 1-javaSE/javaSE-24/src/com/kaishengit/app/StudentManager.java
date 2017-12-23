package com.kaishengit.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kaishengit.entity.Student;

/**
 * 
 * 学生管理系统
 * 
 * @author jimi
 *
 */
public class StudentManager {

	Scanner input = new Scanner(System.in);
	List<Student> stuList = new ArrayList<>();

	public void startup() {

		System.out.println("欢迎来到学生管理系统：");
		System.out.println("1. 录入学员信息");
		System.out.println("2. 查询学员信息");
		System.out.println("3. 修改学员信息");
		System.out.println("4. 删除学员信息");
		System.out.println("5. 统计学员平均成绩");
		System.out.println("6. 退出");
		System.out.println("请选择：");

		int index = input.nextInt();

		if (1 == index) {
			save();
		} else if (2 == index) {
			find();
		} else if (3 == index) {
			modify();
		} else if (4 == index) {
			remove();
		} else if (5 == index) {
			avg();
		} else if (6 == index) {
			System.exit(0);
		} else {
			System.out.println("选择错误，请重新输入");
		}
		startup();

	}

	/**
	 * 统计学员平均成绩
	 */
	private void avg() {
		// 1.统计总成绩
		int total = 0;
		for(Student stu : stuList) {
			total += stu.getScore();
		}
		
		if(stuList.size() > 0) {
			// 2.平均成绩 = 总成绩 / 人数
			double avg = (double)total / stuList.size();
			// 3.输出平均成绩
			System.out.println("学员平均成绩为：" + avg);
		} else {
			System.out.println("学员平均成绩为：0");
		}
		
	}

	/**
	 * 删除学员信息
	 */
	private void remove() {
		// 1. 用户输入学员学号
		System.out.println("请输入学员学号：");
		String code = input.next();

		// 2.根据学号查询学员
		Student stu = findByCode(code);

		if (stu == null) {
			// 4.如果学员不存在，提示不存在
			System.out.println("查无此人");
		} else {
			stuList.remove(stu);
			System.out.println("删除成功!");
		}

	}

	/**
	 * 修改学员信息
	 */
	private void modify() {

		// 1. 用户输入学员学号
		System.out.println("请输入学员学号：");
		String code = input.next();

		// 2.根据学号查询学员
		Student stu = findByCode(code);

		if (stu == null) {
			// 4.如果学员不存在，提示不存在
			System.out.println("查无此人");
		} else {
			boolean flag = false;

			// 3.如果学员存在，提示用户选择是否修改对应信息
			System.out.println("是否要修改学员姓名(Y|N)?");
			String answer = input.next();
			if ("Y".equalsIgnoreCase(answer)) {
				System.out.println("请输入学员姓名：");
				String name = input.next();
				stu.setName(name);
				flag = true;
			}

			System.out.println("是否要修改学员年龄(Y|N)?");
			answer = input.next();
			if ("Y".equalsIgnoreCase(answer)) {
				System.out.println("请输入学员年龄：");
				int age = input.nextInt();
				stu.setAge(age);
				flag = true;
			}

			System.out.println("是否要修改学员成绩(Y|N)?");
			answer = input.next();
			if ("Y".equalsIgnoreCase(answer)) {
				System.out.println("请输入学员成绩：");
				int score = input.nextInt();
				stu.setScore(score);
				flag = true;
			}

			if (flag) {
				System.out.println("修改成功!");
			}

		}

	}

	/**
	 * 查询学员信息
	 */
	private void find() {
		// 1. 用户输入学员学号
		System.out.println("请输入学员学号：");
		String code = input.next();

		// 2.根据学号查询学员
		Student stu = findByCode(code);
		// 3.判断并提示
		if (stu == null) {
			System.out.println("查无此人");
		} else {
			System.out.println(stu);
		}
	}

	/**
	 * 录入学员信息
	 */
	private void save() {
		// 1.用户输入学员信息

		System.out.println("请输入学员学号：");
		String code = input.next(); // 内容中不能包含空格 tom hanks

		// 1.5校验学号是否存在，存在则重新输入
		Student stu = findByCode(code);

		if (stu == null) {
			System.out.println("请输入学员姓名：");
			String name = input.next();

			System.out.println("请输入学员年龄：");
			int age = input.nextInt();

			System.out.println("请输入学员成绩：");
			int score = input.nextInt();

			// 2.封装Student对象
			stu = new Student(code, name, age, score);

			// 3.添加到List集合
			stuList.add(stu);
		} else {
			System.out.println("该学号已存在,请重新输入");
			save();
		}

	}

	/**
	 * 根据学号查询对应的学员
	 * 
	 * @param code
	 *            学号
	 * @return 学号对应的student对象，如果不存在则为null
	 */
	private Student findByCode(String code) {
		for (int i = 0; i < stuList.size(); i++) {
			Student stu = stuList.get(i);
			if (stu != null && code.equals(stu.getCode())) {
				return stu;
			}
		}

		return null;
	}

}
