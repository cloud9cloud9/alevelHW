package ua.nalezhytyi.hw20.task1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Reader {
    public <T> T readFromJsonFile(String filePath, Class<T> valueType) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), valueType);
    }
}
