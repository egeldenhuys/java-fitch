/*
This class manages test suites and collects their results
*/

import java.util.*;

public class JavaFitch {

	public static final String VERSION = "v0.1.0";

	public static ArrayList<JavaFitchUnitTest> testList = new ArrayList<JavaFitchUnitTest>();

	public static String TITLE_COLOUR = "\u001B[38;5;44m";
	public static String TITLE_COLOUR_2 = "\u001B[38;5;202m";
	public static String GREEN = "\u001B[32m";
	public static String RED = "\u001B[31m";
	public static String RESET = "\u001B[39;49m";

	static int testsCount = 0;
	static int testsPassed = 0;
	static int assertsCount = 0;
	static int assertsPassed = 0;
	static boolean result = true;

	public static void testWrapper(JavaFitchUnitTest test) {
		printHeader(test.name);
		result = result & test.run();

		testsCount += test.testsCount;
		testsPassed += test.testsPassed;
		assertsCount += test.assertsCount;
		assertsPassed += test.assertsPassed;
	}

	public static void runAllTests() {
		for (int i = 0; i < testList.size(); i++) {
			testWrapper(testList.get(i));
		}

		for (int i = 0; i < testList.size(); i++) {
			printFooter(testList.get(i).name, testList.get(i).testResult,
			testList.get(i).testsPassed, testList.get(i).testsCount,
			testList.get(i).assertsPassed, testList.get(i).assertsCount);
		}

		printFooter("OVERALL", result, testsPassed, testsCount, assertsPassed, assertsCount);
	}

	public static void addSuite(JavaFitchUnitTest test) {
		testList.add(test);
	}

	public static void printHeader(String title) {
		System.out.println("XXXXXXXXX SUITE: " + TITLE_COLOUR + title + RESET + " XXXXXXXXXX");
	}

	public static void printFooter(String title, boolean result, int testsCount, int testsPassed, int assertsCount, int assertsPassed) {
		System.out.println("________ SUMMARY for " + TITLE_COLOUR + title + RESET + " _________");
		System.out.println(resultToString(result));
		System.out.println("tests: " + testsPassed + " passed | " + testsCount);
		System.out.println("assertions: " + assertsPassed + " passed | " + assertsCount);
		System.out.println("_____________________________________________");


	}

	public static String resultToString(boolean value) {

		String result = "";

		if (value == true) {
			result = GREEN + "PASS" + RESET;
		} else {
			result = RED + "FAIL" + RESET;
		}

		return result;
	}
}
