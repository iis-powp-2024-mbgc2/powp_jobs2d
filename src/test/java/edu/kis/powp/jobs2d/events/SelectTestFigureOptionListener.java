package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.ComplexCommandFactory;
import edu.kis.powp.jobs2d.drivers.DriverCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

    private DriverManager driverManager;
    private int testNo;

    public SelectTestFigureOptionListener(DriverManager driverManager, int testNo) {
        this.driverManager = driverManager;
        this.testNo = testNo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DriverCommand command;
        switch (testNo) {
            case (1):
                FiguresJoe.figureScript1(driverManager.getCurrentDriver());
                break;
            case (2):
                FiguresJoe.figureScript2(driverManager.getCurrentDriver());
                break;
            case (3):
                command = ComplexCommandFactory.createSquare(driverManager.getCurrentDriver(), -100, -100, 50);
                command.execute();
                break;
            case (4):
                command = ComplexCommandFactory.createRectangle(driverManager.getCurrentDriver(), -100, -100, 50, 80);
                command.execute();
                break;
            case (5):
                command = ComplexCommandFactory.createTriangle(driverManager.getCurrentDriver(), -100, -100, 100);
                command.execute();
                break;
        }
    }
}
