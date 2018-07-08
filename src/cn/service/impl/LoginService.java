package cn.service.impl;

import cn.entity.LoginBean;
import cn.dao.impl.LoginDao;

public class LoginService {
	
	public LoginBean LoginValidate(String username, String pwd) {
		// TODO Auto-generated method stub
		LoginBean loginbean = new LoginBean();
		//System.out.println(loginbean);
		loginbean.setName(username);
		loginbean.setPwd(pwd);
		LoginDao ld = new LoginDao();
		LoginBean rs = ld.login(loginbean);
		return rs;
	}
	public LoginBean RegisternValidate(String username, String pwd) {
		// TODO Auto-generated method stub
		LoginBean loginbean = new LoginBean();
		//System.out.println(loginbean);
		loginbean.setName(username);
		loginbean.setPwd(pwd);
		LoginDao ld = new LoginDao();
		LoginBean rs = ld.addUser(loginbean);
		return rs;
	}
}
