package chap07;

public class Computer extends Calculator{
	//메소드 재정의
	@Override
	double areaCircle(double r) {
		return Math.PI * r * r;
	}
	
	
	double ac(double r) {
		if(r >= 10) {
			double rs = super.areaCircle(r);
			return rs;
		}else {
			double rs = areaCircle(r);
			return rs;
		}
	}
}
