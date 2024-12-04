package hust.soict.ict.aims.media;
import java.util.*;
public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        int titleComparison = m1.getTitle().compareTo(m2.getTitle());
        if (titleComparison == 0) {
            return Float.compare(m2.getCost(), m1.getCost());
        }
        return titleComparison;
    }
}
