import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReadPrice
{
    @Mock
    PriceCatalog catalog;
    @Mock
    Display display;

    @Test
    public void priceExists(){
        when(catalog.findPrice("12345")).thenReturn("29");
        PriceReader priceReader = new PriceReader(catalog,display);

        priceReader.onBarcode("12345");

        verify(display).showPrice("29");
    }

}
