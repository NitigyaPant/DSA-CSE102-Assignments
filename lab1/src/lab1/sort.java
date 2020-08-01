import java.util.Scanner;

public class altitude

{
	int[] t;int a;
	altitude(int[] x,int y)
	{
		t = x;
		a = y;
	}
	public int findAltitude(int[] a,int i)
	{	
		if(a.length==1)
		{
			return time(a[0]);
		}
		if(a.length==2)
		{
			if(a[0]>a[1])
			{
				return time(a[0]);
			}
			else
			{
				return time(a[1]);
			}
		}
		else
		{
			if(i==0)
			{
			if(a[i]>a[i+1])
			{
				return time(a[i])+findAltitude(a,i+1);
			}
			else if(a[i]<a[i+1])
			{
				return findAltitude(a,i+1);
			}
			}	
		if(i==(a.length -1))
		{
			if(a[i]>a[i-1])
			{
				return time(a[i])+findAltitude(a,i+1);
			}
			else
			{
				return 0;
			}
		}	
		else
		{
			if(a[i]>a[i-1] && a[i]>a[i+1])
			{
				return time(a[i])+findAltitude(a,i+1);
			}
			else
			{
				return findAltitude(a,i+1);
			}
			}
		}
			
		}
					
		

	

			
	
	public int time(int ab)
	{
		if(1<=ab && ab<=10)
		{
			return 2;
		}
		if(11<=ab && ab<=20)
		{
			return 3;
		}
		if(21<=ab && ab<=30)
		{
			return 4;
		}
		if(31<=ab && ab<=40)
		{
			return 5;
		}
		return 6;
	}

	public static void main(String[] args) 
	{
		Scanner input1 = new Scanner(System.in);
		int number = input1.nextInt();
		int[] a = new int[number];
		for (int i = 0; i < number; i++) 
		{
			a[i] = input1.nextInt();
		}
		altitude list = new altitude(a,0);
		System.out.println(list.findAltitude(a,0));
	
	}
}
