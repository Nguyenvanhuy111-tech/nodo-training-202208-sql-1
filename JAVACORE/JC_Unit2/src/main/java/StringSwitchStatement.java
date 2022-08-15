import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class StringSwitchStatement {
    public static void main(String[] args) {
        StringSwitchStatement statement = new StringSwitchStatement();
        Calendar calendar = Calendar.getInstance();
        System.out.println("Today is "+statement.getTypeOfDay(calendar));

        calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)+1);
    }

    public String getTypeOfDay(Calendar calendar){
        String type = calendar.getDisplayName(
                Calendar.DAY_OF_WEEK,Calendar.SHORT,new Locale("vi"));
        switch (type){
            case "Th 2":
                return "Start of work week";
            case "Th 5":
                return "Midweek";
        }
        return "Unknown";
    }
}
