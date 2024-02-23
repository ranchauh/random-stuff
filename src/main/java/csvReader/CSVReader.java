package lld2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class CSVReader implements Reader {

    private File file;
    private FileInputStream fileInputStream;

    public CSVReader(File file) throws FileNotFoundException {
        this.file = file;
        fileInputStream  = new FileInputStream(file);
    }

    @Override
    public Record read() throws IOException {
        byte[] bytes = new byte[1024];
        int numOfBytes = fileInputStream.read(bytes);
        // create Record
        Record record = createRecord(bytes);
        return record;
    }

    private Record createRecord(byte[] bytes) {
        Record record = new Record();
        record.setLine(Arrays.toString(bytes));
        return  record;
    }
}
