package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    public static Properties loadProperties() {
        FileInputStream instream;
        Properties props = new Properties();
        try {
            instream = new FileInputStream("src/main/resources/scythe.properties");
            props.load(instream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }
}
