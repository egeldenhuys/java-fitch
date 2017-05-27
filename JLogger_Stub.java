// Stub file for submitting
// Used by black-fitch for debugging
// Side effect of using black-fitch libraries for production code

public class JLogger {
    public static final int DEBUG = 0;
    public static final int ERROR = 1;
    public static final int FATAL = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static int logLevel = 0;
    public static void log(int level, String msg) { }
    public static void logTemplate(int level, String msg, int line) { }
}