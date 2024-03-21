package edu.kis.powp.command;

public class OperateToCommand implements DriverCommand {
    private int x;
    private int y;

    OperateToCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void execute() {
        System.out.println("execute() from OperateToCommand...");
    }
}
