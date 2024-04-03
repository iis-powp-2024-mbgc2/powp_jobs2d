package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.FiguresFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {
	private final DriverManager driverManager;
	private final int figureTestNumber;
	public static final int FIGURE_1 = 1;
	public static final int FIGURE_2 = 2;
	public static final int FIGURE_3 = 3;
	public static final int FIGURE_4 = 4;
	public static final int FIGURE_5 = 5;

	public SelectTestFigureOptionListener(DriverManager driverManager, int figureTestNumber) {
		this.driverManager = driverManager;
		this.figureTestNumber = figureTestNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ComplexCommand commands;
		switch (figureTestNumber) {
			case FIGURE_1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case FIGURE_2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case FIGURE_3:
			 	commands = FiguresFactory.buildFigure1(driverManager.getCurrentDriver());
				commands.execute();
				break;
			case FIGURE_4:
				commands = FiguresFactory.buildFigure2(driverManager.getCurrentDriver());
				commands.execute();
				break;
			case FIGURE_5:
				commands = FiguresFactory.buildFigure3(driverManager.getCurrentDriver());
				commands.execute();
				break;
			default:
				System.out.println("Figure with that number doesn't exist");
		}
	}
}
