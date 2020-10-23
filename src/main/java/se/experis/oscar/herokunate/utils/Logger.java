package se.experis.oscar.herokunate.utils;

import java.util.ArrayList;

public class Logger {
    private static Logger loggerInstance = null;

    private ArrayList<Command> log;

    public ArrayList<Command> getLog() {
        return log;
    }

    public void logCommand(Command cmd) {
        System.out.println(cmd.toString());
        log.add(cmd);
    }

    private Logger() {
        log = new ArrayList<Command>();
    }

    public static Logger getInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Logger();
        }
        return loggerInstance;
    }
}
