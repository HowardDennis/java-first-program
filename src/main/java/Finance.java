import java.util.Arrays;
import java.util.Map;

import com.h2.BestLoanRates;
import com.h2.MortgageCalculator;
import com.h2.SavingsCalculator;

public class Finance {

	public final static String BEST_LOAN_RATES = "bestLoanRates";
	public final static String SAVINGS_CALCULATOR = "savingsCalculator";
	public final static String MORTGAGE_CALCULATOR = "mortgageCalculator";
	public final static Map<String, String> commandsToUsage = Map.of(BEST_LOAN_RATES, "usage: bestLoanRates",
			SAVINGS_CALCULATOR, "usage: savingsCalculator <credits separated by ','> <debits separated by ','>",
			MORTGAGE_CALCULATOR, "usage: mortgageCalculator <loanAmount> <termInYears> <annualRate>");

	private static boolean validateCommandArguments(String[] args) {
		switch (args[0]) {
		case BEST_LOAN_RATES:

			return args.length - 1 == 0;

		case SAVINGS_CALCULATOR:

			return args.length - 1 == 2;

		case MORTGAGE_CALCULATOR:

			return args.length - 1 == 3;
		}

		return false;
	}

	private static void executeCommand(String command, String[] arguments) {

		switch (command) {
		case BEST_LOAN_RATES:

			System.out.println("Finding best loan rates ...");
			BestLoanRates.main(arguments);
			return;

		case SAVINGS_CALCULATOR:

			System.out.println("Finding your net savings ...");
			SavingsCalculator.main(arguments);
			return;

		case MORTGAGE_CALCULATOR:

			System.out.println("Finding your monthly payment ...");
			MortgageCalculator.main(arguments);
			return;
		}
	}
	
	public static void main(String[] args) {
		
		String command = args[0];
		if (commandsToUsage.containsKey(command)) {
			boolean isValidCommand = validateCommandArguments(args);
			if(!isValidCommand)
			{
				args[0] = commandsToUsage.get(command);
				System.out.println(args[0]);
				return;
			}
			executeCommand(command, Arrays.copyOfRange(args, 1, args.length));
		}
		else {
			System.out.println(command + ": command not found");
			return;
		}
	}
}











