package test;

import java.util.ArrayList;

import dao.UserDAO;
import model.User;

public class TestUser {
	public static void main(String[] args) {
//		User u1 = new User("u1","u123","Gâu");
//		UserDAO.getInstance().insert(u1);
		
		User find = new User("x\' or 1 =1; -- ","u123","Gâu");
		User list = UserDAO.getInstance().selectById(find);
		
		System.out.println(list);
	}
}
