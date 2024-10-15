package chap04;

public class Exam162 {

	public static void main(String[] args) {
		// 주사위 2개를 던져서 합이 5가되면 종료 - game over
		// 5가 아니면 (1,3) 주사위 눈 표시
		// 몇번만에 나왔는지?
		
		int cnt = 0;
		while(true) {
			int dice1 = (int)(Math.random() * 6) + 1;
			int dice2 = (int)(Math.random() * 6) + 1;
			cnt++;
			System.out.printf("(%d,%d) ",dice1,dice2);
			if(dice1 + dice2 == 5) {
				System.out.println("\n" + cnt + "번 game over");
				break;
			}
			
		}
		
		// 주사위 눈이 1이면 1등 ~ 6이면 6등이라고 출력
		int dice3 = (int) (Math.random() * 6) + 1 ;
		if(dice3 == 1) {
			System.out.println("1등");
		}else if(dice3 == 2) {
			System.out.println("2등");
		}else if(dice3 == 3) {
			System.out.println("3등");
		}else if(dice3 == 4) {
			System.out.println("4등");
		}else if(dice3 == 5) {
			System.out.println("5등");
		}else {
			System.out.println("6등");
		}
		
		//switch
		switch(dice3) {
		case 1 : System.out.println("1등"); break;
		case 2 : System.out.println("2등"); break;
		case 3 : System.out.println("3등"); break;
		case 4 : System.out.println("4등"); break;
		case 5 : System.out.println("5등"); break;
		case 6 : System.out.println("6등"); break;
		default : System.out.println("잘못된 값 입력");
		}
		
		System.out.println(dice3 + "등");
		
		// 50에서 100까지 수를 발생 (곱수 = 최종값 -초기값 +1)
		// 90 이상이면 A, 80 이상이면 B, ....60이상 D, 나머지 F
		// switch 문으로 작성
		int score = (int)(Math.random() * 51) + 50;
		switch(score / 10) {
		case 10:
		case 9 : System.out.println("A"); break;
		case 8 : System.out.println("B"); break;
		case 7 : System.out.println("C"); break;
		case 6 : System.out.println("D"); break;
		default : System.out.println("F"); break;
		}
		
		
		

	}// end main

}//end class
