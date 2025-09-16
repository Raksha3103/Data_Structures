// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        CircularQueue q=new CircularQueue(5);
        q.enqueue(8);
        q.enqueue(9);
        q.enqueue(10);
        // int data=q.dequeue();
        // System.out.println(data);
        //q.display();
        while(!q.isEmpty())
        {
           int data=q.dequeue();
           System.out.println(data);
        }
        
        //System.out.println(q.queueArray[q.front]);
    }
}
class CircularQueue {
    int max_size;
    int front;
    int rear;
    int queueArray[];
    CircularQueue(int size)
    {
        this.max_size=size;
        this.queueArray=new int[size];
        this.front=-1;
        this.rear=-1;
    }
    public boolean isFull()
    {
        if(this.front==0&&this.rear==max_size-1)
        {
            return true;
        }
        if(this.front==this.rear+1)
        {
            return true;
        }
        return false;
    }
    public void enqueue(int data)
    {
        if(isFull())
        {
            System.out.println("the queue is full");
            return;
        }
        if(front==-1)
        {
            front=0;
        }
       rear=(rear+1)%max_size;
       queueArray[rear]=data;
      }
      public void display()
      {
        for(int i:queueArray)
        {
            System.out.println(i);
        }
      }
      public boolean isEmpty()
      {
         return this.front==-1;
      }
      public int dequeue()
      {
          if(isEmpty())
          {
              System.out.println("the queueu is empty");
              return -1;
          }
          int current =queueArray[front];
          if(front==rear)
          {
              front=-1;
              rear=-1;
          }
          else
          {
              front=(front+1)%max_size;
          }
          return current;
      }
      
}