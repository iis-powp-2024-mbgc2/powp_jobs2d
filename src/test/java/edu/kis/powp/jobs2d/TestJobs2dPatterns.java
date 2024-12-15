package edu.kis.powp.jobs2d;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.drivers.adapter.BasicLineDrawerAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.events.SelectTestFigureJaneOptionListener;
import edu.kis.powp.jobs2d.events.SelectTestFigureJoe1OptionListener;
import edu.kis.powp.jobs2d.events.SelectTestFigureJoe2OptionListener;
import edu.kis.powp.jobs2d.events.SelectTestFigureRectangleOptionListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.features.LineFeature;

public class TestJobs2dPatterns {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupPresetTests(Application application) {
		SelectTestFigureJoe1OptionListener selectTestFigureJoe1OptionListener = new SelectTestFigureJoe1OptionListener(
				DriverFeature.getDriverManager());
		SelectTestFigureJoe2OptionListener selectTestFigureJoe2OptionListener = new SelectTestFigureJoe2OptionListener(
				DriverFeature.getDriverManager());
		SelectTestFigureJaneOptionListener selectTestFigureJaneOptionListener = new SelectTestFigureJaneOptionListener(
				DriverFeature.getDriverManager());

		SelectTestFigureRectangleOptionListener selectTestFigureRectangleOptionListener = new SelectTestFigureRectangleOptionListener(
				DriverFeature.getDriverManager()
		);

		application.addTest("Figure Joe 1", selectTestFigureJoe1OptionListener);
		application.addTest("Figure Joe 2", selectTestFigureJoe2OptionListener);
		application.addTest("Figure Jane", selectTestFigureJaneOptionListener);
		application.addTest("Figure Rectangle", selectTestFigureRectangleOptionListener);
	}

	/**
	 * Setup driver manager, and set default driver for application.
	 * 
	 * @param application Application context.
	 */
	private static void setupDrivers(Application application) {
		Job2dDriver loggerDriver = new LoggerDriver();
		DriverFeature.addDriver("Logger Driver", loggerDriver);
		DriverFeature.getDriverManager().setCurrentDriver(loggerDriver);

        Job2dDriver basicLineDriver = new BasicLineDrawerAdapter();
        DriverFeature.addDriver("Basic Line Driver", basicLineDriver);

		Job2dDriver lineDriver = new LineDrawerAdapter();
		DriverFeature.addDriver("Line Drawer", lineDriver);

		DriverFeature.updateDriverInfo();
	}

	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param application Application context.
	 */
	private static void setupLogger(Application application) {
		application.addComponentMenu(Logger.class, "Logger", 0);
		application.addComponentMenuElement(Logger.class, "Clear log",
				(ActionEvent e) -> application.flushLoggerOutput());
		application.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> logger.setLevel(Level.FINE));
		application.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> logger.setLevel(Level.INFO));
		application.addComponentMenuElement(Logger.class, "Warning level",
				(ActionEvent e) -> logger.setLevel(Level.WARNING));
		application.addComponentMenuElement(Logger.class, "Severe level",
				(ActionEvent e) -> logger.setLevel(Level.SEVERE));
		application.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> logger.setLevel(Level.OFF));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Application app = new Application("2d jobs Visio");
				DrawerFeature.setupDrawerPlugin(app);

				DriverFeature.setupDriverPlugin(app);
				setupDrivers(app);
				setupPresetTests(app);
				setupLogger(app);
				LineFeature.setupAdvancedLinePlugin(app);

				app.setVisibility(true);
			}
		});
	}

}
