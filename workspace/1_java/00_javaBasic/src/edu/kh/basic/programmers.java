package edu.kh.basic;

public class programmers {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int storage = 1000;
		int usage = 200;
		int[] change = {-10, 20, 30, -5}; // 예시 데이터
		int result = solution.solution(storage, usage, change);
		System.out.println("Result: " + result);





		System.out.println("숙제");
	}
}

class Solution {
	public int solution(int storage, int usage, int[] change) {
		int total_usage = 0;
		for (int i = 0; i < change.length; i++) {
			total_usage = (int)(usage * (change[i] < 0 ? -1 * (change[i] * 0.01) : change[i] * 0.01));
			total_usage += usage;
			if (total_usage > storage) {
				return i;
			}
		}
		return -1;

	}

}
