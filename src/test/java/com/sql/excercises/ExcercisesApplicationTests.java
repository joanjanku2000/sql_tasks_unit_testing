package com.sql.excercises;

import org.apache.commons.io.FileUtils;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
class ExcercisesApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Logger logger = LoggerFactory.getLogger(ExcercisesApplicationTests.class);

    @Test
    void testSQL_4() throws IOException {
        String queries = FileUtils.readFileToString(new File("./src/test/resources/_4query.sql"), Charset.defaultCharset());
        logger.info("Queries {}", queries);
        String[] qs = queries.split(";");
        List<Object> expected_r1 = Arrays.asList(new Object[]{"Ashely(P)", "Christeen(P)", "Jane(P)", "Jenny(D)", "Julia(A)", "Ketty(P)", "Maria(A)", "Meera(S)", "Priya(S)", "Samantha(D)"});
        List<Object> expected_r2 = Arrays.asList(new Object[]{"There are a total of 2 actors.", "There are a total of 2 doctors.", "There are a total of 2 singers.", "There are a total of 4 professors."});

        List<Object> r1 = jdbcTemplate.queryForList(qs[0]).stream().map(Map::values).flatMap(Collection::stream).collect(Collectors.toList());
        List<Object> r2 = jdbcTemplate.queryForList(qs[1]).stream().map(Map::values).flatMap(Collection::stream).collect(Collectors.toList());


        logger.info("Result {} == {} ", r1, expected_r1);
        logger.info("Result {} == {}", r2, expected_r2);

        assertEquals(r1, expected_r1);
        assertEquals(r2, expected_r2);
    }

	@Test
	void testSQL_5() throws IOException {
		String queries = FileUtils.readFileToString(new File("./src/test/resources/_5query.sql"), Charset.defaultCharset());
		logger.info("Query {}", queries);
		String excpectedResult = "C1 Monika 1 2 1 2\nC2 Samantha 1 1 2 2";
		String result = jdbcTemplate.queryForList(queries, String.class).stream().collect(Collectors.joining("\n"));
		logger.info("Result {}", result);
		assertEquals(result,excpectedResult);
	}

    @Test
    void testSQL_6() throws IOException {
        String queries = FileUtils.readFileToString(new File("./src/test/resources/_6query.sql"), Charset.defaultCharset());
        logger.info("Query {}", queries);
        String excpectedResult = "2061.0";
        assertSimpleResult(queries, excpectedResult);
    }

	@Test
	void testSQL_7() throws IOException {
		String queries = FileUtils.readFileToString(new File("./src/test/resources/_7query.sql"), Charset.defaultCharset());
		logger.info("Query {}", queries);
		String excpectedResult = "69952 1";
		assertSimpleResult(queries, excpectedResult);
	}

    private void assertSimpleResult(String query, String expected) {
        String result = jdbcTemplate.queryForObject(query, String.class);
        logger.info("Result {}", result);
        assertEquals(expected, result);
    }

}
