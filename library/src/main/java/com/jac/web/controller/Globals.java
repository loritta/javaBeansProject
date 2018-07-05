package com.jac.web.controller;
import com.jac.web.dao.DB;

public class Globals {
	public static boolean IsAuthorized = false;
	public static boolean IsAdmin = false;
	public static String FullName = "";
	public static DB db = new DB();
}
