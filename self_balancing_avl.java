class Node
{
    int data;
    Node right;
    Node left;
    public Node(int data)
    {
        this.data=data;
        left=right=null;
    }
}
public class Main
{
    static Node left_rotate(Node x)
    {
        Node y=x.right;
        Node t=y.left;
        y.left=x;
        x.right=t;
        return y;
    }
    static Node right_rotate(Node x)
    {
        Node y=x.left;
        Node t=x.right;
        y.right=x;
        x.left=t;
        return y;
    }
    static int max(int a,int b)
    {
        if(a>b)
            return a;
        return b;
    }
    static int height(Node root)
    {
        if(root==null)
        return 0;
        int lheight=height(root.left);
        int rheight=height(root.right);
        return max(lheight,rheight)+1;
    }
    static int balance(Node root)//to check balance at left and right
    {
        if(root==null)
        return 0;
        return height(root.left)-height(root.right);
    }
    static Node create_tree(Node root,int data)
    {
        if(root==null)
        return new Node(data);
        if(data<root.data)
        root.left=create_tree(root.left,data);
        if(data>root.data)
        root.right=create_tree(root.right,data);
        int bal=balance(root);
        if(bal>1 && data<root.left.data)//left left case
        return right_rotate(root);
        if(bal<-1 && data>root.right.data)//right right case
        return left_rotate(root);
        if(bal>1 && data>root.left.data)//lr case
        {
            root.left=left_rotate(root.left);
            return right_rotate(root);
        }
        if(bal<-1 && data<root.left.data)//rl case
        {
            root.right=right_rotate(root.right);
            return left_rotate(root);
        }
        return root;
    }
    static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args)
    {
        Node root=null;
        root=create_tree(root,10);
        return y;
        root=create_tree(root,20);
        root=create_tree(root,30);
        root=create_tree(root,40);
        root=create_tree(root,50);
        root=create_tree(root,80);
        inorder(root);
        System.out.println(root.data);
    }
}


