package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.adapter.Factories;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	public SelectTestFigureOptionListener(DriverManager driverManager, int figure)
	{
		this.driverManager = driverManager;
		this.figure = figure;
	}

		private DriverManager driverManager;
		private int figure;

		private final int DEFAULT_UNIT = 60;

		public final static int FIGURE_JOE_1 = 1;
		public final static int FIGURE_JOE_2 = 2;
		public final static int SQUARE = 3;
		public final static int TRIANGLE = 4;
		public final static int CIRCLE = 5;
		private final int START_X = 0;
		private final int START_Y = 0;



	@Override
	public void actionPerformed(ActionEvent e) {


		if(figure == FIGURE_JOE_1)
		{
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		}
		if(figure == FIGURE_JOE_2)
		{
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		}
		if(figure == SQUARE)
		{
			Factories factory = new Factories();
			ComplexCommand command = factory.SquareFactory(driverManager.getCurrentDriver(), START_X, START_Y, DEFAULT_UNIT);
			command.execute();
		}

	}
}
