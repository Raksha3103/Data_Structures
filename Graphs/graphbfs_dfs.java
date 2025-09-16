 // Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        Graph_Adjacency_matrix g=new Graph_Adjacency_matrix(3);
        g.addEdge_directedWeight(0,1,10);
        g.addEdge_directedWeight(0,2,20);
        //g.addEdge(1,2);
       // g.addEdge_directed(3,4);
        //for(boolean i[]:g.adjacencymatrix)
        for(int i[]:g.adjacencymatrix)
        {
            for(int j:i)
            {
                System.out.print(String.valueOf(j)+" ");
            }
            System.out.println();
        }
        Graph_Adjacency_List gl=new Graph_Adjacency_List(5);
        gl.addEdge_list(0,1);
         gl.addEdge_list(0,2);
          gl.addEdge_list(1,3);
           gl.addEdge_list(2,3);
           gl.addEdge_list(3,4);
           gl.addEdge_list(2,4);
           gl.bfsTraversal(0);
           gl.dfsTraversal(0);
           System.out.println(gl.graph);
        
    }
}

class Graph_Adjacency_matrix {
    public int vertices;
    //public boolean[][] adjacencymatrix;
    public int[][] adjacencymatrix;
    Graph_Adjacency_matrix(int vertices) {
        this.vertices=vertices;
        //this.adjacencymatrix=new boolean [vertices][vertices];
        this.adjacencymatrix=new int [vertices][vertices];
    }
    public void addEdge(int source,int  dest) {
        this.adjacencymatrix[source][dest]=1;
        this.adjacencymatrix[dest][source]=1;
    }
     public void addEdge_directed(int source,int  dest) {
        this.adjacencymatrix[source][dest]=1;
    }
    public void addEdge_directedWeight(int source,int  dest,int weight) {
        this.adjacencymatrix[source][dest]=weight;
    }
}
    
    class Graph_Adjacency_List {
        public int vertices;
        public Map<Integer,ArrayList<Integer>> graph;
        Graph_Adjacency_List(int vertices) {
            this.vertices=vertices;
            graph=new HashMap<>();
            for(int i=0;i<vertices;i++)
            {
                graph.put(i,new ArrayList<>());
            }
        }
    public void addEdge_list(int source,int dest)
    {
        graph.get(source).add(dest);
        graph.get(dest).add(source);
    }
     public void bfsTraversal(int start) {
         boolean[] visited=new boolean[this.vertices];
         Queue<Integer> queue=new LinkedList<Integer>();
         visited[start]=true;
         queue.offer(start);
         while(!queue.isEmpty())
         {
             int top=queue.poll();
             System.out.println(top);
             for(int i:this.graph.get(top))
             {
                 if(!visited[i])
                 {
                     visited[i]=true;
                     queue.offer(i);
                 }
             }
         }
        
     }
     public void dfsTraversal(int start)
     {
         boolean[] visited=new boolean[this.vertices];
         Stack<Integer> stack=new Stack<Integer>();
         visited[start]=true;
         stack.push(start);
         while(!stack.isEmpty())
         {
             int top=stack.pop();
             System.out.println(top);
             for(int i:this.graph.get(top))
             {
                 if(!visited[i])
                 {
                     visited[i]=true;
                     stack.push(i);
                 }
             }
         }
         
     }
    }
