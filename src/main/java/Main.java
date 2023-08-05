import converter.InsertsGenerator;
import reader.FileReader;
import writer.FileWriter;

import java.io.IOException;

import static converter.InsertsGenerator.generateInserts;
import static reader.FileReader.readExcel;
import static writer.FileWriter.writeListToFile;

public class Main {

    public static void main(String[] args) throws IOException {
       writeListToFile(generateInserts(readExcel()));
    }
}
