package util;

public class MapUtilTest {

	public static void main(String[] args) {
		
		MapUtil map = new MapUtil();
		map.addEmp(new Emp(1, "홍길동", "인사"));
		map.addEmp(new Emp(2, "홍이동", "안사"));
		map.addEmp(new Emp(3, "홍삼동", "잘사"));
		
		//2번 사번의 이름을 출력 -> "홍이동" 나와야함
		String name = map.getName(2);
		System.out.println(name);
		
		//2번 사번 삭제
		map.delEmp(2);
		
		//전체출력
		System.out.println(map.getMap());
		
		//전체이름만 출력
		map.getList();
	}

}
