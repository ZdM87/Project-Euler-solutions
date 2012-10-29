/* 
 * Solution to Project Euler problem 44
 * By Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/project-euler-solutions
 * https://github.com/nayuki/Project-Euler-solutions
 */


public final class p044 {
	
	public static void main(String[] args) {
		System.out.println(new p045().run());
	}
	
	
	public String run() {
		for (long i = 1; ; i++) {
			long penti = pentagonalNumber(i);
			for (long j = i; pentagonalNumber(j) - pentagonalNumber(j - 1) <= penti; j++) {
				if (isPentagonalNumber(pentagonalNumber(j) - penti) && isPentagonalNumber(2 * pentagonalNumber(j) - penti))
					return Long.toString(penti);
			}
		}
	}
	
	
	private static long pentagonalNumber(long n) {
		if (n <= 0 || n > 2479700524L)
			throw new IllegalArgumentException();
		return n * (3 * n - 1) >>> 1;
	}
	
	
	private static boolean isPentagonalNumber(long n) {
		long temp = 0;
		for (long i = 2147483648L; i != 0; i >>>= 1) {
			temp |= i;
			if (temp > 2479700524L || pentagonalNumber(temp) > n)
				temp ^= i;
		}
		return temp != 0 && pentagonalNumber(temp) == n;
	}
	
}
