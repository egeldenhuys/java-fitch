/*
This class constructs all test suites and runs them
*/

import java.util.*;

public class JavaFitch {

	public static ArrayList<JavaFitchUnitTest> testList = new ArrayList<JavaFitchUnitTest>();

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

		printFooter("OVERALL", result, testsPassed, testsCount, assertsPassed, assertsPassed);
	}

	public static void addSuite(JavaFitchUnitTest test) {
		testList.add(test);
	}

	public static void printHeader(String title) {
		System.out.println("XXXXXXXXX SUITE: " + title + " XXXXXXXXXX");
	}

	public static void printFooter(String title, boolean result, int testsCount, int testsPassed, int assertsCount, int assertsPassed) {
		System.out.println("________ SUMMARY for " + title + " _________");
		System.out.println(resultToString(result));
		System.out.println("tests: " + testsPassed + " passed | " + testsCount);
		System.out.println("assertions: " + assertsPassed + " passed | " + assertsCount);
		System.out.println("_____________________________________________");
	}

	public static String resultToString(boolean value) {

		String result = "";

		if (value == true) {
			result = "PASS";
		} else {
			result = "FAIL";
		}

		return result;
	}
}
