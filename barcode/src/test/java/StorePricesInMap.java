import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tdd.training.MapPriceCatalog;
import com.tdd.training.Price;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StorePricesInMap
{
    @Mock
    Price price;

    @Test
    public void priceFound() {
        MapPriceCatalog catalog = new MapPriceCatalog();
        catalog.addPrice("code",price);

        assertEquals(price, catalog.findPrice("code"));
    }
}
