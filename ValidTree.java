class Solution {
    
    int[] par;
    int[] rank;
    public boolean validTree(int n, int[][] edges) {
        //union & find
        //each edge is being merged 
        //while merging, find same parent then return
        
        par = new int[n];
        rank = new int[n];
        
        for(int i=0;i<n;i++){
            par[i] = i;
            rank[i] = 1;
        }
        
        for(int[] e : edges){
            if(!union(e[0], e[1])) return false;
        }
        return edges.length == n - 1;
    }
    
    private int find(int v){
        if(v == par[v]) return v;
        else return par[v] = find(par[v]);
    }
    
    private boolean union(int v1, int v2){
        
        int p1 = find(v1);
        int p2 = find(v2);
        
        if(p1 == p2) return false; //cycle
        
        if(rank[p1] > rank[p2]){
            par[p2] = p1;
            rank[p1] += rank[p2];
        }
        else{
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
                
        
        
        return true;
        
    }
}

/*
the last line return edges.length == n - 1 using graph theory
example: 4, [[0, 1], [2, 3]] this should return false if we check if edges.length == n - 1
*/
