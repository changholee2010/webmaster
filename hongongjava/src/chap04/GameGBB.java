package chap04;

import java.util.Scanner;

public class GameGBB {

	public static void main(String[] args) {
		// 가위(0)바위(1)보(2) 게임
		// 2보다 큰값 입력 종료
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.print("##가위바위보 : ");
			int my = Integer.parseInt(sc.nextLine());
			int com = (int)(Math.random() * 2);
			
			if(my > 2) {
				run = false;
				break;
			}
			
			if(my == com ) {
				System.out.printf("com = %d, my = %d 비겼음\n",com, my);
			}else if((my + 1) % 3 == com) {
				System.out.printf("com = %d, my = %d com이 이겼음\n",com, my);
			}else {
				System.out.printf("com = %d, my = %d my가 이겼음\n",com, my);
			}
		}
		
		System.out.println("game over");

	}

}
