import java.util.Scanner;

class Node
{
	Node left;
	Node right;
	long data;
	int height;
	
    public Node()
    {
        left = null;
        right = null;
        data = 0;
        height = 0;
    }
    
	public Node (long d)
	{
		data = d;
		left = null;
		right = null;
		height = 0;
	}
	
	public Node(Node n)
	{
		right = n;
	}
	
    public void setLeft(Node n)
    {
        left = n;
    }

    public void setRight(Node n)
    {
        right = n;
    }

    public Node getLeft()
    {
        return left;
    }

    public Node getRight()
    {
        return right;
    }

    public void setData(int d)
    {
        data = d;
    }

    public long getData()
    {
        return data;
    }     
}
    
class AVL
{
	Node root;
	boolean flag = false;
	
	public AVL()
	{
		root = null;
	}
	
	public int max(int a ,int b)
	{
		if(a >= b)
		{
			return a;
		}
		else
		{
			return b;
		}
	}
	
	public int height(Node root)
	{
		if(root == null)
		{
			return 0;
		}
		else
		{	
			return root.height;
		}
	}
	
    public Node rightRotate(Node k2)
    {
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        return k1;
    }
    
    public Node leftRotate(Node k1)
    {
        Node k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = max( height( k2.right ), height( k2.left ) ) + 1;
        return k2;
        
       
    }
    
    public Node DoubleLeftRotate(Node k3)
    {
        k3.left = leftRotate( k3.left );
        
        return rightRotate( k3 );
    }
    
    public Node DoubleRightRotate(Node k1)
    {
        k1.right = rightRotate( k1.right );
        
        return leftRotate( k1 );
    }    
    
    public Node insert(long x, Node t) // t == root
    {
        if (t == null)
            t = new Node(x);
        else if (x < t.data)
        {
            t.left = insert( x, t.left );
            if( height( t.left ) - height( t.right ) >= 2 )
                if( x < t.left.data )
                    t = rightRotate( t );
                else
                    t = DoubleLeftRotate( t );
        }
        else if( x > t.data )
        {
            t.right = insert( x, t.right );
            if( height( t.right ) - height( t.left ) >= 2 )
                if( x > t.right.data)
                    t = leftRotate( t );
                else
                    t = DoubleRightRotate( t );
        }
        	
        t.height = max( height( t.left ), height( t.right ) ) + 1;

        return t;
    }
    
    public Node balance(int x , Node t)
    {
    	if( height( t.left ) - height( t.right ) >= 2 )
            if( x < t.left.data )
            {
            	System.out.println("vwecwdc");
            	t = leftRotate( t );
            }
              
            else
                t = DoubleLeftRotate( t );
        
        else if( height( t.right ) - height( t.left ) >= 2 )
            if( x > t.right.data)
                t = rightRotate( t );
            else
                t = DoubleRightRotate( t );
    	return t;
    
    }
    
    public void Find(Node root , long min , long max)
    {
    	if (root != null)
        {
    		//System.out.print("LKLKNLK");
    		Find(root.left ,  min ,  max);
    		if(root.right == null && root.left == null)
        	{
        		long val = root.data;
        		if(val >= min && val <= max)
        		{
        			//System.out.print("LKLKNLK");
        			System.out.print(val);
        			System.out.print(" ");
        			
        			flag = true;
        		}
        	}        	
        	Find(root.right ,  min ,  max);
        }    	
    }
       	
    
    public static void main(String[] args)
    {
    	AVL avl = new AVL();
    	
    	Scanner input = new Scanner(System.in);
    	int test = input.nextInt();
    	while(test > 0)
    	{
    		String str = input.next();
    		if(str.equals("INSERT"))
    		{
    			int insert = input.nextInt();
    			avl.root = avl.insert(insert, avl.root);
    			//avl.root = avl.balance(insert, avl.root);
    			//System.out.println(-111);
    			//System.out.println(avl.root.data);
    		}
    		
    		if(str.equals("FIND"))
    		{
    			long min = input.nextLong();
    			long max = input.nextLong();
    			
    			avl.Find(avl.root, min, max);
    			
    			if( avl.flag == false)
    			{
    				System.out.println(-1);
    			}
    			avl.flag = false;
    			//System.out.println(avl.root.data);
    		}
    		
    		test--;
    	}input.close();
    }
}