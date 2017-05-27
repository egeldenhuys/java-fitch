public class JavaFitchLogger {

    public static final int DEBUG = 0;
    public static final int ERROR = 1;
    public static final int FATAL = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;

    public int logLevel = 0;
    public String name = "";

    public JavaFitchLogger(int defaultLevel) {
        logLevel = defaultLevel;
    }

    public JavaFitchLogger(String n, int defaultLevel) {
        logLevel = defaultLevel;
        name = n;
    }

    public void log(int level, String msg) {
        if (logLevel <= level) {
            int callersLineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
            logTemplate(level, msg, callersLineNumber);
        }
    }

    public void logTemplate(int level, String msg, int line) {
        // TODO: Use a map?

        String typeName = "";

        if (level == DEBUG) {
            typeName = "DEBUG";
        } else if (level == ERROR) {
            typeName = "\u001B[31mERROR\u001B[39;49m";
        }

        System.out.println("[" + typeName + "][" + line + "][" + name + "] " + msg);
    }
}
