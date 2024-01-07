
public class Calendar0 {	
	
	public static void main(String args[]) {
		int year = Integer.parseInt(args[0]);
		isLeapYearTest(year);
		nDaysInMonthTest(year);
	}
		 
	private static void isLeapYearTest(int year) {
		String commonOrLeap = "common";
		if (isLeapYear(year)) {
			commonOrLeap = "leap";
		}
		System.out.println(year + " is a " + commonOrLeap + " year");  
	}

	private static void nDaysInMonthTest(int year) {
		for (int i = 1; i < 13; i++) {
			nDaysInMonth(i, year);
		}
	}
	
	public static boolean isLeapYear(int year) {
	    if (year%4 == 0) return true;
		return false;
	}
	 

	public static int nDaysInMonth(int month, int year) {
		if (month == 2) {
			if (isLeapYear(year)) {
				System.out.println ("Month " + month + " has 29 days");
			} else {
				System.out.println ("Month " + month + " has 28 days");
			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println ("Month " + month + " has 30 days"); 	
		} else {
			System.out.println ("Month " + month + " has 31 days"); 
		}
		return 0;
	}
}

