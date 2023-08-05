package converter;

import java.util.*;

public class InsertsGenerator {

    private static final String INSERT = "INSERT INTO #TABLE_NAME(#ARGS) VALUES (#VALUES);";
    private static final String AUTHOR = "author";
    private static final String BOOK = "book";
    private static final String AUTHOR_BOOK = "author_book";
    private static final String TABLE_NAME = "#TABLE_NAME";
    private static final String ARGS = "#ARGS";
    private static final String VALUES = "#VALUES";
    private static final String AUTHOR_ARGS = "full_name";
    private static final String BOOK_ARGS = "title,n_pages,price,copies_sold,year";
    private static final String AUTHOR_BOOK_ARGS = "author_id,book_id";
    private static final String SINGLE_QUOTE = "'";
    private static final String COMMA = ",";
    private static final String COLUMN = "#COLUMN";
    private static final String VALUE = "#VALUE";
    private static final String SELECT_ID_QUERY = "SELECT id from " + TABLE_NAME + " where " + COLUMN + " = " + VALUE;


    public static List<String> generateInserts(Map<Integer, List<String>> rowsMap) {
        List<String> sqls = new ArrayList<>();
        sqls.addAll(generateAuthorsInserts(rowsMap));
        sqls.addAll(generateBooksInserts(rowsMap));
        return sqls;
    }

    private static List<String> generateAuthorsInserts(Map<Integer, List<String>> rowsMap) {
        List<String> result = new ArrayList<>();
        Set<String> authors = new HashSet<>();
        for (Map.Entry<Integer, List<String>> row : rowsMap.entrySet()) {
            if (row.getKey() != 0) {
                List<String> values = row.getValue();
                String[] aauthors = values.get(1) != null ? values.get(1).split("/") : new String[0];
                if (aauthors.length > 0) {
                    Collections.addAll(authors, aauthors);
                }
            }
        }
        for (String author : authors) {
            result.add(INSERT.replace(TABLE_NAME, AUTHOR).replace(ARGS, AUTHOR_ARGS).replace(VALUES, wrapString(author)));
        }
        return result;
    }

    private static List<String> generateBooksInserts(Map<Integer, List<String>> rowsMap) {
        List<String> result = new ArrayList<>();
        List<String> books = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> row : rowsMap.entrySet()) {
            if (row.getKey() != 0) {
                List<String> values = row.getValue();
                String bookTitle = values.get(0).replaceAll("'", "").replaceAll("\"", "");
                String numPages = values.get(3);
                String publicationYear = values.get(6);
                String price = values.get(7);
                String copiesSold = values.get(8);

                String valuesFormat = wrapString(bookTitle) + COMMA + numPages + COMMA + price + COMMA + copiesSold + COMMA + publicationYear;
                books.add(valuesFormat);
            }
        }
        for (String book : books) {
            result.add(INSERT.replace(TABLE_NAME, BOOK).replace(ARGS, BOOK_ARGS).replace(VALUES, book));
        }
        return result;
    }

    private static String wrapString(String v) {
        return SINGLE_QUOTE + v + SINGLE_QUOTE;
    }
}
