package hust.soict.ict.test.disc;

import hust.soict.ict.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD=new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD=new DigitalVideoDisc("Cinderella");
		swap(jungleDVD,cinderellaDVD);
		System.out.println("jungle dvd tilte: "+jungleDVD.getTitle());
		System.out.println("cinderella dvd tilte: "+cinderellaDVD.getTitle());
		changeTitle(jungleDVD,cinderellaDVD.getTitle());
		System.out.println("jugle DVD title: "+jungleDVD.getTitle());
	}
	public static void swap(Object o1,Object o2) {
		Object tmp=1;
		o1=o2;
		o2=tmp;
	}
	public static void changeTitle(DigitalVideoDisc dvd,String title) {
		String oldTitle=dvd.getTitle();
		dvd.setTitle(title);
		dvd=new DigitalVideoDisc(oldTitle);
	}

}
