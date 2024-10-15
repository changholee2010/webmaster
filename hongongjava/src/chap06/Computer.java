package chap06;

public class Computer {
	//필드
	//생성자
	//메소드
	int sum1(int[] values) {
		int sum = 0;
		for(int num : values) {
			sum += num;
		}
		return sum;
	}
	
	int sum2(int ...values) {
		int sum = 0;
		for(int num : values) {
			sum += num;
		}
		return sum;
	}
	
}
