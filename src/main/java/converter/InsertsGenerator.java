package converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InsertsGenerator {

    private static final String SINGLE_QUOTE = "'";

    public static List<String> generateInserts(Map<Integer, List<String>> rowsMap) {
        List<String> sqls = new ArrayList<>();
        sqls.addAll(generateAuthorsInserts(rowsMap));
        sqls.addAll(generateBooksInserts(rowsMap));
        sqls.addAll(generateAuthorBookInserts(rowsMap));
        return sqls;
    }

    private static List<String> generateAuthorsInserts(Map<Integer, List<String>> rowsMap) {
        List<String> result = new ArrayList<>();
        // TODO INSERT CODE HERE
        // GJENRIMI I INSERTEVE PER AUTORE (Mos harroni 1 liber mund te kete me shume
        // sesa 1 autor, ndahen ne excel me simbolin /
        // Kujdes, strings do jene wrapped with  ' ' , dhe sigurohuni qe t'ia hiqni
        // nje stringu ' nqs do kete se mund te sjelle errore ne sql e gjeneruar ( Str.replaceAll(,))
        return result;
    }

    private static List<String> generateBooksInserts(Map<Integer, List<String>> rowsMap) {
        List<String> result = new ArrayList<>();
        // TODO INSERT CODE HERE
        // GJENERIMI I INSERTEVE PER LIBRAT
        return result;
    }

    private static List<String> generateAuthorBookInserts(Map<Integer, List<String>> rowsMap) {
        List<String> result = new ArrayList<>();
        // TODO INSERT CODE HERE
        // HINT: Ketu ju duhen ID-te e autoreve dhe librave, qe nuk i keni drejtperdrejt
        // Si do t'i gjeni ? Me mire spo ju jap hint, try it yourself :P,
        // po hases sh veshtiresi feel free to ask
        return result;

    }

    private static String wrapString(String v) {
        return SINGLE_QUOTE + v + SINGLE_QUOTE;
    }

    private static String wrap(String v) {
        return "(" + v + ")";
    }
}
