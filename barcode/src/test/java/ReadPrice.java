import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tdd.training.SystemInputEvent;
import com.tdd.training.Display;
import com.tdd.training.Price;
import com.tdd.training.PriceCatalog;
import com.tdd.training.PriceReader;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReadPrice
{
    public static final String BARCODE = "12345";
    public static final SystemInputEvent BARCODE_EVENT = new SystemInputEvent(BARCODE);
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
        when(catalog.findPrice(BARCODE)).thenReturn(price);

        priceReader.onEvent(BARCODE_EVENT);

        verify(display).showPrice(price);
    }

    @Test
    public void priceNotFound() {
        when(catalog.findPrice(BARCODE)).thenReturn(null);

        priceReader.onEvent(BARCODE_EVENT);

        verify(display).showPriceNotFound(BARCODE);
    }
}
