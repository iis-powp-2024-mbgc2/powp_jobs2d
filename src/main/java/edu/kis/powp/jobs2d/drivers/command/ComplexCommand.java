package edu.kis.powp.jobs2d.drivers.command;

import java.util.ArrayList;

public class ComplexCommand implements DriverCommand{

    private ArrayList<DriverCommand> commands;

    public ComplexCommand()
    {
        this.commands = new ArrayList<DriverCommand>();
    }


    public void addCommand(DriverCommand com)
    {
        commands.add(com);
    }

    @Override
    public void execute() {
        for(DriverCommand com : commands)
        {
            com.execute();
        }
    }
}
