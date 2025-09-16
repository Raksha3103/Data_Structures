// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        Queue q=new Queue(3);
        q.enqueue(2);
        q.enqueue(5);
        q.enqueue(6);
        while(!q.stackEmpty())
        {
            int element=q.dequeue();
            System.out.println(element);
        }
        //System.out.println(q.queueArray[q.rear]);
    }
}
class Queue {
    int front=-1;
    int rear=-1;
    int max_size=0;
    int queueArray[];
    Queue(int max_size)
    {
        this.max_size=max_size;
        this.queueArray=new int[max_size];
    }
    public boolean stackFull()
    {
        return this.rear==this.max_size-1;
    }
    public void enqueue(int data)
    {
        if(stackFull())
        {
            System.out.println("queue overflow");
            return;
        }
        if(front==-1)
        {
            front=0;
        }
        this.rear++;
        this.queueArray[this.rear]=data;
        
    }
    public boolean stackEmpty()
    {
        return this.front==-1;
    }
    public int dequeue()
    {
        if(stackEmpty())
        {
            System.out.println("the queue is empty");
            return -1;
        }
        int current=queueArray[front];
        if(front==rear)
        {
            front=-1;
            rear=-1;
        }
        else{
        front++;
        }
        return current;
        
    }
}