package seedu.ezmanager;

import java.io.IOException;
import java.util.logging.*;

public class EZLogger {
    private static Logger ezLogger = Logger.getLogger("EZLogger");
    private static FileHandler fh;
    private static boolean toLog;

    public static void setup() {
        LogManager.getLogManager().reset();
        toLog = true;

        try {
            fh = new FileHandler("./ezlogger.log");
            fh.setLevel(Level.FINE);
            fh.setFormatter(new SimpleFormatter());
            ezLogger.addHandler(fh);
        } catch (IOException e) {
            ezLogger.log(Level.SEVERE, "File logger not configured", e);
            toLog = false;
        }
    }

    public static void log(Level level, String message) {
        if (toLog) {
            ezLogger.log(level, message);
        }
    }

}
