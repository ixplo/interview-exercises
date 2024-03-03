package serialization;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SerializationManagementTest {

    SerializationManagement serializationManagement;

    @Before
    public void setUp() {
        serializationManagement = new SerializationManagement("./target/%1$s.dat");
    }

    @Test
    public void serialize() {
        String expected = "Simple String";
        serializationManagement.serialize("test", expected);

        String actual = serializationManagement.deserialize("test", String.class);
        assertEquals(expected, actual);
    }

    @Test
    public void serializeList() {
        List<String> expected = Arrays.asList("Simple String", "Second String");
        serializationManagement.serialize("test", expected);

        List<String> actual = serializationManagement.deserializeList("test", String.class);
        assertEquals(expected, actual);
    }

}