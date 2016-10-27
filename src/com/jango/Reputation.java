package com.jango;

/**
 * 
 * @author ashwani
 * 
 * Problem Statement
 * 
 * ======
 * 

	The exam scores for n boys, n girls, and the class reputation formula are defined as follows: Each s_boys[i] is the score for boy i (where 0 ≤ i ≤ n ).
	
	Each s_girls[i] is the score for girl i (where 0 ≤ i ≤ n ).
	
	reputation = (s_boys[0] × s_girls[0]) + (s_boys[1] × s_girls[1]) + (s_boys[2] × s_girls[2]) + … + (s_boys[n − 1] × s_girls[n − 1])
	
	We want to maximize the class' reputation by increasing or decreasing the scores of either the boys or the girls by 1 a maximum of m times. Note that you can only change the scores of either the boys or the girls, but not both groups.
	
	Complete the maxReputation function in the editor below. It has three parameters: An array of n integers, s_boys. An array of n integers, s_girls. An integer, m. The function must maximize the class's reputation by increasing or decreasing either the boys' scores or the girls' scores by 1 a maximum of m times, then return an integer denoting the maximum possible value of reputation.
	
	Input Format
	
	The first line contains an integer, n, denoting the number of elements in s_boys and s_girls.
	
	Each line i of the n subsequent lines (where 0 ≤ i < n) contains an integer describing s_boys[i].
	
	Each line i of the n subsequent lines (where 0 ≤ i < n) contains an integer describing s_girls[i].
	
	The last line contains an integer denoting m.
	
	Constraints
	
	1 ≤ n ≤ 103 1 ≤ m ≤ 104
	
	Output Format
	
	The function must return an integer denoting the maximum possible reputation. This is printed to stdout .

 * ======
 *
 */

public class Reputation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] sb = {1,-1};
		int[] sg = {-1,1};
		int m = 2;
		
		int n = 2;
		int rep = 0;
		
		int max = 0;
		int maxIndex = 0;
		max = sb[0];
		for(int i=0; i<n; i++ ){
			
			int sbm = sb[i];
			int sgm = sg[i];
			int temp = Math.abs(sbm) > Math.abs(sgm) ? sbm : sgm;
			if(Math.abs(max) < temp){
				max = temp;
				maxIndex = i;
			}
			rep += sb[i] * sg[i];
//			System.out.println(" --> "+ rep);
			
		}
		
		rep = rep - (sb[maxIndex] * sg[maxIndex]);
		
//		System.out.println(" -- 1 --> "+rep);
		
		if(sb[maxIndex] < sg[maxIndex]){
			sb[maxIndex] += m;
		}else{
			sg[maxIndex] += m;
		}
		
		rep += (sb[maxIndex] * sg[maxIndex]);
		
		System.out.println(" Max rep  = "+rep);

	}

}
