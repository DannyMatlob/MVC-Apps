//100% of this class was written by Danny Matlob
package simstation;
import mvc.Utilities;

public enum Heading {
    NORTH,
    NORTHWEST,
    WEST,
    SOUTHWEST,
    SOUTH,
    SOUTHEAST,
    EAST,
    NORTHEAST,
    ;

    public static Heading random() {
        int headingNum = Utilities.rng.nextInt(8);
        switch (headingNum) {
            case 1:  {
                return NORTH;
            }
            case 2: {
                return NORTHEAST;
            }
            case 3: {
                return WEST;
            }
            case 4: {
                return NORTHWEST;
            }
            case 5: {
                return SOUTH;
            }
            case 6: {
                return SOUTHWEST;
            }
            case 7: {
                return SOUTHEAST;
            }
            case 8: {
                return EAST;
            }
            default: return NORTH;
        }
    }
}
