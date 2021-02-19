package oop;
//교수
public class Prof extends Member {
	String dept;

	//부모클래스가 추상클래스라서 상속받은 메소드를 오버라이딩(재정의) 해줘야함
	@Override
	public void sal() {
		System.out.println("교수 급여");
	}

	//이미 정해져 있어도 걍 다시 오버라이딩 가능
	@Override
	public void print() {
		super.print();
		System.out.println("교수");
	}
	
}
