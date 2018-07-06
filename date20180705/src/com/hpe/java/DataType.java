package com.hpe.java;

public class DataType {

	public static void main(String[] args) {

		int a = 1;
		int c = 2;
		long b = c;//自动类型转换
		float d = 4.4f;
		char e = '\\';
		
		System.out.println(e);
		
		double g = 41.1;
		//强制类型转换
		float f = (float) g;
		int h = (int) (a + 1.1);
		
		System.out.println('a' + 1);
		
		String i = "2";
		
		System.out.println(i + 1.1);
		
		int j = Integer.parseInt(i);//利用包装类对字符串类型进行转换
		
		System.out.println(j + a);
		System.out.println('a' + 1 + "abc");
	
		String k = "11.11";
		double l = Double.parseDouble(k);
		
		System.out.println(l);
		
		//++  在前 先自加后运算 在后先运算后自加
		int m = 3;
		int n = m++;
		System.out.println(n);
		
		if(++m == 4)
			System.out.println("abc");
		
		int p = 1;
		p +=2;// p = p + 2
		
		int r = 2;
		int s = 2;
		
		if(r >s & ++r == s )
			System.out.println("abc");
		System.out.println(r);
		
		//三元运算符
		 int t = 3;
		 int u = 4;
		 
		 int v = (t>u)? t+3 : u+4;
		 
		 System.out.println(v);
		
		/* //窄化转化
		 //byte short char int
		 //常量表达式
		 short aaa = 1;
		 aaa = aaa+1;//有错
		 aaa += 1;//aaa = (short)(aaa + 1)
*/	}

}
