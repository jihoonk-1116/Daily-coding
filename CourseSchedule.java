class CourseSchedule {
    
    boolean[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //one directional graph
        // cycle is not allowed
        //numCourses < count -> false
        //adjacency list 
        HashMap<Integer, ArrayList<Integer>> adMap = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            adMap.put(i, new ArrayList<>());
        }
        
        for(int i=0;i<prerequisites.length;i++){
            adMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
            //crs : pre
        }
        visited = new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(!dfs(i, adMap)) return false;
        }
        
        return true;
    }
    
    private boolean dfs(int crs, HashMap<Integer,ArrayList<Integer>> adMap){
        
        if(visited[crs] == true) return false; //detection of a loop
        if(adMap.get(crs).isEmpty()) return true; //end of the course or already parsed -> can finish the course
        
        visited[crs] = true;
        //invoke dfs every single pre course
        for(Integer pre : adMap.get(crs)){
            if(!dfs(pre, adMap)) return false;
        }
        //returning false did not occur -> means that the course can be taken -> return true
        visited[crs] = false;
        //for the next search
        adMap.get(crs).clear();
        //for optimization, this sub graph was already parsed so we don't need to look up the path after this point.
        return true;
    }
    
}
