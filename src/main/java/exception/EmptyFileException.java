package exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmptyFileException extends Exception {

    private static final Logger LOGGER = LogManager.getLogger(EmptyFileException.class);

    public EmptyFileException(String message) {
        super(message);
        LOGGER.warn("Custom NoSuchFileException exceptions are working. EmptyFileException \n");
    }

    public EmptyFileException() {
        super();
        LOGGER.warn("Custom NoSuchFileException exceptions are working. EmptyFileException \n");
    }

    public EmptyFileException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.warn("Custom NoSuchFileException exceptions are working. EmptyFileException \n");
    }

    public EmptyFileException(Throwable cause) {
        super(cause);
        LOGGER.warn("Custom NoSuchFileException exceptions are working. EmptyFileException \n");
    }
    protected EmptyFileException(String message, Throwable cause,
                                  boolean enableSuppression,
                                  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        LOGGER.warn("Custom NoSuchFileException exceptions are working. EmptyFileException \n");
    }
}
