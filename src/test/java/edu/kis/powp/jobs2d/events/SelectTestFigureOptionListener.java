package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final int figureTestNumber;

	public SelectTestFigureOptionListener(DriverManager driverManager, int figureTestNumber) {
		this.driverManager = driverManager;
		this.figureTestNumber = figureTestNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (figureTestNumber == 1) {
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		} else if (figureTestNumber == 2) {
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		} else {
			System.out.println("Figure with that number doesn't exist");
		}
	}
}
