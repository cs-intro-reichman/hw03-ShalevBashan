/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		int cnt = 0;
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.
	    //int debugDaysCounter = 0; 
	    //// Write the necessary initialization code, and replace the condition
	    //// of the while loop with the necessary condition 
	 	while (year < 2000) {
	 		if (dayOfWeek == 1 && dayOfMonth == 1) {
				cnt++;
			}	
			if (dayOfWeek == 1){
				System.out.println (dayOfMonth +"/" + month + "/" + year + " Sunday");
			} else {
				System.out.println (dayOfMonth +"/" + month + "/" + year);
			}
	 		advance();
        }
	 	System.out.println ("Druing the 20th century, " + cnt + " sundays fell on the first day of the month");
	 }
	

	 private static void advance() {
		dayOfMonth++;
		dayOfWeek++;
		if (dayOfMonth > nDaysInMonth(month, year)) {
			month++;
			dayOfMonth = 1;
		}
		if (month > 12) {
			year++;
			month = 1;
		}
		if (dayOfWeek > 7) {
			dayOfWeek = 1;
		}
	 } 
		 
	private static boolean isLeapYear(int year) {
		if (year%100 == 0 && year%400 != 0) {
			return false;
		}	else if (year%4 == 0) {
			return true;
		}
		return false;
	}
	 

	private static int nDaysInMonth(int month, int year) {
		int d = 0;
		if (month == 2) {
			if (isLeapYear(year)) {
				d = 29;
			} else {
				d = 28;
			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			d = 30; 	
		} else {
			d = 31; 
		}
		return d;
	}
}
