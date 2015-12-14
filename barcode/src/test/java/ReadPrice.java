import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tdd.training.Price;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReadPrice
{
    @Mock
    Price price;

    @Mock
    PriceCatalog catalog;
    @Mock
    Display display;
    private PriceReader priceReader;

    @Before
    public void setup(){
        priceReader = new PriceReader(catalog,display);
    }

    @Test
    public void priceExists(){
        when(catalog.findPrice("12345")).thenReturn(price);

        priceReader.onBarcode("12345");

        verify(display).showPrice(price);
    }

    @Test
    public void priceNotFound() {
        when(catalog.findPrice("12345")).thenReturn(null);

        priceReader.onBarcode("12345");

        verify(display).showPriceNotFound("12345");
    }

}
