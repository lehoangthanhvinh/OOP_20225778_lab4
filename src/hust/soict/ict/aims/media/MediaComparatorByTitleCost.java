package hust.soict.ict.aims.media;
import java.util.*;
public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        int costComparison = Float.compare(m1.getCost(), m2.getCost());
        if (costComparison == 0) {
            return m1.getTitle().compareTo(m2.getTitle());
        }
        return costComparison;
    }
}
