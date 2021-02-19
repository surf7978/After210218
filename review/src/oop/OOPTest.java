package oop;

import java.util.ArrayList;

public class OOPTest {
	public static void main(String[] args) {

		/**
		 * 다형성
		 * 1. 부모타입의 참조변수가 자식 객체를 참조할 수 있다.
		 * 2. 실행되는 메소드는 참조한느 객체의 메소드를 호출(실행결과 다를 수 있다.)
		 */
		ArrayList<Member> list = new ArrayList<>(); //이렇게 멤버로 선언해줘서 Prof랑 Emp타입 모두 담을 수 있다. 
		Member member;
		
		member = new Prof();
		member.setName("김유신");
		list.add(member);

		member = new Emp();
		member.setName("홍길동");
		list.add(member);
		
//		for(int i=0; i<list.size(); i++) {
//			Member m = list.get(i);
//			m.sal();
//			m.print();
//		}
		
		for(Member m : list) {
			m.sal();
			m.print();
			if(m instanceof Emp) { //instanceof = 특정타입 부르기용
				((Emp) m).meth(); //이런걸 다운캐스팅이라고 함 +객체(클래스)간의 형변환은 부모-자식간에만 가능
			}
		}
		
	}
}
