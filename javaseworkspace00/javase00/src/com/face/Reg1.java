package com.face;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg1 {
	public static void main(String[] args) {
		String mail = "fdasfas@12.com";
		String reg = "[\\w\\._+]*\\w+@[\\w\\._]*[\\w]+\\.\\w{2,5}";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(mail);
		System.out.println(m.find());
	}
}
