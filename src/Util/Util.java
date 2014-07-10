package Util;

import java.util.ArrayList;
import java.util.List;

public class Util {

	public static List<Long> generateListOfPrimes(Long limit) {
		
//		Map<Long, Boolean> isNotPrimeMap = new HashMap<Long, Boolean>();
		List<Long> notPrimes = new ArrayList<Long>();
//		boolean[] isNotPrime = new boolean[limit];
		List<Long> primes = new ArrayList<Long>();
		Long firstPrime = (long) 2;
		
		while(firstPrime <= limit){
			for (; firstPrime <= limit; firstPrime++) {
//				if(!isNotPrime[firstPrime-2]){
				if(!notPrimes.contains(firstPrime)){
					primes.add(firstPrime);
//					System.out.println(firstPrime);
					break;
				}
			}
			for(int i = 2;i <= limit/firstPrime; i++){
				notPrimes.add(firstPrime*i);
//				isNotPrime[(firstPrime*i)-2] = true;
			}
			firstPrime++;
		}
		
		return primes;
	}
	
	public static List<Long> generateListOfPrimes2(Long limit) {
		List<Long> primes = new ArrayList<Long>();
		primes.add(2L);
		
		Long testingPrime = 2L;
		testingPrime++;
		while(testingPrime <= limit){
			boolean test = true;
			int sqrtAux = (int) Math.sqrt(testingPrime);
			Long sqrtTp = new Long( sqrtAux);
			for (Long prime : primes) {
				if (prime > sqrtTp)
					break;
				if (testingPrime% prime == 0){
					test = false;
					break;
				}
			}
			if (test){
				System.out.println(testingPrime);
				primes.add(testingPrime);
			}
			testingPrime+=2;
		}
		
		return primes;
	}
	
	public static Long nextPrime(List<Long> previousPrimes){
		Long attemptPrime = previousPrimes.get(previousPrimes.size()-1) + 1;
		while(true){
			boolean isPrime = true;
			for (Long previousPrime : previousPrimes) {
				if((attemptPrime % previousPrime) == 0){
					attemptPrime++;
					isPrime = false;
					break;
				}
			}
			if(isPrime == true)
				return attemptPrime;
		}
	}

	public static boolean isPalindrome(Long num) {
		
		String sNum = num.toString();
		int numSize = sNum.length();
		
		for (int i = 0; i <= numSize/2; i++){
			if (sNum.charAt(i) != sNum.charAt(numSize-i-1))
				return false;
		}
		return true;
	}

	public static int largestDigitNumber(int digits) {
		int result = 0;
		for(int i = 1; i<= digits; i++ )
			result = (result*10)+9;
		return result;
	}
	
	public static Long sumListOfLongs(List<Long> l){
		Long result = 0L;
		
		for (Long long1 : l) {
			result+=long1;
		}
		return result;
	}
}
