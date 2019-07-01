package exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WrongParamsException extends Exception {

    private static final Logger LOGGER = LogManager.getLogger(WrongParamsException.class);

    public WrongParamsException(String message) {
        super(message);
        LOGGER.warn("Custom NoSuchFileException exceptions are working. WrongParamsException \n");
    }

    public WrongParamsException() {
        super();
        LOGGER.warn("Custom NoSuchFileException exceptions are working. WrongParamsException \n");
    }

    public WrongParamsException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.warn("Custom NoSuchFileException exceptions are working. WrongParamsException \n");
    }

    public WrongParamsException(Throwable cause) {
        super(cause);
        LOGGER.warn("Custom NoSuchFileException exceptions are working. WrongParamsException \n");
    }
    protected WrongParamsException(String message, Throwable cause,
                        boolean enableSuppression,
                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        LOGGER.warn("Custom NoSuchFileException exceptions are working. WrongParamsException \n");

    }
}
