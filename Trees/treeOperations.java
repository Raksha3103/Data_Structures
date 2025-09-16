// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        BinarySearchTree bs=new BinarySearchTree();
        bs.insert(10);
        bs.insert(3);
        bs.insert(12);
        bs.insert(2);
        bs.insert(7);
        bs.insert(4);
        bs.insert(8);
        // bs.inorder();
        // System.out.println(" ");
        // bs.preorder();
        // System.out.println(" ");
        // bs.postorder();
        // System.out.println(" ");
        bs.levelorder();
        System.out.println(bs.delete(3));
        bs.levelorder();
        
        // System.out.println(bs.search(8));
        // System.out.println(bs.root.right.value);
    }
}
class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value)
    {
        this.value=value;
        this.left=null;
        this.right=null;
    }
    
}
class BinarySearchTree{
    TreeNode root;
    BinarySearchTree()
    {
        this.root=null;
    }
    public void insert(int data)
    {
        this.root=this.insert_tree(this.root,data);
    }
    public TreeNode insert_tree(TreeNode root,int value )
    {
        if(root==null)
        {
            return new TreeNode(value);
        }
        if(value<root.value)
        {
            root.left=this.insert_tree(root.left,value);
        }
        else if(value>root.value)
        {
            root.right=this.insert_tree(root.right,value);
        }
        return root;
    }
    public boolean search(int value)
    {
        return  this.search_Tree(this.root,value);
    }
    public boolean search_Tree(TreeNode root,int value)
    {
        if(root==null)
        return false;
        else if(root.value==value)
        return true;
        else if(value<root.value)
        return this.search_Tree(root.left,value);
        else
        return this.search_Tree(root.right,value);
    }
    public void inorder()
    {
        this.inorder_tree(this.root);
    }
    public void inorder_tree(TreeNode root)
    {
        if(root!=null)
        {
            this.inorder_tree(root.left);
            System.out.println(root.value);
            this.inorder_tree(root.right);
        }
    }
    public void preorder()
    {
        this.preorder_tree(this.root);
    }
    public void preorder_tree(TreeNode root)
    {
        if(root!=null)
        {
            System.out.println(root.value);
            this.preorder_tree(root.left);
            this.preorder_tree(root.right);
        }
    }
    public void postorder()
    {
        this.postorder_tree(this.root);
    }
    public void postorder_tree(TreeNode root)
    {
        if(root!=null)
        {
            this.postorder_tree(root.left);
            this.postorder_tree(root.right);
            System.out.println(root.value);
        }
    }
    public void levelorder()
    {
        this.levelorder_tree(this.root);
    }
    public void levelorder_tree(TreeNode root)
    {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root==null)
        {
            return;
        }
        queue.offer(root);
        while(!queue.isEmpty())
        {
           TreeNode top=queue.poll();
           System.out.println(top.value);
           if(top.left!=null)
           queue.offer(top.left);
           if(top.right!=null)
           queue.offer(top.right);
        }
    }
    public TreeNode delete(int value)
    {
        return this.delete_Tree(this.root,value);
    }
    public TreeNode delete_Tree(TreeNode root,int value)
    {
        if(root==null)
        return root;
        if(value<root.value)
        {
            root.left=this.delete_Tree(root.left,value);
            return root;
        }
        else if(value>root.value)
        {
            root.right=this.delete_Tree(root.right,value);
            return root;
        }
        if(root.left==null)
        {
            return root.right;
        }
        else if(root.right==null)
        {
            return root.left;
        }
        //2children
        else
        {
             TreeNode parent=root;
              TreeNode right=root.right;
              while(right.left!=null)
              {
                  parent=right;
                  right=right.left;
              }
              if( parent!=root)
              {
                  parent.left=right.right;
              }
              else{
                  parent.right=right.left;
              }
              root.value=right.value;
              return root;
        }
    }
    
    
}