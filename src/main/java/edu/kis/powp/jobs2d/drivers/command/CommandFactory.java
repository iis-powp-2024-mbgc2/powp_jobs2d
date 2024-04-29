package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class CommandFactory {
    public static ComplexCommand createRectangle(Job2dDriver driver,int x_start_coord, int y_start_coord,int vertical_side_lenght, int horizontal_side_lenght)
    {
        ComplexCommand com = new ComplexCommand();

        com.addCommand(new SetPositionCommand(driver, x_start_coord, y_start_coord));
        com.addCommand(new OperateToCommand(driver, x_start_coord+vertical_side_lenght, y_start_coord));
        com.addCommand(new OperateToCommand(driver, x_start_coord+vertical_side_lenght, y_start_coord+horizontal_side_lenght));
        com.addCommand(new OperateToCommand(driver, x_start_coord, y_start_coord+horizontal_side_lenght));
        com.addCommand(new OperateToCommand(driver, x_start_coord, y_start_coord));

        return com;
    }

    public static ComplexCommand createSquare(Job2dDriver driver, int x_start_coord, int y_start_coord, int side_lenght)
    {
        ComplexCommand com = new ComplexCommand();

        com.addCommand(new SetPositionCommand(driver, x_start_coord, y_start_coord));
        com.addCommand(new OperateToCommand(driver, x_start_coord + side_lenght, y_start_coord));
        com.addCommand(new OperateToCommand(driver, x_start_coord + side_lenght, y_start_coord + side_lenght));
        com.addCommand(new OperateToCommand(driver, x_start_coord, y_start_coord + side_lenght ));
        com.addCommand(new OperateToCommand(driver, x_start_coord, y_start_coord));

        return com;
    }


}
