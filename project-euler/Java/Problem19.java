import java.util.Arrays;
import java.util.List;

public class Problem19 {
	static List<Integer> months;
	static List<String> weekdays;

	public static void main(String arg[]) {
		months = Arrays.asList(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
		weekdays = Arrays.asList("Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag", "Lördag", "Söndag");
		int year = 1901;
		int month = 1;
		int day = 1;
		int result = 0;

		while (year < 2001) {
			int totDays = totalDays(year);
			int total = days(year, month, day);
			total = total + totDays;

			if (day == 1 && weekdays.get(total % 7).toString().equals("Söndag")) {
				result++;
			}
			if (day == months.get(month - 1)) {
				if (month == 12) {
					year++;
					month = 0;
				}
				day = 1;
				month++;
			} else {
				day++;
			}
		}
		System.out.println(result);
	}

	static int totalDays(int year) {
		int i = 1754;
		int total = 0;
		while (i < year) {
			if (leapyear(i)) {
				total = total + 366;
			} else {
				total = total + 365;
			}
			i++;
		}
		return total;
	}

	static int days(int year, int month, int day) {
		int total = 0;
		for (int i = 0; i < month - 1; i++) {
			total = total + months.get(i);
		}
		total = total + day;
		if (leapyear(year) == true && month >= 3) {
			total = total + 1;
		}
		return total;
	}

	static boolean leapyear(int year) {
		if (year % 4 == 0) {
			if (!(year % 100 == 0) || year % 400 == 0) {
				return true;
			}
		}
		return false;
	}
}
