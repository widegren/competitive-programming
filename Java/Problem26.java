import java.util.*;

public class Problem26 {
	public static void main(String[] args) throws Exception {
		int maxNumber = 0;
		int maxReminderString = 0;
		for (int i = 1; i < 1000; ++i) {
			int reminderString = getRecurN(i);
			if (reminderString > maxReminderString) {
				maxNumber = i;
				maxReminderString = reminderString;
			}
		}

		System.out.println(maxNumber + ":" + maxReminderString);
	}

	static int getRecurN(int n) {
		int reminder = 1;
		HashSet<Integer> reminders = new HashSet<>();

		while (true) {
			reminder %= n;
			if (reminders.contains(reminder) || reminder == 0) {
				break;
			} else {
				reminders.add(reminder);
				reminder *= 10;
			}
		}

		return reminders.size();
	}
}
