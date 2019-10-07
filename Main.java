import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		int[] weight = { 3, 1, 6, 2, 7, 30, 1 }; // return 21

		System.out.println(new Solution().solution(weight));
	}

}

class Solution {

	public int solution(int[] weight) {
		Arrays.sort(weight);
		int sum = 0;
		for (int i = 0; i < weight.length; i++) {
			if (sum+1 >= weight[i]) {
				sum += weight[i];				
			} else {
				return sum+1;
			}
		}
		
		return sum+1;
	}
}

//void dfs(int totalWeight, int step) {
//	if (n == step) {
//		weightSet.add(totalWeight);
//		return;
//	}
//
//	dfs(totalWeight + mWeight[step], step + 1);
//	dfs(totalWeight, step + 1);
//}
