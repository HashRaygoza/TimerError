package mx.hashCode.TimerError;

import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger LOGGER = Logger.getLogger("mx.hashCode.TimerError.App");

    public static void main( String[] args )
    {
        LOGGER.log(Level.INFO, "Inicializamos el timer");
        Timer timer = new Timer();
        TimerSQL timerSQL = new TimerSQL();

        timer.schedule(timerSQL, 0, 1000*10);
    }
}
