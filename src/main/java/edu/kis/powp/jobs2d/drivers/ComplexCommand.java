package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand {

    private List<DriverCommand> listCommands;
    ComplexCommand(){
        listCommands = new ArrayList<DriverCommand>();
    }
    public void addCommand(DriverCommand command){
        listCommands.add(command);
    }
    @Override
    public void execute(Job2dDriver driver) {
        listCommands.forEach(listCommands -> listCommands.execute(driver));
    }
}
