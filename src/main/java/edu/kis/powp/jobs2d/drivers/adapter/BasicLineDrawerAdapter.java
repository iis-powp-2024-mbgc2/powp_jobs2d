package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

/**
 * Driver that draws basic line in application build-in panel.
 */
public class BasicLineDrawerAdapter implements Job2dDriver {
	private int startX = 0, startY = 0;

	public BasicLineDrawerAdapter() {
		super();
	}

	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	@Override
	public void operateTo(int x, int y) {
		ILine line = LineFactory.getBasicLine();
		line.setStartCoordinates(this.startX, this.startY);
		line.setEndCoordinates(x, y);
		this.setPosition(x, y);

		DrawerFeature.getDrawerController().drawLine(line);
	}

	@Override
	public String toString() {
		return "Intern driver";
	}
}
