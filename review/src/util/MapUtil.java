package util;

import java.util.HashMap;

public class MapUtil {
	HashMap<Integer, Emp> map;
	
	public MapUtil() {
		map = new HashMap<>();
	}
	
	//추가
	public void addEmp(Emp emp) {
		map.put(emp.id, emp);
	}
	//수정
	public void updEmp(Emp emp) {
		map.put(emp.id, emp);
	}
	//삭제
	public void delEmp(Integer id) {
		System.out.println(map.get(id).name+" 삭제");
		map.remove(id);
	}
	//사번으로 이름 조회
	public String getName(Integer id) {
		String name=map.get(id).name;
		return name;
	}
	//맵리턴
	public HashMap<Integer, Emp> getMap(){
		return map;
	}
	
	//전체조회(이름만) map.keySet() 해서 Iterator하고 for문 사용
	public void getList() {
		for(Integer m : map.keySet()) {
			String names = map.get(m).name;
			System.out.print(names+" ");
		}
	}
}
