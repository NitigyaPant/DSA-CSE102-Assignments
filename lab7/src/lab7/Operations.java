package lab7;
import java.util.Scanner;


public class Operations
{
	public static boolean check(long[] list)
	{
		int p = 1;
		for(int i = 0 ; i < list.length ; i++)
		{
			if(list[i] >= 0)
			{
				p = 0;
			}
		}
		
		if(p == 1)
		{
			return false;
		}
		return true;
	}
	
	public static int min(long[] list)
	{
		long min = 0;
		int index = 1;
		
		for(int i = 0 ; i < list.length ; i++)
		{
			if(list[i]>0)
				min = list[i];
			else
				index++;
			
			if(list[i] < min)
			{
				min = list[i];
				index = i+1;
			}
		}
		return index;
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int test = input.nextInt();
		
		while( test > 0)
		{
			int size = input.nextInt();
			long[] list = new long[size];
			
			for(int i = 0 ; i < size ; i++)
			{
				list[i] = input.nextLong();
			}
			
			int count = 0;
			
			while(check(list))
			{
				for(int i = 0 ; i < list.length ; i++)
				{
					list[i] = list[i] - min(list);
					//System.out.print(list[i] + " ");
				}
				count++;
			}					
			test--;
			System.out.println(count);
		}
	}
}
