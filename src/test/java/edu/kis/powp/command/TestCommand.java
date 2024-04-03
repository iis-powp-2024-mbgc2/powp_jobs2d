package edu.kis.powp.command;

import edu.kis.powp.command.factories.CommandFactory;
import edu.kis.powp.command.factories.DrawRectangleFactory;
import edu.kis.powp.command.factories.DrawTriangleFactory;
import edu.kis.powp.command.factories.InvalidParametersException;
import edu.kis.powp.jobs2d.Job2dDriver;

public class TestCommand {

    static public void rectangleTest(Job2dDriver driver) {
        try {
            CommandFactory factory = new DrawRectangleFactory();
            ComplexCommand command = factory.getCommand(driver, 100, 100);
            command.execute();
        } catch (InvalidParametersException e) {
            e.logInfo();
        }
    }

    static public void triangleTest(Job2dDriver driver) {
        try {
            CommandFactory factory = new DrawTriangleFactory();
            ComplexCommand command = factory.getCommand(driver, 50);
            command.execute();
        } catch (InvalidParametersException e) {
            e.logInfo();
        }
    }

    static public void customTest(Job2dDriver driver) {
        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand(driver, 0, 0));
        command.addCommand(new OperateToCommand(driver, 15, 0));
        command.addCommand(new OperateToCommand(driver, 15, 15));
        command.addCommand(new OperateToCommand(driver, 0, 15));
        command.addCommand(new OperateToCommand(driver, 0, 0));
        command.execute();
    }
}
