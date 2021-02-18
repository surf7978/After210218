package util;

public class EmpListTest {
	public static void main(String[] args) {
		EmpList emplist = new EmpList();
		emplist.addEmp(new Emp(1, "홍길동", "인사"));
		emplist.addEmp(new Emp(2, "홍이동", "안사"));
		emplist.addEmp(new Emp(3, "홍삼동", "잘사"));
		
		//1번째 사원의 이름은?
		System.out.println(emplist.getName(0));
		
		//1번째 사원 삭제
		emplist.delEmp(0);
		
		//사원의 이름만 출력
		emplist.getNames();
		
		//전체 리스트 출력
		System.out.println(emplist.getList());
	}
}
