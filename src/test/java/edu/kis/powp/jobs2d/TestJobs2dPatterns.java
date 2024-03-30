package edu.kis.powp.jobs2d;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.drivers.adapter.AdapterControls;
import edu.kis.powp.jobs2d.events.SelectChangeVisibleOptionListener;
import edu.kis.powp.jobs2d.events.SelectTestFigureOptionListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;

public class TestJobs2dPatterns {
    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Setup test concerning preset figures in context.
     *
     * @param application Application context.
     */
    private static void setupPresetTests(Application application) {
        SelectTestFigureOptionListener selectTestFigureOptionListener1 =
                new SelectTestFigureOptionListener(DriverFeature.getDriverManager(), 1);

        SelectTestFigureOptionListener selectTestFigureOptionListener2 =
                new SelectTestFigureOptionListener(DriverFeature.getDriverManager(), 2);

        SelectTestFigureOptionListener selectTestFigureOptionListener3 =
                new SelectTestFigureOptionListener(DriverFeature.getDriverManager(), 3);

        SelectTestFigureOptionListener selectTestFigureOptionListener4 =
                new SelectTestFigureOptionListener(DriverFeature.getDriverManager(), 4);

        SelectTestFigureOptionListener selectTestFigureOptionListener5 =
                new SelectTestFigureOptionListener(DriverFeature.getDriverManager(), 5);



        application.addTest("Figure Joe 1", selectTestFigureOptionListener1);
        application.addTest("Figure Joe 2", selectTestFigureOptionListener2);
        application.addTest("ComplexCommand square", selectTestFigureOptionListener3);
        application.addTest("ComplexCommand rectangle", selectTestFigureOptionListener4);
        application.addTest("ComplexCommand triangle", selectTestFigureOptionListener5);
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

        Job2dDriver testDriver = new AdapterControls();
        DriverFeature.addDriver("Buggy Simulator", testDriver);

        Job2dDriver basicLineDriver = new AdapterControls();
        DriverFeature.addDriver("Basic Line Driver", basicLineDriver);

        Job2dDriver specialLineDriver = new LineDrawerAdapter(1);
        DriverFeature.addDriver("Special Line Driver", specialLineDriver);

        Job2dDriver dottedLineDriver = new LineDrawerAdapter(2);
        DriverFeature.addDriver("Dotted Line Driver", dottedLineDriver);

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
        defaultDrawerWindow.setVisible(true);
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

                app.setVisibility(true);
            }
        });
    }

}
