import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HandleBarcodeRead
{
    @Mock
    BarcodeListener listener;

    @Test
    public void oneBarcode() throws IOException
    {
        process(new StringReader("barcode"));

        verify(listener).onBarcode("barcode");
    }

    @Test
    public void zeroBarcodes() throws IOException
    {
        process(new StringReader("\n"));

        verify(listener,never()).onBarcode(anyString());
    }

    @Test
    public void manyBarcodes() throws IOException
    {
        process(new StringReader(("barcode\nbarcode\n\nbarcode")));
    }

    private void process(StringReader barcode) throws IOException
    {
        new BufferedReader(barcode).lines().map(String::trim).filter((s)->!s.isEmpty()).forEach(listener::onBarcode);
    }
}