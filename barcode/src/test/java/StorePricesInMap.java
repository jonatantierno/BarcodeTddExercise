import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tdd.training.MapPriceCatalog;
import com.tdd.training.Price;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class StorePricesInMap
{
    @Mock
    Price price;

    @Test
    public void priceFound() {
        MapPriceCatalog catalog = createCatalogWithCode("code", price);

        assertEquals(price, catalog.findPrice("code"));
    }

    private MapPriceCatalog createCatalogWithCode(String code, Price price)
    {
        MapPriceCatalog catalog = new MapPriceCatalog();
        catalog.addPrice(code, price);
        return catalog;
    }

    @Test
    public void priceNotFound() {
        MapPriceCatalog catalog = createcatalogWithout("code");

        assertEquals(null, catalog.findPrice("code"));
    }

    private MapPriceCatalog createcatalogWithout(String code)
    {
        MapPriceCatalog catalog = new MapPriceCatalog();
        catalog.addPrice("not "+code,mock(Price.class));
        return catalog;
    }
}
