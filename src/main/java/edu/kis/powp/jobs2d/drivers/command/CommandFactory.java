package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class CommandFactory {
    public ComplexCommand createRectangle(Job2dDriver driver,int x, int y,int a, int b)
    {
        ComplexCommand com = new ComplexCommand();

        com.addCommand(new SetPositionCommand(driver, x, y));
        com.addCommand(new OperateToCommand(driver, x+a, y));
        com.addCommand(new OperateToCommand(driver, x+a, y+b));
        com.addCommand(new OperateToCommand(driver, x, y+a));
        com.addCommand(new OperateToCommand(driver, x, y));

        return com;
    }

    public ComplexCommand createSquare(Job2dDriver driver, int x, int y, int a)
    {
        ComplexCommand com = new ComplexCommand();

        com.addCommand(new SetPositionCommand(driver, x, y));
        com.addCommand(new OperateToCommand(driver, x + a, y));
        com.addCommand(new OperateToCommand(driver, x + a, y + a));
        com.addCommand(new OperateToCommand(driver, x, y + a ));
        com.addCommand(new OperateToCommand(driver, x, y));

        return com;
    }


}
