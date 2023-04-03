
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    public void testGetSequenceLength() {
        assertEquals(0, CalculateObject.getSequenceLength("0"));
        assertEquals(1, CalculateObject.getSequenceLength("1"));
        assertEquals(2, CalculateObject.getSequenceLength("011"));
        assertEquals(3, CalculateObject.getSequenceLength("11011"));
        assertEquals(4, CalculateObject.getSequenceLength("111100"));
    }

    @Test
    public void testCalc() {
        assertEquals(1, CalculateObject.calc(0));
        assertEquals(2, CalculateObject.calc(45));
        assertEquals(1, CalculateObject.calc(90));
        assertEquals(2, CalculateObject.calc(135));
        assertEquals(1, CalculateObject.calc(180));
        assertEquals(2, CalculateObject.calc(225));
        assertEquals(1, CalculateObject.calc(270));
        assertEquals(2, CalculateObject.calc(315));
    }

    @Test
    public void testSerialization() throws IOException, ClassNotFoundException {
        CalculateObject object1 = new CalculateObject();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutStream = new ObjectOutputStream(outStream);
        objectOutStream.writeObject(object1);
        objectOutStream.flush();
        objectOutStream.close();

        ByteArrayInputStream inStream = new ByteArrayInputStream(outStream.toByteArray());
        ObjectInputStream objectInStream = new ObjectInputStream(inStream);
        CalculateObject object2 = (CalculateObject) objectInStream.readObject();
        objectInStream.close();

        assertTrue(object1.getClass() == object2.getClass());
    }
}
