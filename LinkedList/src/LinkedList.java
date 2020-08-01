import java.util.Scanner;

public class LinkedList 
{
	
	static int inp;
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		int inp = input.nextInt();
		int[] list1 = new int[inp];
		int[] list2 = new int[inp];
		input.close();
		for(int i = 0;i<inp;i++)
		{
			int z = input.nextInt();
			int z2 = input.nextInt();
			list1[i] = z;
			list2[i] = z2;
		}
		
		for(int i = 0;i<list1.length;i++)
		{
			Node n  = new Node(list1[i],0);
			SLink.sLink(list2[i],n);
		}
		
	}	
	public static void dislay(Node[] n)
	{
		if(Node.link!=0)
			return;
		else
		{
			System.out.println(n);
		}
	}
}
class SLink
{
	Node n;
	int link;
	public SLink(int l,Node node)
	{
		n = node;
		link = l;
	}
	
	public static int sLink(int num,Node node)
	{
		if(LinkedList.inp>=1)
		{
			if(num==1)
			{
				node.link = num;
			}
			else if(num==2)
			{
				node.link = LinkedList.inp;
			}
			else if (num==3)
			{
				if(LinkedList.inp>=2)
				{
					if(LinkedList.inp%2==0)
						node.link = LinkedList.inp/2;
					else
						node.link = LinkedList.inp;
				}
				else
				{
					return -1;
				}	
			}
			else if(num==4)
			{
				display();	
			}
		}
		return -1;
	}		
}

class Node
{
	static int node;
	static int link;
	
	public Node(int data, int l)
	{
		node = n;
		link = l;
	}		
}