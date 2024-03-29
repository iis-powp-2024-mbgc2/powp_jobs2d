package edu.kis.powp.jobs2d.drivers.command;

public class SetPosisionCommand implements DriverCommand {
    private int x;
    private int y;

    public SetPosisionCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
    }
}
