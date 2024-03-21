package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand {
    private int x;
    private int y;

    private Job2dDriver driver;

    private void operateTo(Job2dDriver driver, int x, int y)
    {
        this.driver = driver;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        this.driver.operateTo(x, y);
    }
}
