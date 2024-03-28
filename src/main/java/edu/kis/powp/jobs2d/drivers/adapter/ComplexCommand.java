package edu.kis.powp.jobs2d.drivers.adapter;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand
{
    private final List <DriverCommand> commands = new ArrayList<>();

    ComplexCommand() {}

    public void addCommand(DriverCommand command)
    {
        commands.add(command);
    }

    @Override
    public void execute()
    {
        for(int i = 0; i < commands.size(); i++)
        {
            commands.get(i).execute();
        }
    }
}
