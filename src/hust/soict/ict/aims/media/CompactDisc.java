package hust.soict.ict.aims.media;
import java.util.*;
public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public String getArtist() {
		return artist;
	}
	public void addtrack(Track newTrack) {
		int i;
		for(i=0;i<tracks.size();i++) {
			if(newTrack.getTitle().equals(tracks.get(i).getTitle())) {
				System.out.println("Track existed, cancel adding");
				break;
			}
		}
		if(i==tracks.size()) {
			tracks.add(newTrack);
			System.out.println("Track added");
		}
	}
	public void removeTrack(Track oldTrack) {
		int i;
		for(i=0;i<tracks.size();i++) {
			if(oldTrack.getTitle().equals(tracks.get(i).getTitle())) {
				tracks.remove(i);
				System.out.println("Track removed");
			}
		}
		if(i==tracks.size())System.out.println("Track not found");
	}
	public int getLength() {
		int totalLength=0;
		int i;
		for(i=0;i<tracks.size();i++) {
			totalLength += tracks.get(i).getLength();
		}
		return totalLength;
	}
	public void play() {
		int i;
		for(i=0;i<tracks.size();i++) {
			tracks.get(i).play();
		}
	}
	public CompactDisc(String artist,String title,String category,float cost) {
		super();
		this.id = nbMedia;
		nbMedia++;
		this.artist = artist;
		this.title=title;
		this.category=category;
		this.cost=cost;
	}
	public CompactDisc(String title,String category,float cost) {
		super();
		this.id = nbMedia;
		nbMedia++;
		this.title=title;
		this.category=category;
		this.cost=cost;
	}
	
}
