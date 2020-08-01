public class Selection 
{
	public void sort(int[] list)
	{
		int l = list.length;
		for(int i=0;i<l-1;i++)
		{
			for(int k=i+1;k<l-1;i++)
			{
				if(list[i]>list[k])
				{
					int c = list[i];
					list[i]=list[k];
					list[k]=c;
				}
				else
				{
					continue;
				}
			}
			
		}
	}
	public static void main(String[] args)
	{
		int[] list = {1,5,2,3,21,12};
		Selection s = new Selection();
		s.sort(list);
		System.out.print(list);
	}
	
}
