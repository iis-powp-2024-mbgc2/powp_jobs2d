package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.command.CommandFactory;
import edu.kis.powp.jobs2d.drivers.command.ComplexCommand;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private static final int firstFigure = 1;
	private static final int secondFigure = 2;
	private static final int Square = 3;
	private static final int Rectangle = 4;
	private DriverManager driverManager;
	private int figure_number;



	public SelectTestFigureOptionListener(DriverManager driverManager, int number_figure) {
		this.driverManager = driverManager;
		this.figure_number = number_figure;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.figure_number == firstFigure)
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		else if(this.figure_number == secondFigure)
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		else if(this.figure_number == Square)
			CommandFactory.createSquare(driverManager.getCurrentDriver(), 0, 100, 100).execute();
		else if(this.figure_number == Rectangle)
			CommandFactory.createRectangle(driverManager.getCurrentDriver(), 10, 10, 100, 200).execute();
		else
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());

	}
}
