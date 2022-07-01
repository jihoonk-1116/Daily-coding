class CourseSchedule2 {
    
    int[] visited;
    int[] cycle;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        Queue<Integer> res = new LinkedList<>();
        visited = new int[numCourses];
        cycle = new int[numCourses];
        
        for(int i=0;i<numCourses;i++){
            graph.put(i, new ArrayList<Integer>());
        }
        for(int[] crs : prerequisites){
            graph.get(crs[0]).add(crs[1]);
        }
        
        
        for(int i=0;i<numCourses;i++){
            if(!dfs(i, graph, res)) return new int[]{};
        }
        
        int [] result = new int[res.size()];
        int index = 0;
        while(!res.isEmpty()){
            result[index++] = res.poll();
        }
        
        return result;
    }
    
    private boolean dfs(int crs, HashMap<Integer, ArrayList<Integer>> graph, Queue<Integer> res){

        if(visited[crs] == 1) return true;
        
        if(cycle[crs] == 1) return false;
        
        cycle[crs] = 1;
        for(Integer pre : graph.get(crs)){
            if(!dfs(pre, graph, res)) return false;
        }
        cycle[crs] = 0;

        
        res.offer(crs);
        visited[crs] = 1; 
        
        return true;
    }
    
}
