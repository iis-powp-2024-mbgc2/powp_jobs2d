package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.Shapes;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {
    private DriverManager driverManager;
    private TestFigure selectedTestFigure;

    public SelectTestFigureOptionListener(DriverManager driverManager, TestFigure selectedTestFigure) {
        this.driverManager = driverManager;
        this.selectedTestFigure = selectedTestFigure;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (selectedTestFigure) {
            case FIGURE_JOE_1:
                FiguresJoe.figureScript1(driverManager.getCurrentDriver());
                break;
            case FIGURE_JOE_2:
                FiguresJoe.figureScript2(driverManager.getCurrentDriver());
                break;
            case RECTANGLE:
                Shapes.rectangle(driverManager.getCurrentDriver(), 0, 0, 200, 100).execute();
                break;
            case CIRCLE:
                Shapes.circle(driverManager.getCurrentDriver(), 0, 0, 100, 500).execute();
                break;
        }
    }
}
