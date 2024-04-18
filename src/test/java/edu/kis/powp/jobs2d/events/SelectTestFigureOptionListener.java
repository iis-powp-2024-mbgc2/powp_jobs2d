package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.ComplexCommand;
import edu.kis.powp.jobs2d.command.ShapeFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.AbstractDriverAdapter;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestFigureOptionListener implements ActionListener {

	public static final String FIGURE_JOE_1 = "FiguresJoe1";
	public static final String FIGURE_JOE_2 = "FiguresJoe2";
	public static final String FIGURES_JANE_1 = "FiguresJane1";
	public static final String RECTANGLE = "Rectangle";

	public static final String TRIANGLE = "Triangle";


	private final DriverManager driverManager;
	private final String figuresName;

	public SelectTestFigureOptionListener(DriverManager driverManager , String figuresName) {
		this.driverManager = driverManager;
		this.figuresName = figuresName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (figuresName) {
			case FIGURE_JOE_1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case FIGURE_JOE_2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;

			case FIGURES_JANE_1:

				FiguresJane.figureScript( new AbstractDriverAdapter(driverManager) );

				break;
			case RECTANGLE:
				ComplexCommand commandRectangle = ShapeFactory.createRectangle(driverManager.getCurrentDriver(),-100,-100 ,200,100);
				commandRectangle.execute();

			case TRIANGLE:
				ComplexCommand commandTriangle = ShapeFactory.createTriangle(driverManager.getCurrentDriver(),-100,-100 ,200);
				commandTriangle.execute();
				break;
			default:
				throw new IllegalArgumentException("Unknown figure name: " + figuresName);
		}

	}
}
