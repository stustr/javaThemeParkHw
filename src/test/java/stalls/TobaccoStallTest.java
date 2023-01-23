package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor visitor1;
    Visitor visitor2;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum",
                "Jack Jarvis", ParkingSpot.B1, 5);
        visitor1 = new Visitor(12, 188.00, 50.00);
        visitor2 = new Visitor(21, 165, 10);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis",
                tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1,
                tobaccoStall.getParkingSpot());
    }

    @Test
    public void hasAgeLimit() {
        assertFalse(tobaccoStall.isAllowedTo(visitor1));
        assertTrue(tobaccoStall.isAllowedTo(visitor2));

    }

}
