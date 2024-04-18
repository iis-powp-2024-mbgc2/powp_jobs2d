package edu.kis.powp.jobs2d;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.drivers.adapter.BasicDriverAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.events.SelectChangeVisibleOptionListener;
import edu.kis.powp.jobs2d.events.SelectTestFigureOptionListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestJobs2dPatterns {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupPresetTests(Application application) {

		SelectTestFigureOptionListener selectTestFigureOptionListenerJoe1 = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager() , SelectTestFigureOptionListener.FIGURES_JANE_1);

		application.addTest("Figure Joe 1", selectTestFigureOptionListenerJoe1);

        SelectTestFigureOptionListener selectTestFigureOptionListenerJoe2 = new SelectTestFigureOptionListener(
                DriverFeature.getDriverManager() , SelectTestFigureOptionListener.FIGURE_JOE_2);

        application.addTest("Figure Joe 2", selectTestFigureOptionListenerJoe2);

		SelectTestFigureOptionListener selectTestFigureOptionListenerJane = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager() , SelectTestFigureOptionListener.FIGURES_JANE_1);

        application.addTest("Figures Jane", selectTestFigureOptionListenerJane);

		SelectTestFigureOptionListener selectTestFigureOptionListenerRectangle = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager() , SelectTestFigureOptionListener.RECTANGLE);

		application.addTest("Rectangle", selectTestFigureOptionListenerRectangle );

		SelectTestFigureOptionListener selectTestFigureOptionListenerTriangle = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager() , SelectTestFigureOptionListener.TRIANGLE);

		application.addTest("Triangle", selectTestFigureOptionListenerTriangle );


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

		Job2dDriver testDriver = new BasicDriverAdapter (DrawerFeature.getDrawerController());
		DriverFeature.addDriver("Basic Line", testDriver);

		Job2dDriver testDriver2 = new LineDrawerAdapter( DrawerFeature.getDrawerController(), LineFactory.getSpecialLine());
		DriverFeature.addDriver("Special Line", testDriver2);

		Job2dDriver testDriver3 = new LineDrawerAdapter( DrawerFeature.getDrawerController(), LineFactory.getDottedLine());
		DriverFeature.addDriver("Dot Line", testDriver3);

		DriverFeature.updateDriverInfo();
	}

	/**
	 * Auxiliary routines to enable using Buggy Simulator.
	 * 
	 * @param application Application context.
	 */
	private static void setupDefaultDrawerVisibilityManagement(Application application) {
		DefaultDrawerFrame defaultDrawerWindow = DefaultDrawerFrame.getDefaultDrawerFrame();
		application.addComponentMenuElementWithCheckBox(DrawPanelController.class, "Default Drawer Visibility",
				new SelectChangeVisibleOptionListener(defaultDrawerWindow), true);
		defaultDrawerWindow.setVisible(false);
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
				setupDefaultDrawerVisibilityManagement(app);

				DriverFeature.setupDriverPlugin(app);
				setupDrivers(app);
				setupPresetTests(app);
				setupLogger(app);

				app.setVisibility(true);
			}
		});
	}

}
