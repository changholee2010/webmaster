package chap04;

import java.util.Scanner;

public class Exam182 {

	public static void main(String[] args) {
		// 2번
		// 3번
		// 4번
		// (4 * x) + (5 * y) == 60
		//5번
		for(int i=1; i<5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		String stars = "";
		for(int i=1; i<5; i++) {
			stars += "*";
			System.out.printf("%4S\n",stars);
		}
		
		//7번
		boolean run = true;
		int balence = 0;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			//메뉴
			System.out.println("1.예금 | 2. 출금 | 3.잔고 | 4. 종료");
			
			//메뉴선택
			System.out.print("선택> ");
			int selNo = Integer.parseInt(sc.nextLine());
			
			switch(selNo) {
			case 1 :
				System.out.print("예금액>");
				int money = Integer.parseInt(sc.nextLine());
				balence += money;
				break;
			case 2 :
				System.out.print("출금액>");
				money = Integer.parseInt(sc.nextLine());
				//출금시 잔액 부족 체크
				//잔액이 부족하면 출금 불가, 출금가능액 표시
				if(balence < money) {
					System.out.println("잔고부족");
					System.out.println("출금 가능액 : " + balence);
				}else {
					balence -= money;
				}
				break;
			case 3 :
				System.out.println("잔고 : " + balence);
				break;
			case 4 :
				run = false;
				break;
			default :
				System.out.println("선택이 잘못되었습니다");
			}
		}
		System.out.println("프로그램 종료");
		sc.close();
		

	}//end main

}//end class
