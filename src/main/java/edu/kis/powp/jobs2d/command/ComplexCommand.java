package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComplexCommand implements DriverCommand {

	private List<DriverCommand> commands;

	public ComplexCommand() {
		this.commands = new ArrayList<>();
	}

	public void addCommands(DriverCommand ...commands) {
        Collections.addAll(this.commands, commands);
	}

	@Override
	public void execute(Job2dDriver driver) {
        this.commands.forEach(cmd -> cmd.execute(driver));
	}
}
