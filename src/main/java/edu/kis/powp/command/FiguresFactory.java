package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class FiguresFactory {
    public static ComplexCommand buildFigure1(Job2dDriver driver) {
        ComplexCommand commands = new ComplexCommand();

        commands.addCommand(new SetPositionCommand(-100, -100, driver));
        commands.addCommand(new OperateToCommand(-100, 0, driver));
        commands.addCommand(new OperateToCommand(100, 0, driver));
        commands.addCommand(new OperateToCommand(100, -100, driver));
        commands.addCommand(new OperateToCommand(-100, -100, driver));

        return commands;
    }

    public static ComplexCommand buildFigure2(Job2dDriver driver) {
        ComplexCommand commands = new ComplexCommand();

        commands.addCommand(new SetPositionCommand(-100, -100, driver));
        commands.addCommand(new OperateToCommand(0, 0, driver));
        commands.addCommand(new OperateToCommand(100, -100, driver));
        commands.addCommand(new OperateToCommand(-100, -100, driver));

        return commands;
    }

    public static ComplexCommand buildFigure3(Job2dDriver driver) {
        ComplexCommand commands = new ComplexCommand();

        commands.addCommand(new SetPositionCommand(-100, 0, driver));
        commands.addCommand(new OperateToCommand(-50, 87, driver));
        commands.addCommand(new OperateToCommand(50, 87, driver));
        commands.addCommand(new OperateToCommand(100, 0, driver));
        commands.addCommand(new OperateToCommand(50, -87, driver));
        commands.addCommand(new OperateToCommand(-50, -87, driver));
        commands.addCommand(new OperateToCommand(-100, 0, driver));

        return commands;
    }
}
