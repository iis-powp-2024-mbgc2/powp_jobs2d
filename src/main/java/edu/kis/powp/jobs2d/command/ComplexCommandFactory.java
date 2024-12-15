package edu.kis.powp.jobs2d.command;

public class ComplexCommandFactory {

	public static ComplexCommand rectangle() {

		ComplexCommand command = new ComplexCommand();
		command.addCommands(
				new SetPositionCommand(60, 60),
				new OperateToCommand(60, -60),
				new OperateToCommand(-60, -60),
				new OperateToCommand(-60, 60),
				new OperateToCommand(60, 60)
		);
		return command;
	}
}
