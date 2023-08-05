package writer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileWriter {

    public static void writeListToFile(List<String> list) throws IOException {
        writeListToFile(list, new File("src/main/resources/inserts.sql"));
    }

    private static void writeListToFile(List<String> list, File file) throws IOException {
        try (java.io.FileWriter fileWriter = new java.io.FileWriter(file)) {
            list.forEach(s -> {
                try {
                    fileWriter.write(s);
                    fileWriter.write("\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
