import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {

        System.out.println(nextDay(31, 12, 2020));

    }

    public static String nextDay(int day, int month, int year) throws ParseException {

        if(!isDateValid(year,month,day)) return "Invalid Date";

        String dayInString = day + "-" + month + "-" + year;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormat.parse(dayInString);
        Date nextDay = new Date(date.getTime() + 24 * 60 * 60 * 1000);


        String nextDayInString = dateFormat.format(nextDay);

        if(day == 31 && month == 12) System.out.println("Happy New Year!");

        return nextDayInString;
    }

    public static boolean isDateValid(int year, int month, int day) {
        try {
            LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            return false;
        }
        return true;
    }
}
