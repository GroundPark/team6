package main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDiff {
	public static long diffOfDate(String begin, String end) throws Exception {
	// String형 날짜 차이 구하는 함수
		begin = begin.replace("-", "");
		end = end.replace("-", "");
		
		
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        
        Date stDt = format.parse(begin);
        Date edDt = format.parse(end);
        
        long diff = edDt.getTime() - stDt.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        
        return diffDays;
    }
}
