package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.command.CommandFactory;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private static final int FIRST_FIGURE = 1;
	private static final int SECOND_FIGURE = 2;
	private static final int SQUARE = 3;
	private static final int RECTANGLE = 4;
	private DriverManager driverManager;
	private int figure_number;



	public SelectTestFigureOptionListener(DriverManager driverManager, int number_figure) {
		this.driverManager = driverManager;
		this.figure_number = number_figure;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.figure_number == FIRST_FIGURE)
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		else if(this.figure_number == SECOND_FIGURE)
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		else if(this.figure_number == SQUARE)
			CommandFactory.createSquare(driverManager.getCurrentDriver(), 0, 100, 100).execute();
		else if(this.figure_number == RECTANGLE)
			CommandFactory.createRectangle(driverManager.getCurrentDriver(), 10, 10, 100, 200).execute();
		else
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());

	}
}
