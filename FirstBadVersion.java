/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */


//Recursive version
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //find the first bad version 
        //bad -> true good -> false
        //input 'n' is the number of versions 
        //isBadVersion(version) -> return good or bad
        return findBad(1, n);
    }
    private int findBad(int left, int right){
        if(left == right) return left; //base case
        
        int mid = left + (right-left)/2; //to prevent overflow
        
        if(isBadVersion(mid)) return findBad(left, mid); 
        //if n/2 is bad -> search the left side of the mid 
        else return findBad(mid+1, right);
         //else -> search the right side of the mid
        
    }
}
//Iterative version
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int right = n, left = 1;
        //find the first bad version 
        //bad -> true good -> false
        //input 'n' is the number of versions 
        //isBadVersion(version) -> return good or bad
        while(left<right){
            int mid = left + (right - left)/2;
            if(isBadVersion(mid)) right = mid; //update mid because the right side above mid 
            else left = mid+1;
        }
        return left;
    }
}
