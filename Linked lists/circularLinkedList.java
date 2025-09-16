// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
      CircularLinkedList sl=new CircularLinkedList();
      sl.insert_at_begin(10);
      sl.insert_at_begin(12);
       sl.insert_at_begin(11);
        sl.insert_at_begin(13);
        sl.insert_at_end(14);
        sl.insert_at_middle(2,1);
       sl.delete_at_begin();
       sl.delete_at_end();
       sl.delete_at_middle(1);
      //System.out.println(sl.head.data);
     sl.display();
     
     // sl.backward_display();
    //  sl.insert_at_middle(2,2);
    //  sl.delete_at_begin();
    //  
    //  System.out.println(sl.search(9));
    //  
     // sl.display();
      
 }
}

class Node{
    int data;
    Node next;
    Node head = null;
    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}
class CircularLinkedList{
    Node head=null;
    public void insert_at_begin(int data)
    {
        Node new_node=new Node(data);
        if(head == null)
        {
            head=new_node;
            head.next=head;
        }
        Node last=head;
        while(last.next!=head)
        {
            last=last.next;
        }
        last.next=new_node;
        new_node.next=head;
        head=new_node;
    }
    public void display()
    {
        if(head==null)
        {
            System.out.println("the list is empty");
        }
        System.out.println(head.data);
        Node last=head.next;
        while(last!=head)
        {
            System.out.println(last.data);
            last=last.next;
        }
    }
    public void insert_at_end(int data)
    {
        Node new_node=new Node(data);
        if(head==null)
        {
            head=new_node;
            head.next=head;
        }
        Node last=head;
        while(last.next!=head)
        {
            last=last.next;
        }
        last.next=new_node;
        new_node.next=head;
        
    }
    public void insert_at_middle(int data,int pos)
    {
        Node new_node=new Node(data);
        if(head==null)
        {
            head=new_node;
            head.next=head;
            return;
        }
        if(pos==0)
        {
          this.insert_at_begin(data); 
          return;
        }
        int count=0;
        Node curr=head;
        while(curr.next!=head && count<pos-1)
        {
            curr=curr.next;
            count++;
        }
        if(curr.next==head)
        {
            this.insert_at_end(data);
        }
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
        if(head.next==head)
        {
             head=null;
             return;
        }
        Node last=head;
        while(last.next!=head)
        {
            last=last.next;
        }
        head=head.next;
        last.next=head;
    }
    public void delete_at_end()
    {
        if(head==null)
        {
            System.out.println("the list is empty");
            return;
        }
        if(head.next==head)
        {
             head=null;
             return;
        }
        Node last=head;
        Node prev=null;
        while(last.next!=head)
        {
            prev=last;
            last=last.next;
        }
        prev.next=head;
    }
    public void delete_at_middle(int pos)
    {
        if(head==null)
        {
            System.out.println("The list is empty");
            return;
        }
        if(pos==0)
        {
            this.delete_at_begin();
        }
         if(head.next==head)
        {
             head=null;
             return;
        }
        int count=0;
        Node current=head;
        Node prev=null;
        while(current.next!=head&&count<pos)
        {
            prev=current;
            current=current.next;
            count++;
        }
        if(current.next==head)
        {
            this.delete_at_begin();
        }
        prev.next=current.next;
            
            
    }

}
 