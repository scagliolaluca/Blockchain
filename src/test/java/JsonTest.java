import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonTest {

    @Test
    void test() {

        //given
        String input = "{\"name\": \"Alice\"}";

        //when
        String output = Sample.getNameFromJson(input);

        //then
        Assertions.assertEquals("Alice", output);
    }

    @Test
    void testNullInput() {

        //given
        String input = null;

        //then
        final NullPointerException ex = Assertions.assertThrows(NullPointerException.class,
                () -> Sample.getNameFromJson(input));
        Assertions.assertEquals("input must not be null", ex.getMessage());
    }

    @Test
    void testNoNameInput() {

        //given
        String input = "{\"anything\": \"Alice\"}";

        //then
        final IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class,
                () -> Sample.getNameFromJson(input));
        Assertions.assertEquals("input must have key \"name\"", ex.getMessage());
    }

    @Test
    void testBadInput() {

        //Not a Json file
    }


}
