package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import static edu.kis.powp.jobs2d.features.DrawerFeature.getDrawerController;

/**
 * driver adapter to drawer with several bugs.
 */
public class BaseDriverDrawerAdapter implements Job2dDriver {
	private int startX = 0, startY = 0;

	public BaseDriverDrawerAdapter() {
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

		getDrawerController().drawLine(line);
		setPosition(x,y);
	}

	@Override
	public String toString() {
		return "@Q!$!@$!#@$(*#@&Q(%^*#@";
	}
}
