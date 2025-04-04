package test.java.integration;

import main.java.modules.log.*;
import main.java.modules.trig.*;
import main.java.system.PiecewiseFunction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Step0: все модули - mock.
 */
public class Step0AllStubsMockTest {

    private TanModule tanMock;
    private CotModule cotMock;
    private SecModule secMock;

    private Log2Module log2Mock;
    private LnModule lnMock;

    private PiecewiseFunction systemUnderTest;

    @Before
    public void setUp() {
        tanMock = mock(TanModule.class);
        cotMock = mock(CotModule.class);
        secMock = mock(SecModule.class);

        log2Mock = mock(Log2Module.class);
        Log3Module log3Mock = mock(Log3Module.class);
        Log5Module log5Mock = mock(Log5Module.class);
        lnMock   = mock(LnModule.class);

        systemUnderTest = new PiecewiseFunction(
                tanMock, cotMock, secMock,
                log2Mock, log3Mock, log5Mock, lnMock
        );
    }

    @Test
    public void testNegativeXStub() {

        when(tanMock.tan(-Math.PI/4)).thenReturn(1.0);
        when(cotMock.cot(-Math.PI/4)).thenReturn(-1.0);
        when(secMock.sec(-Math.PI/4)).thenReturn(2.0);

        double x = -Math.PI / 4;
        double result = systemUnderTest.calculate(x);

        System.out.println("Step0 -> f(-π/4) = " + result);
        assertFalse(Double.isNaN(result));

        verify(tanMock).tan(x);
    }

    @Test
    public void testZeroXStub() {
        when(tanMock.tan(0)).thenReturn(0.0);
        when(cotMock.cot(0)).thenReturn(9999.0);
        when(secMock.sec(0)).thenReturn(1.0);

        double result = systemUnderTest.calculate(0.0);
        System.out.println("Step0 -> f(0) = " + result);
        assertFalse(Double.isNaN(result));
    }

    @Test(expected = ArithmeticException.class)
    public void testLogPartException() {
        when(log2Mock.log2(1.0)).thenReturn(0.0);
        when(lnMock.ln(1.0)).thenReturn(0.0);

        systemUnderTest.calculate(1.0);
    }
}
