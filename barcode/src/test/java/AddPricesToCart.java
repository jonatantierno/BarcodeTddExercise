import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tdd.training.Display;
import com.tdd.training.Price;
import com.tdd.training.ShoppingCart;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddPricesToCart
{
    @Mock
    Display display;

    @InjectMocks
    ShoppingCart cart;

    public static final Price PRICE_15 = Price.cents(15);
    public static final Price PRICE_20 = Price.cents(20);
    public static final Price PRICE_50 = Price.cents(50);

    @Test
    public void addOnePriceToCart()
    {
        cart.consumePrice(PRICE_15);

        assertEquals(PRICE_15, cart.getTotal());
    }

    @Test
    public void addSeveralPrices()
    {
        cart.consumePrice(PRICE_15);
        cart.consumePrice(PRICE_15);
        cart.consumePrice(PRICE_20);

        assertEquals(PRICE_50, cart.getTotal());
    }

    @Test
    public void checkoutPrices()
    {
        cart.consumePrice(PRICE_15);

        cart.onCheckout();

        verify(display).show("Total price EUR 0,150000");
    }
}
