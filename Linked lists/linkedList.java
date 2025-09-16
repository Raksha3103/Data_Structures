// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
      SinglyLinkedList sl=new SinglyLinkedList();
      sl.insert_at_begin(10);
      sl.insert_at_begin(9);
      sl.insert_at_begin(8);
     sl.insert_at_end(5);
     sl.insert_at_middle(2,2);
     sl.delete_at_begin();
     sl.delete_at_end();
     System.out.println(sl.search(9));
     sl.delete_at_middle(1);
      sl.display();
      
 }
}

class Node{
    int data;
    Node addr;
    Node head = null;
    Node(int data)
    {
        this.data=data;
        this.addr=null;
    }
}
class SinglyLinkedList{
    Node head = null;
    public void insert_at_begin(int data)
    {
        Node new_node=new Node(data);
        if(head==null)
        {
        head=new_node;
        return;
        }
        new_node.addr=head;
        head=new_node;
    }
    public void display()
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.addr;
        }
    }
    public void insert_at_end(int data)
    {
        Node new_node=new Node(data);
        if(head==null)
        {
        head=new_node;
        return;
        }
        Node temp = head;
        while(temp.addr!=null)
        {
            temp=temp.addr;
        }
        new_node.addr=null;
        temp.addr=new_node;
        
    }
    public void insert_at_middle(int data,int pos)
    {
        Node new_node=new Node(data);
        if(pos==0)
        {
           new_node.addr=head;
           head=new_node;
           return;
        }
        Node temp=head;
        int count=0;
        while(temp!=null&&count<pos-1)
        {
            temp=temp.addr;
            count++;
        }
        if(temp==null)
        {
            System.out.println("Position is out of bound");
        }
        
        new_node.addr=temp.addr;
        temp.addr=new_node;
    }
    public void delete_at_begin()
    {
        if(head==null)
        {
            System.out.println("empty llist");
            return;
        }
        head=head.addr;
        
    }
    public void delete_at_end()
    {
        if(head==null)
        {
            System.out.println("empty llist");
            return;
        }
        if(head.addr==null)
        {
            head=null;
            return;
        }
        
        Node prev=null;
        Node curr=head;
        while(curr.addr!=null)
        {
            prev=curr;
           curr=curr.addr;
           
        }
        prev.addr=null;
     }
     public void delete_at_middle(int pos)
     {
         if(head==null)
         {
             System.out.println("empty llist");
             return;
         }
         if(pos==0)
         {
             head=head.addr;
             return;
         }
         Node curr=head;
         Node prev=null;
        int count=0;
        while(curr!=null && count<=pos-1)
        {
            prev=curr;
            curr=curr.addr;
            count++;
        }
        if(curr==null)
        {
            System.out.println("the list is outof bound");
            return;
        }
        prev.addr=curr.addr;
     }
     public int search(int value)
    {
        if(head==null)
        return -1;
        if(head.addr==null && value==head.data)
        return 0;
        Node current = head;
        int pos=0;
        while(current!=null)
        {
            if(current.data==value)
            return pos;
            current=current.addr;
            pos++;
        }
        return -1;
    }
     
}
