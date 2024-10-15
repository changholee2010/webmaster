package chap13;

public class Member {
	//필드
	public String name;
	public int age;
	//생성자
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	//메소드
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member) obj;
			return (member.name.equals(name)) && (member.age == age);
		}else {
			return false;
		}
		
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + age;
 	}
}
