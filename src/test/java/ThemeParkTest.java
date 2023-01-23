import junit.framework.TestCase;
import org.junit.Before;
import people.Visitor;

public class ThemeParkTest extends TestCase {

    ThemePark themePark;
    Visitor visitor;
    Visitor visitor1;
    Visitor visitor2;


    @Before
    public void setUp() {
        themePark = new ThemePark();
        visitor = new Visitor(17, 180, 50);
        visitor1 = new Visitor(13, 150, 50);
        visitor2 = new Visitor(17, 130, 50);
    }

    public void testThemeParkCanGetAllReviews() {
        assertEquals(7, themePark.getAllReviewed().size());
    }

    public void testLetsAVisitOccur() {
        themePark.visit(visitor, themePark.dodgems);
        assertEquals(1, themePark.dodgems.getVisitCount());
        assertEquals(1, visitor.getVisitedAttractions().size());
    }

    public void testCanReviewReviews() {
        themePark.getAllReviewed();
        assertEquals(7, themePark.getHashReviews().size());
    }

    public void testCanCheckAllowability() {
        assertEquals(3,
                themePark.getAllowedFor(visitor).size());
        assertEquals(4,
                themePark.getAllowedFor(visitor1).size());
        assertEquals(2,
                themePark.getAllowedFor(visitor2).size());
    }
}