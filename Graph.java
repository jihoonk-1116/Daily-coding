//10-29-21
//10-30-21

public class Graph{
    private int V;
    private int E;
    private int[][] adjMatrix;
    
    public Graph(int nodes){
        this.V = nodes; //The number of vertices
        this.E = 0;     //The number of edges
        this.adjMatrix = new int[nodes][nodes];
    }
    
    public void addEdge(int u, int v){
        this.adjMatrix[u][v]=1;
        this.adjMatrix[v][u]=1; //undirected graph
        E++; //Increase edge
    }

    
    public void bfs(int s){ //Breadth First Search
      boolean[] visited = new boolean[V]; // V = the number of vertices
      Queue<Integer> q = new LinkedList<>();  //FIFO
      visited[s] = true; // Check 'visited' at the starting point
      q.offer(s); //Add s to queue
      
      while(!q.isEmpty()){
        int u = q.poll();
        System.out.println(u + " "); //Print the order of FIFO
        
        for(int v : adjMatrix[u]){ //v will be an index of u ex) [u][v]
          if(!visited[v]){ //If the vertice is not visited before, 
            visited[v] = true; //Check the flag
            q.offer(v); //Add the v to queue
          }
        }
      }
    }
    
    public void dfs(){ //Depth First Search
      boolean[] visited = new boolean[V]; //Initialize visited boolean array, V= the number of vertices
      for(int v=0;v<V;v++){ //To invoke dfs method recursivly by the order adjacent node from s
        if(!visted[v]){ //If the node is not visited, the call dfs
          dfs(v,visited); 
        }
      }
    }
    public void dfs(int v, boolean[] visited){
      visited[v] = true; //Check true
      System.out.print(v + " "); //Print current node
      for(int w : adj[v]){ //Invoke dfs function until finding the end of connected node.
        if(!visited[w]){
          dfs(w,visited);
        }
      }
    }
}

public class Graph2{ //Representation an undirected graph using LinkedList
    private LinkedList<Integer>[] adj;
    private int V;
    private int E;
    
    public Graph2(int nodes){
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList<nodes>;
        for(int i=0;i<nodes;i++){
            this.adj[i] = new LinkedList<>();
        }
    }
    public void addEdge(int u, int v){
        this.adj[u].add(v);
        this.adj[v].add(u);
        E++;
    }
}
