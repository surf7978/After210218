package oop;

public abstract class Member { //여기도 abstract 적어줘야 추상클래스 됨

	private String name; //private = 은닉화, 캡슐화
	String id;

	public Member() {
		super();
	}

	//getter = read
	//setter = write
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public abstract void sal() ; //추상메소드로 만듬


	public void print() {
		System.out.println(name);
	}

}