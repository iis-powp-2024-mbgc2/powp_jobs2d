package edu.kis.powp.command.factories;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

public interface CommandFactory {
    ComplexCommand getCommand(Job2dDriver driver, Integer... parameters) throws InvalidParametersException;
}
