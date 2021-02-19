package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import util.Emp;


public class SortTest {

	public static void main(String[] args) {
		ArrayList<Emp> emplist = new ArrayList<>();
		emplist.add(new Emp(1, "가길동", "인사"));
		emplist.add(new Emp(2, "나이동", "회계"));
		emplist.add(new Emp(3, "다삼동", "개발"));
		
		//클래스 선언후 비교
		Collections.sort(emplist, new EmpCompare());
		
		//무명클래스 선언후 비교
		Collections.sort(emplist, new Comparator<Emp>() {
			public int compare(Emp o1, Emp o2) {
				return o1.getDept().compareTo(o2.getDept());
			}});
		
		//람다식표현
		Collections.sort(emplist, (Emp o1, Emp o2) -> 
			 o1.getDept().compareTo(o2.getDept())
			);
		
		System.out.println(emplist);
	}
}


class EmpCompare implements Comparator<Emp>{

	@Override
	public int compare(Emp o1, Emp o2) {
		//return o1.getName().compareTo(o2.getName());
		return o1.getDept().compareTo(o2.getDept());
	}
	
}
 