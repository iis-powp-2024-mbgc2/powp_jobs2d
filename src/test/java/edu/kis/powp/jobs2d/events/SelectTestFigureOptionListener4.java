package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.command.*;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestFigureOptionListener4 implements ActionListener {
    private DriverManager driverManager;

    public SelectTestFigureOptionListener4(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ComplexCommandFactory complexCommand = new TriangleCommandFactory(driverManager.getCurrentDriver());
        DriverCommand command = complexCommand.createCommand(0, 0, 50, 50);
        command.execute();
    }
}
