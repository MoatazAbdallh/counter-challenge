import com.moataz.counter.CounterTask;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Time;
import java.util.Timer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CounterTaskTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    Timer t;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        t = mock(Timer.class);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testDividableBy3And5() {
        CounterTask counterTask = new CounterTask(15, 15, t);
        counterTask.run();
        assertEquals("15\nfooboo\n", outContent.toString());
    }

    @Test
    public void testDividableBy3() {
        CounterTask counterTask = new CounterTask(9, 9, t);
        counterTask.run();
        assertEquals("9\nfoo\n", outContent.toString());
    }

    @Test
    public void testDividableBy5() {
        CounterTask counterTask = new CounterTask(20, 20, t);
        counterTask.run();
        assertEquals("20\nboo\n", outContent.toString());
    }

    @Test
    public void testTaskIsStoppedWhenCurrentValueGreaterThanEndValue() {
        CounterTask counterTask = new CounterTask(20, 20, t);
        counterTask.run();
        verify(t, times(1)).cancel();
    }
}
