package edu.kis.powp.command;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand {
    private final List<DriverCommand> commands = new ArrayList<>();

    public void addCommand(DriverCommand command) {
        commands.add(command);
    }

    public void clearCommands() {
        commands.clear();
    }

    @Override
    public void execute() {
        commands.forEach(DriverCommand::execute);
    }

}
