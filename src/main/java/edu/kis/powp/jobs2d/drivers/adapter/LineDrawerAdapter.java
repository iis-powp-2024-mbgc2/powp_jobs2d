package edu.kis.powp.jobs2d.drivers.adapter;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;


public class LineDrawerAdapter implements Job2dDriver {

    private final ILine line;

    private int startX = 0, startY = 0;

    private final DrawPanelController drawerController;

    public LineDrawerAdapter(ILine line) {
        this.line = line;
        this.drawerController = DrawerFeature.getDrawerController();
    }


    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        setPosition(x, y);

        drawerController.drawLine(line);
    }

    @Override
    public String toString(){
        return "Special line";
    }
}
