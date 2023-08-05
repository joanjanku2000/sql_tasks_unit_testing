package reader;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static java.lang.String.valueOf;
import static java.util.Objects.requireNonNull;

public class FileReader {

    public static Map<Integer, List<String>> readExcel() throws IOException {
        FileInputStream inputStream = new FileInputStream("src/main/resources/books.xlsx");
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        return extractMapFromSheet(sheet);
    }

    private static Map<Integer, List<String>> extractMapFromSheet(Sheet sheet) {
        Map<Integer, List<String>> data = new HashMap<>();
        int i = 0;
        for (Row row : sheet) {
            if (i == 100) break;
            data.put(i, new ArrayList<>());
            for (Cell cell : row) {
                if (requireNonNull(cell.getCellType()) == CellType.NUMERIC) {
                    data.get(i).add(valueOf(cell.getNumericCellValue()));
                    continue;
                }
                data.get(i).add(cell.getStringCellValue());
            }
            i++;
        }
        return data;
    }
}
