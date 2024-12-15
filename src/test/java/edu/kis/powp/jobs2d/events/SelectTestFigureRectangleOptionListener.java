package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.ComplexCommand;
import edu.kis.powp.jobs2d.command.ComplexCommandFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestFigureRectangleOptionListener implements ActionListener {

	private DriverManager driverManager;
	private ComplexCommand rectangle = ComplexCommandFactory.rectangle();

	public SelectTestFigureRectangleOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.rectangle.execute(driverManager.getCurrentDriver());
	}
}
