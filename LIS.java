import java.util.*;
class Main{
	static int[] dy;
	public int solution(int[] arr){
		int answer=0;
		dy=new int[arr.length];
		dy[0]=1;
    //this approach is buttom-up -> solve small problem first, then figure out the bigger problem.
		for(int i=1; i<arr.length; i++){ 
			int max=0;
			for(int j=i-1; j>=0; j--){ //find how long increasing subsequance by i-1, find solution from where the point that is already solved 
				if(arr[j]<arr[i] && dy[j]>max) max=dy[j]; 
			}
			dy[i]=max+1;
			answer=Math.max(answer, dy[i]);
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		System.out.print(T.solution(arr));
	}
}
