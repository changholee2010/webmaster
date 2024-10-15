package chap05;

import java.util.Arrays;

public class Exam202 {

	public static void main(String[] args) {
		
//		int args1 = Integer.parseInt(args[2]);
//		System.out.println(args1 + 100);
		
		// 배열을 생성
		// 배열을 이용하는 방법
		
		// 배열에 1에서 100까지의 임의의 수(random()) 10개를 저장
		// 배열의 합과 평균(소수 첫째자리까지 나타냄),
		// 최대값, 최소값을 구하세요
		
		// 배열생성
		int[] nums = new int[10];
//		int[] nums2 = {10,2,50,40};
		outer : for(int i=0; i<nums.length; i++) {
			int rNum = (int)(Math.random() * 100) + 1 ;;
			for(int j=0; j<=i; j++) {
				if(nums[j] == rNum) {
					i--;
					continue outer;
				}
			}
			nums[i] = rNum;
		}
		
		System.out.println(nums);
		System.out.println(Arrays.toString(nums));
		
		// 배열 이용, 합,평균, 최대, 최소값 구하기
		int sum = 0;
		int max = 0;
		int min = 100;
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i] + " ");
			sum += nums[i];
			if(max < nums[i]) max = nums[i];
			if(min > nums[i]) min = nums[i];
		}
		System.out.println();
		
		double avg = (double)sum / nums.length;
		System.out.printf("sum = %d, avg = %.1f, max = %d, min = %d", sum, avg, max, min);
		
	}

}
