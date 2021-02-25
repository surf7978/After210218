package common;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	
	public static java.sql.Date toDate(String date) {
		Date result = null;
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		try {
			result = fm.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new java.sql.Date(result.getTime()); 
	}
}
