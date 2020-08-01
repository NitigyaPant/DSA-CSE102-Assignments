import java.util.Scanner;

class Node
{
	Node left;
	Node right;
	int data;
	int height;
	
    public Node()
    {
        left = null;
        right = null;
        data = 0;
        height = 0;
    }
    
	public Node (int d)
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

    public int getData()
    {
        return data;
    }     
}

//class BST 
//{
//    Node root;
//    
//    public BST()
//    {
//        root = null;
//    }
//    
//    public boolean isEmpty()
//    {
//        return root == null;
//    }
//    
//    // node is root
//    public Node insert(Node node, int data)
//    {
//        if (node == null)
//            node = new Node(data);
//        else
//        {
//            if (data <= node.getData())
//                node.left = insert(node.left, data);
//            else
//                node.right = insert(node.right, data);
//        }
//        return node;
//    }
//    
//    public void postorder(Node r)
//    {
//        if (r != null)
//        {
//            postorder(r.getLeft());             
//            postorder(r.getRight());
//            System.out.print(r.getData() +" ");
//        }
//    }     
//    
//    public void inorder(Node r)
//    {
//        if (r != null)
//        {
//            inorder(r.getLeft());
//            System.out.print(r.data +" ");
//            inorder(r.getRight());
//        }
//    }
//    
//    public void preorder(Node r)
//    {
//        if (r != null)
//        {
//            System.out.print(r.getData() +" ");
//            preorder(r.getLeft());             
//            preorder(r.getRight());
//        }
//    }
//    
//    public Node minNode(Node root) 
//    {
//        if (root.left == null)
//              return root;
//        else
//              return minNode(root.left);
//  }
//    
//    public Node delete(Node root, int k)
//    {
//        if(root == null)
//        {
//        	return null;
//        }
//        if(root.data > k)
//        {
//        	root.left = delete(root.left,k);
//        }
//        else if(root.data < k)
//        {
//        	root.right = delete(root.right,k);
//        }
//        else
//        {
//        	if(root.left != null && root.right != null )
//        	{
//        		Node temp = root;	
//        		Node minRight = minNode(temp.right);
//        		root.data = minRight.data;
//        		root.right = delete(root.right,minRight.data);
//        	}
//        	else if(root.right != null)
//        	{
//        		root = root.right;
//        	}
//        	else
//        	{
//        		root = root.left;
//        	}
//        }
//        return root;
//    }
    
class AVL
{
	Node root;
	
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
			int left = root.left.height;
			int right = root.right.height;
			
			return max(left,right) + 1;
		}
	}
	
    public Node leftRotate(Node k2)
    {
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = max( height( k1.left ), k2.height ) + 1;
        
        return k1;
    }
    
    public Node rightRotate(Node k1)
    {
        Node k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = max( height( k2.right ), k1.height ) + 1;
        
        return k2;
    }
    
    public Node DoubleLeftRotate(Node k3)
    {
        k3.left = rightRotate( k3.left );
        
        return leftRotate( k3 );
    }
    
    public Node DoubleRightRotate(Node k1)
    {
        k1.right = leftRotate( k1.right );
        
        return rightRotate( k1 );
    }    
    
    public Node insert(int x, Node t) // t == root
    {
        if (t == null)
            t = new Node(x);

        else if (x < t.data)
        {
            t.left = insert( x, t.left );
            
            if( height( t.left ) - height( t.right ) == 2 )
                if( x < t.left.data )
                    t = leftRotate( t );
                else
                    t = DoubleLeftRotate( t );
        }
        else if( x > t.data )
        {
            t.right = insert( x, t.right );
            if( height( t.right ) - height( t.left ) == 2 )
                if( x > t.right.data)
                    t = rightRotate( t );
                else
                    t = DoubleRightRotate( t );
        }
        else
          ;  // Duplicate; do nothing
        t.height = max( height( t.left ), height( t.right ) ) + 1;
        
        return t;
    }
    
    private void inorder(Node r)
    {
        if (r != null)
        {
            inorder(r.left);
            inorder(r.right);
        }
    }
   
    public void Find(Node root , int min , int max)
    {
    	inorder(root);
    	
    	if(root.right == null && root.left == null)
    	{
    		int val = root.data;
    		if(val > min && val < max)
    		{
    			System.out.print(val);
    			System.out.print(" ");
    		}
    	}
    	else
    	{
    		Find(root.right ,  min ,  max);
    		Find(root.left ,  min ,  max);
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
    		System.out.println(str);
    		if(str.equals("INSERT"))
    		{
    			System.out.println(-1);
    			int insert = input.nextInt();
    			avl.insert(insert, avl.root);
    		}
    		
    		if(str.equals("FIND"))
    		{
    			int min = input.nextInt();
    			int max = input.nextInt();
    			avl.Find(avl.root, min, max);
    		}
    		test--;
    	}
    }
}
