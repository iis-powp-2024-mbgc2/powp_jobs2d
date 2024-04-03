package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

import edu.kis.powp.command.TestCommand;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private Consumer<Job2dDriver> consumerDelegation;

	public SelectTestFigureOptionListener(DriverManager driverManager, Consumer<Job2dDriver> driverDelegation) {
		this.driverManager = driverManager;
		this.consumerDelegation = driverDelegation;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		consumerDelegation.accept(driverManager.getCurrentDriver());
	}
}
