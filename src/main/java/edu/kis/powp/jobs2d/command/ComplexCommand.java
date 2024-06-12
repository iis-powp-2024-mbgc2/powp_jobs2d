package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand{

    private List<DriverCommand> driverCommandList;

    public ComplexCommand() {
        driverCommandList = new ArrayList<>();
    }

    public void addDriverCommandList(DriverCommand driverCommand) {
        driverCommandList.add(driverCommand);
    }

    @Override
    public void execute() {
        for (DriverCommand command : driverCommandList) {
            command.execute();
        }
    }
}
