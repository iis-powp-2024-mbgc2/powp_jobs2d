package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class CommandFactory {
    public static DriverCommand makeSquare(Job2dDriver driver, int x, int y, int len) {
        ComplexCommand square = new ComplexCommand();
        square.addDriverCommandList(new SetPositionCommand(driver, x, y));
        square.addDriverCommandList(new OperateToCommand(driver, x + len, y));
        square.addDriverCommandList(new OperateToCommand(driver, x + len, y + len));
        square.addDriverCommandList(new OperateToCommand(driver, x, y + len));
        square.addDriverCommandList(new OperateToCommand(driver, x, y));
        return square;
    }
    public static DriverCommand makeTriangle(Job2dDriver driver, int x1, int y1, int x2, int y2, int x3, int y3) {
        ComplexCommand triangle = new ComplexCommand();
        triangle.addDriverCommandList(new SetPositionCommand(driver, x1, y1));
        triangle.addDriverCommandList(new OperateToCommand(driver, x2, y2));
        triangle.addDriverCommandList(new OperateToCommand(driver, x3, y3));
        triangle.addDriverCommandList(new OperateToCommand(driver, x1, y1));
        return triangle;
    }
}
