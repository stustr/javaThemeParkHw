package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(11, 188.00, 50.00);
        visitor2 = new Visitor(21, 220, 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canCheckParametersForRiding() {
        assertFalse(rollerCoaster.isAllowedTo(visitor1));
        assertTrue(rollerCoaster.isAllowedTo(visitor2));
    }


    @Test
    public void canPriceCorrectly() {
        assertEquals(8.40,
                rollerCoaster.priceForVisitor(visitor1),
                0.00);
        assertEquals(16.80,
                rollerCoaster.priceForVisitor(visitor2),
                0.00);

    }

}
