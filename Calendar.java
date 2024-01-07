public class Calendar {
    static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;    
	static int nDaysInMonth = 31;
    public static void main(String[] args) {
        int choosenY = Integer.parseInt(args[0]);
        while (year < choosenY) {
            advance();
        }
     	while (year < (choosenY + 1)) {
			if (dayOfWeek == 1){
				System.out.println (dayOfMonth +"/" + month + "/" + year + " Sunday");
			} else {
				System.out.println (dayOfMonth +"/" + month + "/" + year);
			}
	 		advance();
        }
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
