package ALCore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Test1 extends test {
	
	
	public static void main(String args[])
	{
		 int rows = 5;

		    for (int i = 1; i <= rows; i++) {
		      for (int j = 1; j <= i; j++) {
		        System.out.print(j+"");
		      }
		      System.out.println();
		    }
		//Pyramid 
		   int rows1 = 5;

		    for (int i = 1; i <= rows1; i++) {
		      for (int j = 1; j <= i; j++) {
		        System.out.print("*");
		      }
		      System.out.println();
		    }
		  
		   
		// Collection - find duplicate char
				String newName="automationi";
				char[] ch = newName.toCharArray();
				HashMap<Character, Integer> map = new HashMap<Character, Integer>();
				for(Character ch1:ch)
				{
					if(map.containsKey(ch1))
					{
						//System.out.println("Map::"+map.containsKey(ch1));
						map.put(ch1, map.get(ch1)+1);
						//System.out.println("map1::"+map.put(ch1, map.get(ch1)+1));
					}
					else
					{
						map.put(ch1, 1);
						//System.out.println("map2::"+map.put(ch1, 1));
					}
				}
				Set<Character> s = map.keySet();
				for(Character ch2 : s)
				{
					if(map.get(ch2)>1)
					{
						System.err.println(ch2+"::"+map.get(ch2)+"time");
					}
				}
				/*
				 * for(Entry<Character, Integer> entry: map.entrySet()) {
				 * if(entry.getValue()>=1) {
				 * System.out.println("entry::"+entry.getKey()+"::"+entry.getValue()); } }
				 */
				
				//List to map conversion 
			List<String> list1 = new ArrayList<String>();		
			list1.add("s");
			list1.add("d");
			HashMap<String, String> map1= new HashMap<>();
			 for(String c1: list1)
			 {
				map1.put(c1, "t");
				System.out.println("map1::"+map1.put(c1, null));
			 }
			 //query 
				/*
				 * select max(salary) from emp_detail where salary NOT IN(select Max(salary)
				 * from emp_detail) select salary from emp_detail group by salary order by
				 * salary desc limit 1,1
				 */
			
				
		//reverse String using builder
		String str = "Savitha";
		StringBuilder build = new StringBuilder(str);
		build.reverse();
		System.out.println("Builder::"+build.toString());
		
		//reverse string using without builder 
		int count1=0;
		char c[]=str.toCharArray();
		for(int i =c.length-1;i>=0;i--)
		{
			String value ="";
			value +=c[i];
			System.out.println("Value::"+value);
			
		}
		
		
		// Find the Repeated char ------------------>Correct 
		

		 String str2 = "w3schools";
		  int cnt2 = 0;
		  char[] c5 = str2.toCharArray();
		
		for(int j =0; j<str2.length();j++)
		{
			for(int k =j+1; k<str2.length();k++)
			{
				if(c5[j]==c5[k])
				{
					System.out.println("Duplicate record:"+c5[k]);
					
					
				}
			}
		}
		System.out.println("Replace"+str2.replaceAll("s","xz"));
		System.out.println("Replace"+str2.replaceAll("r(.*)","xz"));
		
		
		String n = "NethraE";
		String v="";
		char[] c1=n.toCharArray();
		for(int i = c1.length-1;i>=0;i--)
		{
			v+=c1[i];
			System.out.println("V::::"+v);
		}
			
		StringBuilder st=new StringBuilder(n);
		st.reverse();
		System.out.println("ST:::"+st.toString());
		int count=0;
		String n1 = "savithavairamani";
		char[] c3 = n1.toCharArray();
		System.out.println("Count Actual::"+n1.length());
		for(int i=0;i<=n1.length()-1;i++)
		{
			for(int j=i+1;j<=n1.length()-1;j++)
			{
				if(c3[i]==c3[j])
				{
					System.out.println("C1 duplicate::::"+c3[j]);
					count++;
					
				}
				System.out.println("Count ::"+count);
			}
		}
			
			
		
			
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1234567890);
		list.add(2);
		int i;
		for( i = 0;i<list.size();i++);
		{
		
		System.out.println("List::"+list.get(0));
		int count2=list.get(0);
		System.out.println("Count::"+count);
		count -=5;
		System.out.println("NewCount::"+count);
		}
		
		ArrayList < String > list2 = new ArrayList < String > ();
		list1.add("rabbit");
		list1.add("bribe");
		list1.add("dog");
		  System.out.print("The given strings are: ");
		  
		  
		test.method();
		test t = new test();
		t.display();
		t.name();
		
	}

}
