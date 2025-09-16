// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        Heap h1=new Heap();
        ArrayList<Integer> array=new ArrayList<Integer>();
        h1.insert(array,12);
        h1.insert(array,6);
        h1.insert(array,10);
        h1.insert(array,5);
        h1.insert(array,1);
        h1.insert(array,9);
        //h1.delete(array,10);
        //h1.heapSort(array);
        
        System.out.println(h1.heapSort(array));
        
    }
}//max heap
class Heap {
    public void heapify(ArrayList<Integer> array,int i,int size)
    {
        //int size=array.size();
        int parent=i;
        int left_child=(2*i)+1;
        int right_child=(2*i)+2;
        if(left_child<size && array.get(left_child)>array.get(parent))
        {
            parent=left_child;

        }
        if(right_child<size && array.get(right_child)>array.get(parent))
        {
            parent=right_child;
        }
        if(parent!=i)
        {
            int temp=array.get(parent);
            array.set(parent,array.get(i));
            array.set(i,temp);
            this.heapify(array,parent,size);
        }
    }
    public void insert(ArrayList<Integer> array,int num)
    {
        if(array.size()==0)
        {
            array.add(num);
        }
        else
        {
            array.add(num);
            for(int i=array.size()/2-1;i>=0;i--)
            {
                this.heapify(array,i,array.size());
            }
        }
    }
    public void delete(ArrayList<Integer> array,int num)
    {
        int size=array.size();
        int i;
        for(i=0;i<size-1;i++)
        {
            if(num==array.get(i))
            break;
        }
        int temp=array.get(i);
        array.set(i,array.get(size-1));
        array.set(size-1,temp);
        array.remove(size-1);
        for(int j=(size/2)-1;i>=0;i--)
        {
            this.heapify(array,j,array.size());
        }
    }
    public ArrayList heapSort(ArrayList<Integer> array)
    {
        int size=array.size();
        for(int i=(size/2)-1;i>=0;i--)
        {
            this.heapify(array,i,size);
        }
        for(int i=(size-1);i>=0;i--)
        {
            int j=i;
            int element=array.get(0);
            array.set(0,array.get(i));
            array.set(i,element);
            this.heapify(array,0,i);
        }
        return array;
        
    }
    
}