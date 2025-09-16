// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
      DoublyLinkedList sl=new DoublyLinkedList();
      sl.insert_at_begin(10);
      sl.insert_at_begin(12);
      sl.insert_at_end(5);
      sl.insert_at_end_tail(8);
      sl.insert_at_middle(2,2);
      sl.delete_at_begin();
      sl.delete_at_end();
      sl.delete_at_middle(1);
      sl.forward_display();
      System.out.println(sl.search(5));
     // sl.backward_display();
    //  sl.insert_at_middle(2,2);
    //  sl.delete_at_begin();
    //  
    //  System.out.println(sl.search(9));
    //  sl.delete_at_middle(1);
     // sl.display();
      
 }
}

class Node{
    int data;
    Node next;
    Node prev;
    Node head = null;
    Node(int data)
    {
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
class DoublyLinkedList{
  Node head=null;
    Node tail=null; 
    public void insert_at_begin(int data)
    {
    Node new_node=new Node(data);
    if(head==null)
    {
    head=new_node;
    tail=new_node;
    return;
    }
    new_node.prev=null;
    head.prev=new_node;
    new_node.next=head;
    head=new_node;
    }
    public void insert_at_end(int data)
    {
        Node new_node=new Node(data);
        if(head==null)
        {
            head=new_node;
            tail=new_node;
            return;
        }
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=new_node;
        new_node.prev=temp;
        tail=new_node;
    }
    public void insert_at_end_tail(int data)
    {
        Node new_node=new Node(data);
        if(head==null)
        {
            head=new_node;
            tail=new_node;
            return;
        }
        tail.next=new_node;
        new_node.prev=tail;
        tail=new_node;
        
    }
    public void forward_display()
    {
        if(head==null)
        {
            System.out.println("the list is empty");
        }
        Node temp=head;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }
        
        
    }
     
    public void backward_display()
    {
        if(head==null)
        {
            System.out.println("the list is empty");
        }
        Node temp=tail;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.prev;
        }
    }
    public void insert_at_middle(int pos,int data)
    {
        Node new_node=new Node(data);
        if (head==null)
        {
            head=new_node;
            return;
        }
        int count =0;
        Node curr=head;
        while(curr!=null && count<pos-1)
        {
            curr=curr.next;
            count++;
        }
        if(curr.next==null)
        {
            curr.next=new_node;
            new_node.prev=curr;
            tail=new_node;
            return;
        }
        curr.next.prev=new_node;
        new_node.prev=curr;
        new_node.next=curr.next;
        curr.next=new_node;
    }
    public void delete_at_begin()
    {
        if(head==null)
        {
            System.out.println("the list is empty");
            return;
        }
        if(head.next==null)
        {
            head=null;
            return;
        }
        head.next.prev=null;
        head=head.next;
   }
   public void delete_at_end()
   {
       if(head==null)
       {
           System.out.println("the list is empty");
           return;
       }
        if(head.next==null)
        {
            head=null;
            return;
        }
       tail=tail.prev;
       tail.next=null;
   }
   public void delete_at_middle(int pos)
   {
       if(head==null)
       {
           System.out.println("the list is empty");
       }
       if(pos==0)
       {
           head=head.next;
           return;
       }
       Node curr=head;
       Node prev=null;
       int count=0;
       while(curr!=null && count<pos)
       {
           prev=curr;
           curr=curr.next;
            count++;
       }
       if(curr==null)
       {
           System.out.println("position is greater");
           return;
       }
       prev.next=curr.next;
       curr.next.prev=prev;
       
   }
   public int search(int value)
   {
       int index=0;
       if(head==null)
       {
           System.out.println("The list is empty");
       }
       Node temp=head;
       while(temp!=null)
       {
       if(temp.data==value)
       return index;
       temp=temp.next;
       index++;
       }
       return -1;
   }
} 
