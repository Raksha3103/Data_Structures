// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        Dequeue q=new Dequeue(5);
        q.insertFront(1);
       q.insertFront(2);
       q.insertFront(3);
       q.insertFront(4);
       q.insertRear(10);
       System.out.println(q.delete_at_front());
       q.display();
    }
}
class Dequeue {
    int dequeueArray[];
    int front;
    int rear;
    int max_size;
    Dequeue(int size)
    {
        this.max_size=size;
        this.front=-1;
        this.rear=-1;
        this.dequeueArray=new int[size];
    }
    public boolean isFull()
    {
    return ((this.front==0&&this.rear==max_size-1)||front==rear+1);
    }
    public boolean isEmpty()
    {
        return this.front==-1;
    }
    public void insertFront(int data)
    {
        if(isFull())
        {
            System.out.println("the queue is full");
            return;
        }
        if(front==-1)
        {
            front=0;
            rear=0;
        }
        else if(front==0)
        {
            this.front=this.max_size-1;
        }
        else{
            front=front-1;
        }
        dequeueArray[front]=data;
    }
    public void display()
    {
        for(int i:dequeueArray)
        System.out.println(i);
    }
    public void insertRear(int data)
    {
        if(isFull())
        {
            System.out.println("the queue is full");
            return;
        }
        if(front==-1)
        {
            front=0;
            rear=0;
        }
        else if(this.rear==this.max_size-1)
        {
            rear=0;
        }
        else
        {
            rear++;
        }
        dequeueArray[rear]=data;
    }
    public int delete_at_front()
    {
        if(isEmpty())
        {
            System.out.println("the queue is empty");
            return -1;
        }
        int data=dequeueArray[front];
        if(front==rear)
        {
            front=-1;
            rear=-1;
        }
        else if(front==max_size-1)
        {
            front=0;
        }
        else
        {
            front++;
        }
        return data;
    }
    public int delete_at_rear()
    {
         if(isEmpty())
        {
            System.out.println("the queue is empty");
            return -1;
        }
        int data=dequeueArray[front];
        if(front==rear)
        {
            front=-1;
            rear=-1;
        }
        else if(rear==0)
        {
            rear=max_size-1;
        }
        else
        {
            rear--;
        }
        return data;
    }
}