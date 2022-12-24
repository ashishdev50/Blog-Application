package com.example.SpringPractice.Gobal;

import java.util.ArrayList;
import java.util.List;

import com.example.SpringPractice.Entity.Blog;



public class GlobalData {
	public static List<Blog> cart;
	
	static {
		cart = new ArrayList<Blog>();
	}
	

}
