import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tdd.training.CheckoutListener;
import com.tdd.training.PointOfSaleListener;
import com.tdd.training.SystemInputEvent;
import com.tdd.training.CommandParser;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReceiveSystemInputEvents
{
    public static final String CONTENT = "barcode";
    public static final String CHECKOUT_COMMAND_CONTENT = "t";

    @Mock
    private PointOfSaleListener barcodeListener;
    @Mock
    private CheckoutListener checkoutListener;

    @InjectMocks
    private CommandParser parser;

    SystemInputEvent inputEvent = new SystemInputEvent(CONTENT);

    @Test
    public void oneBarcode() {
        parser.onEvent(inputEvent);

        verify(barcodeListener).onEvent(new SystemInputEvent(CONTENT));
    }

    @Test
    public void oneCheckoutCommand() {
        parser.onEvent(new SystemInputEvent(CHECKOUT_COMMAND_CONTENT));

        verify(checkoutListener).onCheckout();
    }
}
