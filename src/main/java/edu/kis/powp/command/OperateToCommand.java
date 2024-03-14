package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

/**
 * Commands to API function operateTo
 */
public class OperateToCommand implements DriverCommand {
    int x = 0, y = 0;
    private final Job2dDriver driver;
    public OperateToCommand(Job2dDriver driver, int x, int y) {
        this.driver = driver;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        driver.operateTo(this.x, this.y);
    }
}
