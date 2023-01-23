import attractions.*;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThemePark {
    Dodgems dodgems = new Dodgems("Dodgems", 5);
    Park park = new Park("Park", 5);
    Playground playground = new Playground("Playground", 5);
    RollerCoaster rollerCoaster = new RollerCoaster(
            "Roller coaster", 5);
    CandyflossStall candyflossStall =
            new CandyflossStall("Candyfloss", "Foo",
                    ParkingSpot.A1, 5);
    IceCreamStall iceCreamStall = new IceCreamStall("Ice "
            + "cream", "Bar", ParkingSpot.A2, 5);
    TobaccoStall tobaccoStall = new TobaccoStall("Tobacco"
            , "Baz", ParkingSpot.A3, 5);
    ArrayList<Stall> stalls;
    ArrayList<Attraction> attractions;
    ArrayList<IReviewed> reviewed;

    public ThemePark() {
        this.reviewed = new ArrayList<>();
        this.stalls = new ArrayList<>();
        stalls.add(candyflossStall);
        stalls.add(iceCreamStall);
        stalls.add(tobaccoStall);
        this.attractions = new ArrayList<>();
        attractions.add(dodgems);
        attractions.add(park);
        attractions.add(playground);
        attractions.add(rollerCoaster);
    }

    public ArrayList<IReviewed> getAllReviewed() {
        reviewed.addAll(attractions);
        reviewed.addAll(stalls);
        return reviewed;
    }

    public void visit(Visitor visitor,
                      Attraction attraction) {
        int count = attraction.getVisitCount();
        attraction.setVisitCount(count + 1);
        visitor.addToVisited(attraction);
    }

    public HashMap getHashReviews() {
        HashMap<Object, Object> hashReviews =
                new HashMap<>();
        reviewed.forEach(iReviewed -> hashReviews.put(iReviewed.getName(), iReviewed.getRating()));
        return hashReviews;
    }

    public ArrayList<IReviewed> getAllowedFor(Visitor visitor) {
        ArrayList allowedFor = new ArrayList<>();
        for (Attraction attraction : attractions) {
            if (attraction instanceof ISecurity) {
                if (((ISecurity) attraction).isAllowedTo(visitor)) {
                    allowedFor.add(attraction);
                }
            } else {
                allowedFor.add(attraction);
            }
            ;
        }
        ;
        return allowedFor;
    }

    ;
}
