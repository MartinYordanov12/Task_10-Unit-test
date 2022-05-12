import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import shop.RealItem;

public class RealItemTest {
    private static RealItem realItemTest;

    @BeforeAll
    public static void createRealItemInstance() {
        realItemTest = new RealItem();
    }

    @Test
    public void createRealItemTest() {
        String expectedResults = String
                .format("Class: %s; Name: %s; Price: %s; Weight: %s",
                        realItemTest.getClass(),
                        "Garrett",
                        12000d,
                        1580d
                );
        realItemTest.setName("Garrett");
        realItemTest.setPrice(12000);
        realItemTest.setWeight(1580);

        String actualResult = realItemTest.toString();

        Assertions.assertEquals(expectedResults, actualResult);

        System.out.printf("Expected result = %s \n", expectedResults);
        System.out.printf("Actual result = %s", expectedResults);
    }
}
