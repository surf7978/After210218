package util;

import java.util.ArrayList;

public class EmpList {
	ArrayList<Emp> list;

	public EmpList() {
		list = new ArrayList<>();
	}

	// 추가
	public void addEmp(Emp emp) {
		list.add(emp);
	}

	// 해당사원 이름조회
	public String getName(int index) {
		String name = list.get(index).name;
		return name;
	}

	// 삭제
	public void delEmp(int index) {
		String name = list.get(index).name;
		System.out.println(name+" 삭제");
		list.remove(index);
	}	
	
	// 전체 이름조회
	public void getNames() {
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i).name);
		}
	}
	// list 조회
	public ArrayList<Emp> getList(){
		return list;
	}
}

class Emp {
	int id;
	String name;
	String dept;

	public Emp() {
	}

	public Emp(int id, String name, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", dept=" + dept + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
}