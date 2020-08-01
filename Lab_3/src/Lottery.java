import java.util.Scanner;


public class Lottery 
{
	public static int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		int test = input.nextInt();
		int range = 0;
		int[] a, b;
		while(test > 0)
		{
			test -= 1;
			int num = input.nextInt();
			a = new int[num]; b = new int[num];
			int x, y;
			int c = 0;
			int gmax = 0;
			for(int i = 0; i < num; i++)
			{
				x = input.nextInt();
				y = input.nextInt();
				a[i] = x;
				b[i] = y;
				range = max(range, max(x, y));
				int[] l = new int[range + 1];
				int[] r = new int[range + 1];
				for (int i = 0; i <= range; ++i) {
					l[i] = 0;
					r[i] = 0;
				}

				for (int i = 0; i < num; ++i) {
					l[a[i]] += 1;
					r[b[i]] += 1;
				}
				for (int i = 1; i <= range; ++i) {
					c += (l[i] - r[i]);
					gmax = max(gmax, c);
				}

			}
			System.out.println(gmax);
		}
	} 
}
