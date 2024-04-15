package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class SetPositionCommand implements DriverCommand {
    private int x;
    private int y;
    private final Job2dDriver driver;

    public SetPositionCommand(int x, int y, Job2dDriver driver) {
        this.x = x;
        this.y = y;
        this.driver = driver;
    }

    public void changePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        driver.setPosition(x, y);
    }
}
