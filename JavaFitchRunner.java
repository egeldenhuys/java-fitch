/*
USER FILE

All test suites are registered here
*/

public class JavaFitchRunner extends JavaFitch{

	public static void main(String[] args) {
		System.out.println("Starting Java Fitch " + VERSION + "...");

		JavaFitchUnitTest suite_Task1 = new tests_Task1("Task 1");
		addSuite(suite_Task1);
		runAllTests();
	}

}
