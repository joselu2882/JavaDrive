package app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConsolaJavaDriveTest {

    @Test
    void consolaIsCreated() {
        Cliente cliente = new Cliente("8251303Y", "paco", "000 222 333");
        assertNotNull(cliente);
    }
}
