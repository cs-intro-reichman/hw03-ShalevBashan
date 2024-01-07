
public class LoanCalc {
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter;    // Monitors the efficiency of the calculation
	

	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		
		//Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}
	

    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
    	double l = loan;
		double r = rate;
		double e = epsilon;
		double p = (l/n + e);
		boolean b  = false;
		while (!b) {
			l = loan;
			l = endBalance(l, r, n, p);
			if (l > e){
				p += e;
			} else {
				b = true;
			}
			iterationCounter++;
		}
    	return p;
    }
    
 
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
    	iterationCounter = 0;
		double l = loan;
		double r = rate;
		double e = epsilon;
		boolean b  = false;
		Double low = (l/n);
		Double high = (l/n)*Math.pow(1+r/100,n -1);
		double p = (low + high) / 2;
		double temp = 0;
    	while (!b) {
			l = loan;
			l = endBalance(l, r, n, p);
			if (l < -e) { 
				high = p;
				p = (low + high) / 2; 
			} else if (l > e) {
				low = p;
				p = (low + high) / 2;
			} else {
				b = true;
			}
			iterationCounter++;
		}
		return p;
    }
	

	private static double endBalance(double loan, double rate, int n, double payment) {
		double l = loan;
		double r = rate;
		double p = payment;
		for (int i  = 0; i < n; i++) {
				l = (l - p) * (1 + r/100);
			}
    	return l;
	}
}