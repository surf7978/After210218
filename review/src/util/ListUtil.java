package util;

import java.util.ArrayList;

public class ListUtil {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		//추가
		list.add("바나나");
		//삽입
		list.add(0, "사과");//바나나가 한칸 밀려서 1번으로 감
		//수정
		list.set(1, "키위");//바나나가 키위로 됨
		//삭제
		list.remove(0); 
		//단건조회
		list.get(0); //하나지워서 앞으로 당겨짐
		//전체조회
		System.out.println(list);
	}

}
