// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
       Stack s1=new Stack(5);
    //  s1.push(1);
    // s1.push(2);
    // s1.push(3);
    // System.out.println(s1.peek());
    s1.recursive(6);
    // while(!s1.isEmpty())
    // {
    //     int top=s1.pop();
    //     System.out.println(top);
    // }
    }
}
class Stack{
    int size;
    int stackArray[];
    int top;
    Stack(int size)
    {
        this.size=size;
        this.top=-1;
        this.stackArray=new int[size];
    }
    public void push(int data)
    {
        if(isFull())
        {
            System.out.println("the stack is full");
            return;
        }
        this.top++;
        this.stackArray[this.top]=data;
         
        //stackArray[++top]=data;
    }
    public boolean isFull()
    {
        return this.top==(this.size-1);
    }
  public void printData()
  {
      for(int i:this.stackArray)
  {
      System.out.println(i);
  }
  }
  public boolean isEmpty()
  {
      return this.top==-1;
  }
  public int pop()
  {
      if(isEmpty())
      {
      System.out.println("Stack underflow");
      return -1;
      }
      int data=stackArray[top--];
      return data;
      //return this.stackArray[this.top--];
      
  }
  public int peek()//it just sees the top element
  {
      if(isEmpty())
      {
          System.out.println("stack underflow");
          return -1;
      }
      return this.stackArray[this.top];
  }
  public int recursive(int n)
  {
      if(n==0)
      {
          System.out.println(0);
          return 0;
      }
      System.out.println(n);
      return recursive(n-1);
  }
  
    
}