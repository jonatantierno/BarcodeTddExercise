import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.tdd.training.MapPriceCatalog;
import com.tdd.training.Price;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class StorePricesInMap extends PriceCatalogContractTests
{
    @Override
    protected MapPriceCatalog createCatalogWithCode(String code, Price price)
    {
        MapPriceCatalog catalog = new MapPriceCatalog();
        catalog.addPrice(code, price);
        return catalog;
    }

    @Override
    protected MapPriceCatalog createCatalogWithout(String code)
    {
        MapPriceCatalog catalog = new MapPriceCatalog();
        catalog.addPrice("not "+code,mock(Price.class));
        return catalog;
    }
}
