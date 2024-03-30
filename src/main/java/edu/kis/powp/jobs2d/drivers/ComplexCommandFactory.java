package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ComplexCommandFactory {

    public static DriverCommand createRectangle(Job2dDriver driver, int x, int y, int width, int height) {
        ComplexCommand rectangleCommand = new ComplexCommand();
        rectangleCommand.addCommand(new SetPositionCommand(x, y, driver));
        rectangleCommand.addCommand(new OperateToCommand(x, y + height, driver));
        rectangleCommand.addCommand(new OperateToCommand(x + width, y + height, driver));
        rectangleCommand.addCommand(new OperateToCommand(x + width, y, driver));
        rectangleCommand.addCommand(new OperateToCommand(x, y, driver));
        return rectangleCommand;
    }
    public static DriverCommand createSquare(Job2dDriver driver, int x, int y, int side) {
        ComplexCommand squareCommand = new ComplexCommand();
        squareCommand.addCommand(new SetPositionCommand(x, y, driver));
        squareCommand.addCommand(new OperateToCommand(x, y + side, driver));
        squareCommand.addCommand(new OperateToCommand(x + side, y + side, driver));
        squareCommand.addCommand(new OperateToCommand(x + side, y, driver));
        squareCommand.addCommand(new OperateToCommand(x, y, driver));
        return squareCommand;
    }
    public static DriverCommand createTriangle(Job2dDriver driver, int x, int y, int side) {
        ComplexCommand triangleCommand = new ComplexCommand();
        triangleCommand.addCommand(new SetPositionCommand(x, y, driver));
        triangleCommand.addCommand(new OperateToCommand(x + side, y, driver));
        int height = (int) ((side * Math.sqrt(3)) / 2);
        triangleCommand.addCommand(new OperateToCommand(x + (side/2), y-height, driver));
        triangleCommand.addCommand(new OperateToCommand(x, y, driver));
        return triangleCommand;
    }
}
