package 홍길동;

import java.text.DecimalFormat;

public class Doself {

	public static void main(String[] args) {
		// 세자리 콤마
		double num = 26000000;
		DecimalFormat df = new DecimalFormat("#,##0원");
		System.out.println(df.format(num));

		
		//가위(0) 바위(1) 보(2)
		
	}

}
