import org.junit.Test;
import org.mockito.Mock;

import com.tdd.training.MapPriceCatalog;
import com.tdd.training.Price;

import static org.junit.Assert.assertEquals;

/**
 * Created by jtierno on 15/12/15.
 */
public abstract class PriceCatalogContractTests
{
    @Mock
    Price price;

    @Test
    public void priceFound() {
        MapPriceCatalog catalog = createCatalogWithCode("code", price);

        assertEquals(price, catalog.findPrice("code"));
    }

    protected abstract MapPriceCatalog createCatalogWithCode(String code, Price price);

    @Test
    public void priceNotFound() {
        MapPriceCatalog catalog = createCatalogWithout("code");

        assertEquals(null, catalog.findPrice("code"));
    }

    protected abstract MapPriceCatalog createCatalogWithout(String code);
}
