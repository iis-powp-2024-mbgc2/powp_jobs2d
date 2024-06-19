package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.command.ComplexCommandFactory;
import edu.kis.powp.jobs2d.drivers.command.DriverCommand;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

    private DriverManager driverManager;
    private final int testNumber;

    public SelectTestFigureOptionListener(DriverManager driverManager, int testNumber) {
        this.driverManager = driverManager;
        this.testNumber = testNumber;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (testNumber == 1) {
            FiguresJoe.figureScript1(driverManager.getCurrentDriver());
        }
        if (testNumber == 2) {
            FiguresJoe.figureScript2(driverManager.getCurrentDriver());
        }
        if (testNumber == 3) {
            DriverCommand command = ComplexCommandFactory.createSquare(-100, -100, 50, driverManager.getCurrentDriver());
            command.execute();
        }
        if (testNumber == 4) {
            DriverCommand command = ComplexCommandFactory.createRectangle(-100, -100, 50, 80, driverManager.getCurrentDriver());
            command.execute();
        }
        if (testNumber == 5) {
            DriverCommand command = ComplexCommandFactory.createTriangle(-100, -100, -200, -100, 50, -200, driverManager.getCurrentDriver());
            command.execute();
        }
    }
}
