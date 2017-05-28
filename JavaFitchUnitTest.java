/*
Defines the base functions for a test suite
*/

public class JavaFitchUnitTest {

	public static String TITLE_COLOUR = "\u001B[38;5;44m";
	public static String TITLE_COLOUR_2 = "\u001B[38;5;202m";
	public static String GREEN = "\u001B[32m";
	public static String RED = "\u001B[31m";
	public static String RESET = "\u001B[39;49m";

	public int testsPassed = 0;
	public int testsCount = 0;
	public int assertsPassed = 0;
	public int assertsCount = 0;
	public int assertsPassedSubTest = 0;
	public int assertsCountSubTest = 0;
	public boolean testResult = true;
	public String name = "";

	public JavaFitchUnitTest(String n) {
		name = n;
	}

	public boolean run() {
		System.out.println("JavaFitchUnitTest::run() not implemented!");

		return false;
	}

	public void printHeader(String title) {
		title = TITLE_COLOUR_2 + title + RESET;
		assertsCountSubTest = 0;
		assertsPassedSubTest = 0;

		System.out.println("\t=========================");
		System.out.println("\t" + title);
		System.out.println("\t=========================");

	}

	public boolean start_test_case(String title) {
		printSubTest(title);
		return true;
	}

	public boolean end_test_case(boolean result, boolean subResult) {
		printSubTestFooter(subResult);
		testResult = testResult & subResult;
		return result & subResult;
	}

	public void printFooter(String title, boolean result) {
		testsCount++;

		if (result == true) {
			testsPassed++;
		}

		System.out.println("\t_____ SUMMARY: " + title + " _____");
		//System.out.print("\t" + title + " Summary: ");
		System.out.println("\t" + resultToString(result));
		System.out.println("\tassertions: " + assertsPassedSubTest + " passed | " + assertsCountSubTest);
		System.out.println("\t_________________________");
	}

	public void printSubTest(String title) {

		System.out.println("\t\t-----------------------");
		System.out.print("\t\t" + title + ": ");
	}

	public void printSubTestFooter(boolean value) {
		if (value != false) {
			System.out.println(resultToString(value));
			System.out.println("\t\t-----------------------");
		} else {
			System.out.println("\n\t\t-----------------------");
		}

	}

	public String resultToString(boolean value) {

		String result = "";

		if (value == true) {
			result = GREEN + "PASS" + RESET;
		} else {
			result = RED + "FAIL" + RESET;
		}

		return result;
	}

	public <T> boolean assertEquals(T expected, T received) {
		int tracer = Thread.currentThread().getStackTrace()[2].getLineNumber();

		assertsCount++;
		assertsCountSubTest++;

		if (received.equals(expected)) {
			assertsPassed++;
			assertsPassedSubTest++;
			return true;
		} else {
			System.out.println();
			System.out.println(RED + "++++ ASSERT FAIL on line " + tracer + " ++++" + RESET);
			System.out.println("Expected: \n" + expected.toString());
			System.out.println("Received: \n" + received.toString() + "\n");
			System.out.println(RED + "++++++++++++++++++++++" + RESET);

			return false;
		}
	}

	public <T> boolean assertNull(T received, int tracer) {
		tracer++;
		assertsCount++;
		assertsCountSubTest++;

		if (received == null) {
			assertsPassed++;
			assertsPassedSubTest++;
			return true;
		} else {
			System.out.println();
			System.out.println(RED + "++++ ASSERT FAIL on line " + tracer + " ++++" + RESET);
			System.out.println("Expected: \n" + "null");
			System.out.println("Received: \n" + received.toString() + "\n");
			System.out.println(RED + "++++++++++++++++++++++" + RESET);

			return false;
		}
	}

	public <T> boolean assertNull(T received) {

		assertsCount++;
		assertsCountSubTest++;

		if (received == null) {
			assertsPassed++;
			assertsPassedSubTest++;
			return true;
		} else {
			System.out.println();
			System.out.println(RED + "++++ ASSERT FAIL ++++" + RESET);
			System.out.println("Expected: \n" + "null");
			System.out.println("Received: \n" + received.toString() + "\n");
			System.out.println(RED + "++++++++++++++++++++++" + RESET);

			return false;
		}
	}
}
