import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tdd.training.InputEventListener;
import com.tdd.training.SystemInputEvent;
import com.tdd.training.SystemInputReader;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReadFromSystemInput
{
    public static final String CONTENT = "content";
    @Mock
    InputEventListener listener;

    @InjectMocks
    SystemInputReader reader;

    @Test
    public void oneEvent() throws IOException
    {
        reader.process(new StringReader(CONTENT));

        verify(listener).onEvent(new SystemInputEvent(CONTENT));
    }

    @Test
    public void zeroEvents() throws IOException
    {
        reader.process(new StringReader("\n"));

        verify(listener,never()).onEvent(any());
    }

    @Test
    public void manyEvents() throws IOException
    {
        reader.process(new StringReader((CONTENT+"\n"+CONTENT+"\n\n"+CONTENT)));

        verify(listener, times(3)).onEvent(new SystemInputEvent(CONTENT));
    }

}