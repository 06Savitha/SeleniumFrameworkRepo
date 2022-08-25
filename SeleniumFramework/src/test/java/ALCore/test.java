package ALCore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {
	 static String v   = "Savitha";
	public test() {
		
	}
	static void method()
	{
		v   = "Nethra";
		 System.out.println("v::::"+v);
		System.out.println("Static::");
	}
	static void method(String v)
	{
		v   = "Nethra";
		 System.out.println("v::::"+v);
		System.out.println("Static::");
	}
	
	void display()
	{
		int array[]=new int[3];
		array[0] = 1;
		array[1] =2;
		array[2]= 2;
		//array[3] =4;
		//array[4] =5;
		ArrayList<Integer> lt =  new ArrayList<Integer>();
		lt.add(0);
		lt.add(1);
		lt.add(2);
		lt.add(3);
		lt.add(4);
		lt.add(5);
		lt.add(6);
				
	}
	public final void name() {
		final String  name = "Nethra";
		System.out.println("Final::");
		
	}
	public final void name(String g) {
		final String  name = "Nethra";
		System.out.println("Final::");
		
	}
	public static void main(String args[])
	{
		
		
		String name2="NethraSavitha";
		char[] c= name2.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(Character c1:c)
		{
			if(map.containsKey(c1))
			{
				map.put(c1, map.get(c1)+1);
				
			}
			else {
				map.put(c1, 1);
				
			}
		
		}
			Set<Character> s =map.keySet();
			for(Character c2: s)
			{
				
				if(map.get(c2)>1)
				{
					System.out.println(c2+"::"+map.get(c2)+"times");
				}
		}
		}
		// reverse pyramid 
		
		 
			/*
			 * int rows2 = 5;
			 * 
			 * for (int i = rows2; i>= 1; i--) { for (int j = 1; j <= i; j--) {
			 * System.out.print(j+""); } System.out.println(); }
			 */
		
			 
			 
	}



