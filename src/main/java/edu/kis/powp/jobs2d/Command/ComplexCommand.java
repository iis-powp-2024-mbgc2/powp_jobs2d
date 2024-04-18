package edu.kis.powp.jobs2d.Command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand{
    private List<DriverCommand> commands;

    public ComplexCommand(){
        this.commands = new ArrayList<>();
    }


    public void addCommand(DriverCommand command){
        commands.add(command);
    }

    public DriverCommand removeCommand(int indeks){
        return commands.remove(indeks);
    }

    public static ComplexCommand createKolo(Job2dDriver driver, int x, int y, int radius){
        ComplexCommand complexCommand = new ComplexCommand();

        complexCommand.addCommand(new SetPositionCommand(x + radius, y, driver));

        for (int angle = 0; angle < 360; angle++) {
            double radians = Math.toRadians(angle);
            int nextX = (int) (x + radius * Math.cos(radians));
            int nextY = (int) (y + radius * Math.sin(radians));
            complexCommand.addCommand(new OperateToCommand(nextX, nextY, driver));
        }

        return complexCommand;
    }

    public static ComplexCommand createRect(Job2dDriver driver, int x, int y, int width, int height){
        ComplexCommand complexCommand = new ComplexCommand();

        complexCommand.addCommand(new SetPositionCommand(x,y,driver));

        complexCommand.addCommand(new OperateToCommand(x + width,y,driver));
        complexCommand.addCommand(new OperateToCommand(x + width ,y + height,driver));
        complexCommand.addCommand(new OperateToCommand(x ,y + height,driver));
        complexCommand.addCommand(new OperateToCommand(x,y,driver));
        return complexCommand;
    }




    @Override
    public void execute() {
        commands.forEach(DriverCommand::execute);
    }
}
