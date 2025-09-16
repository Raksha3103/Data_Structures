// Online Java Compiler
// Use this editor to write, compile and run your Java code online

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