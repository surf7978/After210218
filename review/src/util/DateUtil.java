package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * String -> Date
	 * SimpleDateFormat.parse 이용
	 * @throws ParseException 
	 */
	public static Date toDate(String date) throws ParseException {
		Date result = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		result = dateFormat.parse(date);
		return result; 
	}
	
	/**
	 * Date를 주어진 포맷대로 스트링으로 변환
	 * @Overloading사용해서 메소드 하나로 둘 다 되게 하기
	 * https://docs.oracle.com/javase/8/docs/api/index.html 여기서 패턴 찾아서 코딩하기
	 * Date -> String
	 * SimpleDateFormat.format 이용
	 */
	public static String toStr(Date date) {
		String result = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("D");
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("E");
		result = dateFormat1.format(date)+"요일 "+dateFormat.format(date)+"일/365일";
		return result;
	}

	public static String toStr(Date date, String format) {
		String result = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		result = dateFormat.format(date);
		return result;
	}
	
}
