import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ColumnsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() throws IOException {
        System.in.close();
    }

    @Test
    void testIt1() throws IOException {

        InputStream backup1 = System.in;

        System.setIn(new ByteArrayInputStream("src/main/resources/Input.txt"
                .getBytes(StandardCharsets.UTF_8)));
        JavaConf2020.main(new String[]{"arg1", "arg2", "arg3"});
        System.setIn(backup1);

        assertEquals(JavaConf2020.printChecker, JavaConf2020.schedule.toString(),
                "The information in the schedule is not printing correctly");

    }
}