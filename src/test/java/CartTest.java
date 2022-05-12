import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;


public class CartTest {
    private static final double TAX = 0.2;

    private static RealItem realItem;
    private static VirtualItem virtualItem;
    private static Faker faker;

    @BeforeAll
    public static void createRealAndVirtualItems() {
        realItem = new RealItem();
        realItem.setName("Garrett Turbo");
        realItem.setPrice(12000);
        realItem.setWeight(8.5);

        virtualItem = new VirtualItem();
        virtualItem.setName("iOS Safari");
        virtualItem.setPrice(1.5);
        virtualItem.setSizeOnDisk(130.5);

        faker = new Faker();
    }

    @Test
    void getTotalPriceTest() {
        Cart cart = new Cart(faker.name().firstName());
        double priceBeforeAdding = cart.getTotalPrice();
        cart.addRealItem(realItem);
        double itemTotalPriceCalc = realItem.getPrice() + realItem.getPrice() * TAX;
        double expectedPrice = priceBeforeAdding + itemTotalPriceCalc;
        double actualPrice = cart.getTotalPrice();

        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void getCartRealItemAndVirtualNameTest() {
        Cart cartRealItem = new Cart(realItem.getName());
        Cart cartVirtualItem = new Cart(virtualItem.getName());
        String actualRealItemName = cartRealItem.getCartName();
        String actualVirtualItemName = cartVirtualItem.getCartName();
        String expectedRealItemName = realItem.getName();
        String expectedVirtualItemName = virtualItem.getName();
        Assertions.assertAll(() -> {
            Assertions.assertEquals(actualRealItemName, expectedRealItemName);
            Assertions.assertEquals(actualVirtualItemName, expectedVirtualItemName);
            Assertions.assertFalse(actualRealItemName.contains(expectedVirtualItemName),
                    "expectedVirtualItemName is not contains in actualRealItemName");
        });
    }
}
