import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneTest {

    private Phone phone = new Phone("Samsung_Sam_7", 4.2, 100);
    @Test(expected = IllegalArgumentException.class)
    public void testMakeIllegalArgumentPhone() {
        Phone newPhone = new Phone("The_Phone", -120,-23);
    }

    @Test
    public void testGetModel() {
        assertEquals("Samsung_Sam_7", phone.getModel());
    }

    @Test
    public void testGetScreenSize() {
        assertEquals(4.2, phone.getScreenSize(), 0.0);
    }

    @Test
    public void testGetBatterySize() {
        assertEquals(100, phone.getBatteryCapacity());
    }

    @Test
    public void testDominates() {
        Phone otherPhone = new Phone("Other_Phone", 2.3, 20);
        assertTrue(phone.dominates(otherPhone));
    }
    @Test
    public void testNotDominates() {
        Phone otherPhone = new Phone("Other_Phone", 5, 2000);
        assertFalse(phone.dominates(otherPhone));
    }
}

