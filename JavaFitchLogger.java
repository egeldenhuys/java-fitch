public class JavaFitchLogger {

    public static final int DEBUG = 0;
    public int logLevel = 0;

    public JavaFitchLogger(int defaultLevel) {
        logLevel = defaultLevel;
    }

    public void log(int level, String msg) {
        if (logLevel == level) {
            if (level == DEBUG) {
                int callersLineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
                logTemplate(level, msg, callersLineNumber);
            }
        }
    }

    public void logTemplate(int level, String msg, int line) {
        if (level == DEBUG) {
            System.out.println("[DEBUG][" + line + "] " + msg);
        }
    }
}
