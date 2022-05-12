import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import parser.JsonParser;
import parser.NoSuchFileException;


import java.io.File;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JsonParserTest {
    private static JsonParser jsonParser;
    private static Gson gson;
    private static ClassLoader classLoader;
    private static Faker faker;

    @BeforeAll
    public static void initiateJsonParserObject() {
        jsonParser = new JsonParser();
        gson = new Gson();
        classLoader = JsonParserTest.class.getClassLoader();
        faker = new Faker();
    }

    @Nested
    class ExceptionTests {
        @ParameterizedTest
        @ValueSource(strings = {
                "src/main/resources/File.file",
                "src/main/resources/File",
                "",
                "src/main/resources/eugen-cart.JPEG",
                "src/main/resources/andrew-cart.JPEG",
                "src/main/resources/eugen-cart",
                "src/main/resources/andrew-cart"
        })
        public void noSuchFileExceptionTest(String input) {
            assertThrows(NoSuchFileException.class, () -> {
                jsonParser.readFromFile(new File(String.valueOf(input)));
            });
        }

        @Disabled("No such exception test disabled")
        @Test
        public void noSuchFileExceptionTestDisable() {
            File input = new File("src/main/resources/disable-cart.xml");
            assertThrows(NoSuchFileException.class, () -> {
                jsonParser.readFromFile(input);
            });
        }
    }
}
