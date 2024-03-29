package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class RectangleCommandFactory implements ComplexCommandFactory {
    private final Job2dDriver driver;

    public RectangleCommandFactory(Job2dDriver driver) {
        this.driver = driver;
    }

    @Override
    public DriverCommand createCommand(int x, int y, int width, int height) {
        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand(x, y, driver));
        command.addCommand(new OperateToCommand(x + width, y, driver));
        command.addCommand(new OperateToCommand(x + width, y + height, driver));
        command.addCommand(new OperateToCommand(x, y + height, driver));
        command.addCommand(new OperateToCommand(x, y, driver));

        return command;
    }
}

