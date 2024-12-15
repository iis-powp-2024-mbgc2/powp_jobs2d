package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand {

    private int x;
    private int y;

    private Job2dDriver driver;

    public OperateToCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        this.driver.operateTo(this.x, this.y);
    }

    public void setDriver(Job2dDriver driver) {
        this.driver = driver;
    }
}
