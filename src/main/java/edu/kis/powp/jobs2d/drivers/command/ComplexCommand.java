package edu.kis.powp.jobs2d.drivers.command;


import java.util.ArrayList;
import java.util.List;
public class ComplexCommand implements DriverCommand {
    private List<DriverCommand> commands = new ArrayList<>();

    ComplexCommand(){
    }

    public void addCommand(DriverCommand command){
        this.commands.add(command);
    }


    @Override
    public void execute(){
        for (DriverCommand command : this.commands){
            command.execute();
        }
    }
}
