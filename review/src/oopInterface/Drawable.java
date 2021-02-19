package oopInterface;

//상수와 추상메소드만 가지는것 = 인터페이스
//개발표준을 정해줄 수 있는 장점이 있음
public interface Drawable {
	String color = "black";
	void draw(); //모든 메소드가 추상메소드라 public abstract 생략되어있음

}