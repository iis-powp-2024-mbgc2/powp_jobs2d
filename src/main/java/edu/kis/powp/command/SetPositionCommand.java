package edu.kis.powp.command;

public class SetPositionCommand implements DriverCommand {
    private int x;
    private int y;

    SetPositionCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void execute() {
        System.out.println("execute() from SetPositionCommand...");
    }
}
