package util;

import java.text.ParseException;
import java.util.Date;

public class WrapperTest {

	public static void main(String[] args) throws ParseException {
		//int result = StringUtil.toInt("1234");
		//System.out.println(result);
		
		//String result = StringUtil.toStr(0);
		//System.out.println(result);
		
		//파일명에서 확장자만 추출
		//String result = StringUtil.getExt("a.hwp");
		//System.out.println(result);
		//result = StringUtil.getExt("ahwp");
		//System.out.println(result);
		
		//파일명 추출
		//String result = StringUtil.getFile("p01.jpg");
		//System.out.println(result);
		//result = StringUtil.getFile("p01jpg");
		//System.out.println(result);
		//result = StringUtil.getFile("c:/img/item/p01.jpg");
		//System.out.println(result);
		
		//Date result = DateUtil.toDate("2021-02-10");
		//System.out.println(result);
		
		//String str = DateUtil.toStr(new Date());
		//System.out.println(str);
		
		//String str2 = DateUtil.toStr(new Date(), "yyyy");
		//System.out.println(str2);
		
		//요일, 1년 중에 몇일째
		String str = DateUtil.toStr(new Date()); 
		System.out.println(str);
		
	}

}
