package oopInterface;


public class Rect 
	extends Shape //속성,메소드 상속 받음
	implements Drawable, Movable //추상메소드 +상속,로 여러개 받는것 가능 
{ 
	
	@Override
	public void draw(){
		System.out.println("사각형 그리기");
	}

	@Override
	public void move() {
		System.out.println("사각형 이동");
	}
	
}
