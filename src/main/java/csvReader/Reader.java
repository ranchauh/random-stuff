package csvReader;

import java.io.IOException;

public interface Reader {
    Record read() throws IOException;
}
