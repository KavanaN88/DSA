import java.io.*;
import java.util.*;
class Result {
    public static String findDay(int month, int day, int year) {

        Calendar calendar = Calendar.getInstance();

        calendar.set(year, month - 1, day);

        String[] days = {
            "SUNDAY",
            "MONDAY",
            "TUESDAY",
            "WEDNESDAY",
            "THURSDAY",
            "FRIDAY",
            "SATURDAY"
        };

        return days[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }
}
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(System.in)
        );

        String[] input = bufferedReader.readLine().trim().split("\\s+");

        int month = Integer.parseInt(input[0]);
        int day = Integer.parseInt(input[1]);
        int year = Integer.parseInt(input[2]);

        String result = Result.findDay(month, day, year);

        System.out.println(result);

        bufferedReader.close();
    }
