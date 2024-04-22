package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.Command.ComplexCommand;
import edu.kis.powp.jobs2d.Command.DriverCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final int selectedFigureNumber;
	public static final int FIGURE_1 = 1;
	public static final int FIGURE_2 = 2;
	public static final int FIGURE_RECT = 3;
	public static final int FIGURE_CIRCLE = 4;

	public SelectTestFigureOptionListener(DriverManager driverManager, int selectedFigureNumber) {
		this.driverManager = driverManager;
		this.selectedFigureNumber = selectedFigureNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DriverCommand commandOut;
		switch (selectedFigureNumber) {
			case FIGURE_1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case FIGURE_2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case FIGURE_RECT:
				commandOut = ComplexCommand.createRect(driverManager.getCurrentDriver(),0,0,200,100);
				commandOut.execute();
				break;
			case FIGURE_CIRCLE:
				commandOut = ComplexCommand.createKolo(driverManager.getCurrentDriver(),0,0,50);
				commandOut.execute();
				break;
			default:
				System.out.println("No existing figure");
				break;
		}
	}
}
