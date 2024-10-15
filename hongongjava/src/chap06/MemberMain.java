package chap06;

public class MemberMain {
	public static void main(String[] args) {
		//객체 생성
		Member member = new Member();
		Member member2 = new Member("홍길동", "hong");
		
		System.out.println("이름 : " + member.name + " 나이 : " + member.age);
		System.out.println("이름 : " + member2.name + " 아이디 : " + member2.id);
		
		//필드값 변경
		member.name = "최하얀";
		member.age = 23;
		
		//필드 출력
		System.out.println("이름 : " + member.name + " 나이 : " + member.age);
	}
}
