package name.davidwbrown;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class DateParser {

    public static String getParsedDate(String strDate) throws java.text.ParseException {
        Locale locale = new Locale("en", "US");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/d ha", locale);
//        DateFormat format = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        Date date = simpleDateFormat.parse(strDate);

        return simpleDateFormat.format(date);
    }

}
