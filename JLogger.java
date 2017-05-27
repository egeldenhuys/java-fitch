public class JLogger {

    public static final int DEBUG = 0;
    public static final int ERROR = 1;
    public static final int FATAL = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;

    public static int logLevel = 0;

    public static void log(int level, int msg) {
        log(level, Integer.toString(msg));
    }

    public static void log(int level, String msg) {

        if (logLevel <= level) {
            int callersLineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
            logTemplate(level, msg, callersLineNumber);
        }
    }

    public static void logTemplate(int level, String msg, int line) {
        // TODO: Use a map?

        String typeName = "";

        if (level == DEBUG) {
            typeName = "DEBUG";
        } else if (level == ERROR) {
            // NOTE: Not all terminals support
            typeName = "\u001B[31mERROR\u001B[39;49m";
        } else if (level == WARN) {
            typeName = "\u001B[31mWARN\u001B[39;49m";
        }

        System.out.println("[" + typeName + "][" + line + "] " + msg);
    }
}
