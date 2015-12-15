import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tdd.training.BarcodeEvent;
import com.tdd.training.PointOfSaleListener;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HandleBarcodeRead
{
    @Mock
    PointOfSaleListener listener;

    @Test
    public void oneBarcode() throws IOException
    {
        process(new StringReader("barcode"));

        verify(listener).onEvent(new BarcodeEvent("barcode"));
    }

    @Test
    public void zeroBarcodes() throws IOException
    {
        process(new StringReader("\n"));

        verify(listener,never()).onEvent(any());
    }

    @Test
    public void manyBarcodes() throws IOException
    {
        process(new StringReader(("barcode\nbarcode\n\nbarcode")));
    }

    private void process(StringReader barcode) throws IOException
    {
        new BufferedReader(barcode).lines().map(String::trim).filter((s)->!s.isEmpty()).forEach((line)->listener.onEvent(new BarcodeEvent(line)));
    }
}