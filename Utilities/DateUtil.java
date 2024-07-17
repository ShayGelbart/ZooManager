package Utilities;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private String date;
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    
    public DateUtil() {
    	this.date = formatDate(new Date());
    }
    
    public DateUtil(int days) {
    	this.date = addDays(new Date(), days);
    }
    
    public DateUtil(int year, int month, int day) {
    	this.date = setDate(year, month, day);
    }
    
    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public static String formatDate(Date date) {
        return dateFormatter.format(date);
    }

    public static String addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return formatDate(calendar.getTime());
    }

    public static String setDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); // Note: Month in Calendar is zero-based (0 - January, 11 - December)
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return formatDate(calendar.getTime());
    }

	@Override
	public String toString() {
		return date;
	}
    
    
}
