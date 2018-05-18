package com.zhuzz.classload;

public class Tset {
	 final String i;
	static String a;
	{
		i=new String("111");
	}
	public static void main(String[] args) {
		System.out.println(a);
		Father [] a = new Father[9];
		/*Tset.name();
		Tset c = new Tset("1");
		c.name1();*/
		//System.out.println(Tset.i);
	}
	/*private static Tset x= new Tset();
	
	public static void name() {
		System.out.println(i);
	}
	public  void name1() {
		System.out.println("动态方法");
	}
	
	Tset(){
		System.out.println("构造函数");
	}
	static{
		System.out.println("jingtai块");
	}
	
	{
		System.out.println("动态块");
	}
	private int axx=3;
	
	
	static{
		System.out.println("静态块");
	}
	
	private static int i=3;*/
}
