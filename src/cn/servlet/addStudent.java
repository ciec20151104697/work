package cn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.Student;
import cn.service.StudentService;
import cn.service.impl.StudentServiceimp;

/*
 * @ Copyright (c) Create by JASON  Date:2018-02-11  All rights reserved.
 *
 * @ class description锛氭坊鍔犲鐢熷埌鏁版嵁搴擄紝
 *
 */
public class addStudent extends HttpServlet {

	private static final long serialVersionUID = 5804433309240831094L;

	public addStudent() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		HttpServletRequest req = (HttpServletRequest) request; 
		req.setCharacterEncoding("utf-8");
		String name = request.getParameter("stuName");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("stuAge")); 
		String profile = request.getParameter("showProfile");
		
		System.out.println(name );
		
		Student stu = new Student();
		stu.setName(name);
		stu.setAge(age);
		stu.setSex(sex);
		stu.setProfile(profile);
		
		StudentService studentService = new StudentServiceimp();
		
		if(studentService.findStudent(stu)){//如果图书已经存在就不添加
			response.sendRedirect("stuList.jsp");
			
		}else{//如果图书不存在就添加
			
			String opr = request.getParameter("opr");//根据传的opr参数决定是添加图书还是修改图书
			int n = 0;
			if(opr.equals("addStu")){
				n = studentService.addStudent(stu);
			}else if(opr.equals("modifyStu")){
				int id = Integer.parseInt(request.getParameter("stuId"));
				stu.setId(id);
				n = studentService.modifyStudent(stu);
			}
			
			
			if(n>0){
				response.sendRedirect("../page/stuList.jsp");
			}else{
				response.sendRedirect("/students/page/addStu.jsp");
			}
			
		}
		
		

	}

	public void init() throws ServletException {
	}

}


