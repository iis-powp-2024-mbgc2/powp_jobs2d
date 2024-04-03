package edu.kis.powp.command.factories;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

import static java.lang.Math.sqrt;

public class DrawTriangleFactory implements CommandFactory {
    @Override
    public ComplexCommand getCommand(Job2dDriver driver, Integer... oneSizeParameter) throws InvalidParametersException {
        if(oneSizeParameter.length < 1) throw new InvalidParametersException();
        ComplexCommand command = new ComplexCommand();
        int height = (int)(oneSizeParameter[0] * sqrt(3) / 2);
        int halfBase = (int)(oneSizeParameter[0] * 0.5);
        command.addCommand(new SetPositionCommand(driver, 0, 0));
        command.addCommand(new OperateToCommand(driver, halfBase, height));
        command.addCommand(new OperateToCommand(driver, oneSizeParameter[0], 0));
        command.addCommand(new OperateToCommand(driver, 0, 0));
        return command;
    }
}
