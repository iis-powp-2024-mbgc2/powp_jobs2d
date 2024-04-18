package edu.kis.powp.jobs2d.drivers.Command;

import edu.kis.powp.jobs2d.Job2dDriver;


import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand {
    private int x;
    private int y;
    private final Job2dDriver driver;

    OperateToCommand(int x, int y, Job2dDriver driver){
        this.x = x;
        this.y = y;
        this.driver = driver;
    }

    public void setPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    @Override
    public void execute(){
        driver.operateTo(this.x, this.y);
    }

}
