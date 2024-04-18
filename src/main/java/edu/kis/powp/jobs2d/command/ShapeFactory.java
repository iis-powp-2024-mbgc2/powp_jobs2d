package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ShapeFactory {
	public static ComplexCommand createRectangle(Job2dDriver driver,int x ,int y, int width, int heihght){
		ComplexCommand commandRectangle = new ComplexCommand();

		commandRectangle.addCommand(new SetPositionCommand(driver, x, y));
		commandRectangle.addCommand(new OperateToCommand(driver, x + width, y));
		commandRectangle.addCommand(new OperateToCommand(driver, x + width, y+heihght));
		commandRectangle.addCommand(new OperateToCommand(driver, x, y+heihght));
		commandRectangle.addCommand(new OperateToCommand(driver, x, y));

		return commandRectangle;
	}


	public static ComplexCommand createTriangle(Job2dDriver driver,int x ,int y, int radius){
		ComplexCommand commandRectangle = new ComplexCommand();

		commandRectangle.addCommand(new SetPositionCommand(driver, x, y));
		commandRectangle.addCommand(new OperateToCommand(driver, x + radius, y));
		commandRectangle.addCommand(new OperateToCommand(driver, x+radius/2 , y+radius));
		commandRectangle.addCommand(new OperateToCommand(driver, x, y));

		return commandRectangle;
	}
}
