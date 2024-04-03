package edu.kis.powp.command.factories;

import java.util.logging.Logger;

public class InvalidParametersException extends Exception {
    Logger logger = Logger.getLogger("global");
    @Override
    public void printStackTrace() {
        System.out.println("Not enough input arguments.");
    }

    public void logInfo() {
        this.logger.info("Not enough input arguments.");
    }
}
