package reader;

import exception.EmptyFileException;
import exception.NoSuchFileException;
import validator.FileValidator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static DataReader ourInstance = new DataReader();

    public static DataReader getInstance() {
        return ourInstance;
    }

    private DataReader() {
    }

    //public static final String fileName = "TEST.TXT";

    public List<String> readFromFile(String path) throws NoSuchFileException, EmptyFileException, IOException {
        FileValidator validator = FileValidator.getInstance();
        if (!validator.isExist(path)) {
            throw new NoSuchFileException("There is no such file");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            if (isEmpty(path)) {
                throw new EmptyFileException("The file is empty");
            }

            List<String> lines = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            return lines;
        }
    }

    private boolean isEmpty(String path) {

        File file = new File(path);

        if (file.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
