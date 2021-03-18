package com.h2;

import java.util.Map;
import java.util.Scanner;

public class BestLoanRates {

	public static void main(String[] args) {
		System.out.println("Enter your name");
		Scanner scanner = new Scanner(System.in);
		try {
			String name = scanner.nextLine();
			System.out.println("Hello " + name);
			System.out.println("Enter the loan term (in years)");
			int loanTermInYears = scanner.nextInt();
			float bestRate = getRates(loanTermInYears);
			if(bestRate == 0.0f) {
				System.out.println("No available rates for term: " + loanTermInYears + " years");
			}
			else {
				System.out.println("Best Available Rate: " + bestRate + "%");
			}
		} finally {
			scanner.close();
		}
	}

	public static final Map<Integer, Float> bestRates() {
		return Map.of(1, 5.50f, 2, 3.45f, 3, 2.67f);
	}

	public static float getRates(int loanTermInYears) {
		Float bestRate = bestRates().get(loanTermInYears);
		return bestRate != null ? bestRate : 0.0f;
	}
}
