class TimeMap {
    
    
    //key -> [[val, t1], [val2, t2], ...]
    
    HashMap<String, ArrayList<String[]>> store;
    
    public TimeMap() {
        this.store = new HashMap<String, ArrayList<String[]>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key)){
            ArrayList<String[]> valueList = new ArrayList<>();
            store.put(key, valueList);
        }
        
        store.get(key).add(new String[]{value, String.valueOf(timestamp)});
        
    }
    
    public String get(String key, int timestamp) {
        
        ArrayList<String[]> valueList = store.getOrDefault(key, new ArrayList<String[]>());
        
        int lt = 0, rt = valueList.size() - 1;
        String res = "";
        
        while(lt <= rt){
            
            int mid = (lt + rt) / 2;
            int ts = Integer.parseInt(valueList.get(mid)[1]);
            
            if(ts <= timestamp){
                res = valueList.get(mid)[0];
                lt = mid + 1;
            }
            
            else{
                rt = mid - 1;
            }
           
            
        }
        
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
