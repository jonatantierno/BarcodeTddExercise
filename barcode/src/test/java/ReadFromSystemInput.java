import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tdd.training.BarcodeEvent;
import com.tdd.training.PointOfSaleListener;
import com.tdd.training.SystemInputReader;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReadFromSystemInput
{
    @Mock
    PointOfSaleListener listener;

    @InjectMocks
    SystemInputReader reader;

    @Test
    public void oneBarcode() throws IOException
    {
        reader.process(new StringReader("barcode"));

        verify(listener).onEvent(new BarcodeEvent("barcode"));
    }

    @Test
    public void zeroBarcodes() throws IOException
    {
        reader.process(new StringReader("\n"));

        verify(listener,never()).onEvent(any());
    }

    @Test
    public void manyBarcodes() throws IOException
    {
        reader.process(new StringReader(("barcode\nbarcode\n\nbarcode")));

        verify(listener, times(3)).onEvent(new BarcodeEvent("barcode"));
    }

}