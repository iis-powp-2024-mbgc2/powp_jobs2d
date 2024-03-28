package edu.kis.powp.jobs2d.drivers.adapter;
import edu.kis.powp.jobs2d.Job2dDriver;
public class Factories
{
    public ComplexCommand SquareFactory(Job2dDriver driver, int x, int y, int distance)
    {
        ComplexCommand command = new ComplexCommand();

        command.addCommand(new SetPositionCommand(driver,x, y - distance / 2));
        command.addCommand(new OperateToCommand(driver,x - distance / 2, y - distance / 2));
        command.addCommand(new OperateToCommand(driver,x - distance / 2, y + distance / 2));
        command.addCommand(new OperateToCommand(driver,x + distance / 2, y + distance / 2));
        command.addCommand(new OperateToCommand(driver,x + distance / 2, y - distance / 2));
        command.addCommand(new OperateToCommand(driver,x, y - distance / 2));

        return command;
    }

    public ComplexCommand CircleFactory(Job2dDriver driver, int x, int y, int radius)
    {
        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand( driver,x - radius, y));

        for(int i = radius * (-1); i <= radius; i++)
        {
            command.addCommand(new OperateToCommand(driver, x + i, (int) (y + Math.sqrt(radius * radius - i * i))));
        }

        command.addCommand(new SetPositionCommand(driver, x - radius, y));

        for(int i = radius * (-1); i <= radius; i++)
        {
            command.addCommand(new OperateToCommand(driver, x + i, (int) (y - Math.sqrt(radius * radius - i * i))));
        }


        return command;
    }

}
