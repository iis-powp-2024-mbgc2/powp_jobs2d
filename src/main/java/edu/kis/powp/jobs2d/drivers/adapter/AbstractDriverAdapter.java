package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;

public class AbstractDriverAdapter extends AbstractDriver {

    private final DriverManager driverManager;
    public AbstractDriverAdapter(DriverManager driverManager) {
        super(0, 0);
        this.driverManager = driverManager;
    }

    @Override
    public void operateTo(int x, int y) {
        Job2dDriver currentDriver = driverManager.getCurrentDriver();
        currentDriver.setPosition(getX(), getY());
        currentDriver.operateTo(x, y);
        setPosition(x, y);
    }
}
