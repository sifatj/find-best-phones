import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PhoneListTest {
    private PhoneList phoneList = new PhoneList();
    private Phone phone = new Phone("Samsung_Sam_7", 4.2, 100);
    private Phone other = new Phone("Samsung_Sif_7", 4.0, 50);

    @Test
    public void testAddPhone() {
        Phone phone = new Phone("Samsung_Sam_7", 4.2, 100);
        phoneList.addPhone(phone);

        assertEquals(1, phoneList.getAllPhones().size());
    }

    @Test
    public void testEmptyPhoneList() {
        assertEquals(0, phoneList.getAllPhones().size());
    }

    @Test
    public void testPhoneIsDominated() {
        phoneList.addPhone(phone);
        phoneList.addPhone(other);
        assertTrue(phoneList.phoneIsDominated(other));
    }

    @Test
    public void testGetAllPhones() {
        List<Phone> phones = new ArrayList<>();
        phones.add(phone);
        phones.add(other);
        phoneList.addPhone(phone);
        phoneList.addPhone(other);
        for (int i = 0; i < phones.size(); i++) {
            assertEquals(phones.get(i), phoneList.getAllPhones().get(i));
        }
    }
}