package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.TestType;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.command.ComplexCommandFactory;
import edu.kis.powp.jobs2d.drivers.command.DriverCommand;
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
            case SQUARE:
                DriverCommand squareCommand = ComplexCommandFactory.createSquare(-100, -100, 50, driverManager.getCurrentDriver());
                squareCommand.execute();
                break;
            case RECTANGLE:
                DriverCommand rectangleCommand = ComplexCommandFactory.createRectangle(-100, -100, 50, 80, driverManager.getCurrentDriver());
                rectangleCommand.execute();
                break;
            case TRIANGLE:
                DriverCommand triangleCommand = ComplexCommandFactory.createTriangle(-100, -100, -200, -100, 50, -200, driverManager.getCurrentDriver());
                triangleCommand.execute();
                break;
            default:
                throw new IllegalArgumentException("Unknown test type " + testType);
        }
    }
}