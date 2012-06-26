package pl.edu.kosttek.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilities {
	//"2012-05-20T16:22:27+02:00"
	public static Date getDateFromString(String s){
		String [] tab = s.split("T");
		DateFormat formatter ; 
		formatter = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
		Date date=null;
		try {
			date = (Date) formatter.parse(tab[0]+tab[1].split("\\+")[0]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
