

import java.util.Scanner;

public class Problem 
{
	public static void merge(long arr[] , long arr2[] , int l, int m, int r)
    {
        
        int n1 = m - l + 1;
        int n2 = r - m;
 
        
        long L[] = new long [n1];
        long R[] = new long [n2];
        
        long L2[] = new long [n1];
        long R2[] = new long [n2];
 
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
        
        for (int i=0; i<n1; ++i)
            L2[i] = arr2[l + i];
        for (int j=0; j<n2; ++j)
            R2[j] = arr2[m + 1+ j];

        
        int i = 0, j = 0;
 
      
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                arr2[k] = L2[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                arr2[k] = R2[j];
                j++;
            }
            k++;
        }
 
        
        while (i < n1)
        {
            arr[k] = L[i];
            arr2[k] = L2[i];
            i++;
            k++;
        }
        
        while (j < n2)
        {
            arr[k] = R[j];
            arr2[k] = R2[j];
            j++;
            k++;
        }
    }
 
    
    public static void sort(long arr[],long arr2[], int l, int r)
    {
        if (l < r)
        {
            int m = l+(r-l)/2;
 
            sort(arr,arr2, l, m);
            sort(arr ,arr2, m+1, r);
             
            merge(arr,arr2, l, m, r);
        }

    }
 
    public static void main(String args[])
    {
    	Scanner input = new Scanner(System.in);
		int test = input.nextInt();
		
		while( test > 0)
		{
			int size = input.nextInt();
			long[] list1 = new long[size];
			long[] list2 = new long[size];
			
			for(int i = 0 ; i < size ; i++)
			{
				list1[i] = input.nextLong();
				list2[i] = i+1;
			}
			
			sort(list1,list2,0,list1.length-1);
			
			
			int d = 0;
			int count = 0;
			
			for(int i = 0 ; i < list1.length ; i++)
			{
				if(d <= list1[i])
				{
					long mod = (list1[i]-d)/list2[i];
					if(mod >= 0)
					{
						d += (list2[i]*mod)+list2[i];
						//System.out.println("d="+d);
						count += mod+1;
						//System.out.println("count="+count);
					}	
				}
			}
			System.out.println(count);
			
		}
	}    
}
