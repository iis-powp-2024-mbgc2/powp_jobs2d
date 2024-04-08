package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.command.CommandFactory;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;

	private actions commandNumber;

	public SelectTestFigureOptionListener(DriverManager driverManager, actions commandNumber) {
		this.driverManager = driverManager;
		this.commandNumber = commandNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (commandNumber){
			case figure1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case figure2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case square:
				DriverCommand command = CommandFactory.makeSquare(driverManager.getCurrentDriver(), -50, -50, 200);
				command.execute();
				break;
			case triangle:
				CommandFactory.makeTriangle(driverManager.getCurrentDriver(),
						-50, -50, 100, 69, 40, 50).execute();
				break;
		}
	}
}
