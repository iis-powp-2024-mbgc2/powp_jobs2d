package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.TestType;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final TestType testType;

	public SelectTestFigureOptionListener(DriverManager driverManager, TestType testType) {
		this.driverManager = driverManager;
		this.testType = testType;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (testType) {
			case FIGURE_SCRIPT_1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case FIGURE_SCRIPT_2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			default:
				throw new IllegalArgumentException("Unknown test type: " + testType);
		}

	}
}
