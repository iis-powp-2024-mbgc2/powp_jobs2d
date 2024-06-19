package edu.kis.powp.jobs2d.drivers.command;

import java.util.ArrayList;
import java.util.List;


public class ComplexCommand implements DriverCommand {
    private final List<DriverCommand> commandList;

    public ComplexCommand() {
        this.commandList = new ArrayList<>();
    }

    @Override
    public void execute() {
        commandList.forEach(DriverCommand::execute);
    }

    public void addCommand(DriverCommand command) {
        commandList.add(command);
    }


}
