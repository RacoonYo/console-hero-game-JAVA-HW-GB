import java.io.IOException;
import java.util.logging.*;

public class LoggerCalc {
    Logger logger = Logger.getLogger(InPut.class.getName());
    public LoggerCalc(){

        Handler handler = null;
        try {
            handler = new FileHandler("log.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.addHandler(handler);
        XMLFormatter xml = new XMLFormatter();
        handler.setFormatter(xml);
    }

    public Logger getLogger() {
        return logger;
    }
}
