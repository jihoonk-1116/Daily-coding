//10-29-21

public class Graph{

    public void bfs(int s){
      boolean[] visited = new boolean[V]; // V = the number of vertices
      Queue<Integer> q = new LinkedList<>();  //FIFO
      visited[s] = true; // Check 'visited' at the starting point
      q.offer(s); //Add s to queue
      
      while(!q.isEmpty()){
        int u = q.poll();
        System.out.println(u + " "); //Print the order of FIFO
        
        for(int v : adj[u]){
          if(!visited[v]){ //If the vertice is not visited before, 
            visited[v] = true; //Check the flag
            q.offer(v); //Add the v to queue
          }
        }
      }
    }
    
    public void dfs(){
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
