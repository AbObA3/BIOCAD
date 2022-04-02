import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class Run {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String path = new File("").getAbsolutePath() + "\\src\\main\\resources\\example.json";
        Data data = objectMapper.readValue(new File(path), Data.class);
        System.out.println(data);
    }
}
