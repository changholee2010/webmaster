package chap13;

import java.util.ArrayList;
import java.util.List;

public class ArrListMain {

	public static void main(String[] args) {
		// List 컬렉션
		// ArrayList
		List<String> list = new ArrayList<>();
		
		//객체 추가
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/jsp");
		list.add(2,"Database");
		list.add("iBATIS");
		
		//List 크기
		int size = list.size();
		System.out.println("총 객체 수 : " + size);
		
		//리스트 객체 가져오기
		String skill = list.get(2);
		System.out.println(" 2: " + skill);
		
		// 삭제 하기
		list.remove(2);
		list.remove(2);
		list.remove("iBATIS");
		
		//전체 출력
		System.out.println("전체 출력------------");
		for(String obj : list) {
			System.out.println(obj);
		}

	}

}
