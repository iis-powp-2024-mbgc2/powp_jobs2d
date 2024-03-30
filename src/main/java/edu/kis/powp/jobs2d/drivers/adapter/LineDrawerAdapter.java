package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class LineDrawerAdapter extends DrawPanelController implements Job2dDriver {
    private int startX = 0, startY = 0;
    private final int lineType;

    public LineDrawerAdapter(int type) {
        super();
        this.lineType = type;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int opX, int opY) {
        ILine line = LineFactory.getBasicLine();

        switch(lineType){
            case(1):
                line = LineFactory.getSpecialLine();
                break;
            case(2):
                line = LineFactory.getDottedLine();
        }

        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(opX, opY);

        DrawerFeature.getDrawerController().drawLine(line);
        this.setPosition(opX, opY);
    }

    @Override
    public String toString() {
        return "@Q!$!@$!#@$(*#@&Q(%^*#@";
    }
}