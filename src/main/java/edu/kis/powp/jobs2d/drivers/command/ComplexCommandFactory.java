package edu.kis.powp.jobs2d.drivers.command;

public interface ComplexCommandFactory {
    DriverCommand createCommand(int x, int y, int width, int height);
}
