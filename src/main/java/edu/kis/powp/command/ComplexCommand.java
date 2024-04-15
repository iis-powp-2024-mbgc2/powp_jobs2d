package edu.kis.powp.command;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand{
    private List<DriverCommand> commandList;

    public ComplexCommand() {
        this.commandList = new ArrayList<>();
    }

    public void add(DriverCommand command) {
        commandList.add(command);
    }

    public void addList(List<DriverCommand> list) {
        commandList.addAll(list);
    }

    public DriverCommand remove(int index) {
        return commandList.remove(index);
    }

    public DriverCommand pop() {
        return commandList.remove(commandList.size() - 1);
    }

    @Override
    public void execute() {
        commandList.forEach(DriverCommand::execute);
    }
}
