package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class SetPositionCommand implements DriverCommand{
	private int y;
	private int x;
	private Job2dDriver driver;

	public SetPositionCommand(int x , int y){
		this.x = x;
		this.y = y;
	}

	public void setDriver(Job2dDriver driver){
		this.driver = driver;
	}
	@Override
	public void execute(){
		driver.setPosition(x, y);
	}
}
