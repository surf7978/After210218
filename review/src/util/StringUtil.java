package util;

public class StringUtil {
	//1. String -> int
	public static int toInt(String s) { // Integer -> int
		if (s == null) return -1;
		
		return Integer.parseInt(s);
	}
	//2. int -> String
	public static String toStr(int i) { 
		return Integer.toString(i);
	}
	//3. String -> 확장자 : lastIndexOf사용해서 . 찾고 substr으로 출력 
	public static String getExt(String s) {
		String result = null;
		if(s.lastIndexOf(".")+1 == 0) {
			result = "확장자를 찾을 수 없습니다.";
		}else {
			result = s.substring(s.lastIndexOf(".")+1);
		}
		return result;
	}
	
	
	/**
	 * 파일명에서 확장자를 추출
	 * @param s 경로명 "c:/img/item/p01.jpg"
	 * @return 파일명 p01.jpg
	 */
	//4. String -> path, 파일명
	public static String getFile(String s) {
		String result = null;
		//경로 보여주는 코드
		if(s.lastIndexOf("/") != -1) {
			result = s.substring(0, s.lastIndexOf("/"));
		}else {
			if(s.lastIndexOf(".") != -1) {
				result = s.substring(0, s.lastIndexOf("."));
			}else {
				result = s;
			}
		}
		return result;
	}
	
}
