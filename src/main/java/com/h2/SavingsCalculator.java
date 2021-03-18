package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Iterator;
import java.util.Scanner;

public class SavingsCalculator {

	private float[] credits;
	private float[] debits;
	
	public SavingsCalculator(float[] credits, float[] debits) {
		super();
		this.credits = credits;
		this.debits = debits;
	}
	
	private float sumOfCredits() {
		float sum = 0.0f;
		for (float credit : credits) {
			sum += credit;
		}
		return sum;
	}
	
	private float sumOfDebits() {
		float sum = 0.0f;
		for (float debit : debits) {
			sum += debit;
		}
		return sum;
	}
	
	private static int remainingDaysInMonth(LocalDate date) {
		YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
		int totalDaysInMonth = yearMonth.lengthOfMonth();
		int remainingDays = totalDaysInMonth - date.getDayOfMonth();
		return remainingDays;
	}
	
	public float calculate() {
		return sumOfCredits() - sumOfDebits();
	}
	
	public static void main(String[] args) {
		
		String[] creditsAsString = args[0].split(",");
		String[] deditsAsString = args[1].split(",");
		
		float[] credits = new float[creditsAsString.length];
		for (int i = 0; i < creditsAsString.length; i++) {
			credits[i] = Float.parseFloat(creditsAsString[i]);
		}
		
		float[] dedits = new float[deditsAsString.length];
		for (int i = 0; i < deditsAsString.length; i++) {
			dedits[i] = Float.parseFloat(deditsAsString[i]);
		}
		
		SavingsCalculator sc = new SavingsCalculator(credits, dedits);
		float netSavings = sc.calculate();
		System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
	
	}
}











