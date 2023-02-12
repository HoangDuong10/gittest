package test;

import java.util.ArrayList;

import dao.SachDAO;
import model.Sach;

public class TestSachDAO {
	public static void main(String[] args) {
		/*
		Sach sach1 = new Sach("LTJV","Lập trình Java",5000,1990);
		Sach sach2 = new Sach("LTC","Lập trình",2000,2025);
		Sach sach3 = new Sach("LTCC","Lập trình c",25000,2021);
		SachDAO.getInstance().insert(sach1);
	 	  
		Sach sach1 = new Sach("LTJV","Lập trình Java",75000,1990);
		Sach sach2 = new Sach("LTC","Lập trình",22000,2025);
		SachDAO.getInstance().update(sach2);
		 
		Sach sach1 = new Sach("LTJV","Lập trình Java",75000,1990);
		SachDAO.getInstance().delete(sach1);
		 
		ArrayList<Sach> list = SachDAO.getInstance().selectAll();
		for (Sach sach : list) {
			System.out.println(sach.toString());
		}
		Sach find = new Sach("LTJV","Lập trình Java",5000,1990);
		Sach sach2 = SachDAO.getInstance().selectById(find);
		System.out.println(sach2);
		*/
		ArrayList<Sach> list1 = SachDAO.getInstance().selectbyCondition("giaban>23000");
		for (Sach sach : list1) {
			System.out.println(sach);
		}
	}
}
