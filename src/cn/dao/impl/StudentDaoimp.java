package cn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dao.BaseDao;
import cn.dao.StudentDao;
import cn.entity.Student;

/*
 * @ Copyright (c) Create by JASON  Date:2018-02-10  All rights reserved.
 *
 * @ class description对图书表的操作类
 *
 */
public class StudentDaoimp extends BaseDao implements StudentDao {

	@Override
	//获取所有图书信息
	public List<Student> getAllStudent() {
		List<Student> list = new ArrayList<Student>();
		String sql = "select `id`,`name`,`age`,`sex`,`profile` from student ";
		Object[] params = {};
		ResultSet rs = this.executeQuerySQL(sql, params);
		try {
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setAge(rs.getInt("age"));
				stu.setSex(rs.getString("sex"));
				stu.setName(rs.getString("name"));
				stu.setProfile(rs.getString("profile"));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	//获取指定图书信息
	public Student getStudentMoreInfo(Student student) {
		Student stu = new Student();
		String sql = "select `name`,`age`,`sex`,`profile` from student where `id`=?";
		Object[] params = { student.getId() };
		ResultSet rs = this.executeQuerySQL(sql, params);
		try {
			while (rs.next()) {

				stu.setAge(rs.getInt("age"));
				stu.setSex(rs.getString("sex"));
				stu.setName(rs.getString("name"));
				stu.setProfile(rs.getString("profile"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stu;
	}

	@Override
	//添加图书信息
	public int addStudent(Student student) {
		int row = 0;
		String sql = "insert into student(`id`,`name`,`age`,`sex`,`profile`) values(?,?,?,?,?)";
		Object[] params = {student.getId(),student.getName(),student.getAge(),student.getSex(),student.getProfile()};
		row = this.executeUpdateSQL(sql, params);
		if(row>0){
			System.out.println("添加图书信息成功");
		}else{
			System.out.println("添加图书信息失败");
		}
		return row;
	}

	@Override
	//删除图书信息
	public int delStudent(Student student) {
		int row = 0;
		String sql = "delete from student where `id`=?";
		Object[] params = {student.getId()};
		row = this.executeUpdateSQL(sql, params);
		if(row>0){
			System.out.println("success");
		}else{
			System.out.println("erro");
		}
		return row;
	}

	@Override
	//修改图书信息
	public int modifyStudent(Student student) {
		int row = 0;
		String sql = "update student set name=?,sex=?,age=?,profile=?  where id=?";
		Object[] params = {student.getName(),student.getSex(),student.getAge(),student.getProfile(),student.getId()};
		System.out.println(student.getName());
		row = this.executeUpdateSQL(sql, params);
		if(row>0){
			System.out.println("修改图书信息成功");
		}else{
			System.out.println("修改图书信息失败");
		}
		
		return row;
	}
	
	
	//查询图书信息
	public boolean findStudent(Student student){
		boolean flag = true;
		int row = 0;
		String sql = "select count(1) from student where  `name`=? and `age`=? and `sex`=? and `profile`=?";
		Object[] params = {student.getName(),student.getAge(),student.getSex(),student.getProfile()};
		ResultSet rs = this.executeQuerySQL(sql, params);
		try {
			while(rs.next()){
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(row>0){
			System.out.println("查询图书信息成功");
			flag = true;
		}else{
			System.out.println("查询图书信息失败");
			flag = false;
		}
		
		return flag;
		
	}

	
	//娴嬭瘯
//	public static void main(String[] args) {
//		StudentDao sdao = new StudentDaoimp();
//		List<Student> list = sdao.getAllStudent();
//		for (Student stu : list) {
//
//			System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getSex() + "\t" + stu.getAge() + "\t"
//					+ stu.getGradeId() + "\t" + stu.getProfile());
//
//		}
//		Student stud = new Student();
//		stud.setId(1);
//		Student stu = sdao.getStudentMoreInfo(stud);
//		System.out.println(stu.getName() + "\t" + stu.getSex() + "\t" + stu.getAge() + "\t" + stu.getGradeId() + "\t"
//				+ stu.getProfile());
//		stud.setId(14);
//		stud.setAge(20);
//		stud.setSex("鐢�");
//		stud.setGradeId(1);
//		stud.setName("寮犱笁");
//		stud.setProfile("鎴戞槸寮犱笁锛屽ぇ濂介潚骞� ");
//		sdao.findStudent(stud);
//		sdao.addStudent(stud);
//		sdao.modifyStudent(stud);
//		sdao.delStudent(stud);

//	}

}
