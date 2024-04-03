package edu.kis.powp.command.factories;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

public class DrawRectangleFactory implements CommandFactory{
    @Override
    public ComplexCommand getCommand(Job2dDriver driver, Integer... twoSizeParameters) throws InvalidParametersException {
        if(twoSizeParameters.length < 2) throw new InvalidParametersException();
        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand(driver, 0, 0));
        command.addCommand(new OperateToCommand(driver, twoSizeParameters[0], 0));
        command.addCommand(new OperateToCommand(driver, twoSizeParameters[0], twoSizeParameters[1]));
        command.addCommand(new OperateToCommand(driver, 0, twoSizeParameters[1]));
        command.addCommand(new OperateToCommand(driver, 0, 0));
        return command;
    }
}
