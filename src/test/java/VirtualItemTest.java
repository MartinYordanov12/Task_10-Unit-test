import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import shop.VirtualItem;

public class VirtualItemTest {
    private static VirtualItem virtualItemTest;

    @BeforeAll
    public static void VirtualItem() {
        virtualItemTest = new VirtualItem();
    }

    @Test
    public void createVirtualItemTest() {
        String expectedResult = String
                .format("Class: %s; Name: %s; Price: %s; Size on disk: %s",
                        virtualItemTest.getClass(),
                        "Android",
                        1200d,
                        2000d
                );
        virtualItemTest.setName("Android");
        virtualItemTest.setPrice(1200d);
        virtualItemTest.setSizeOnDisk(2000d);

        String actualResult = virtualItemTest.toString();

        Assertions.assertEquals(expectedResult, actualResult);

        System.out.printf("Expected result = %s \n", expectedResult);
        System.out.printf("Actual result = %s", actualResult);
    }
}
