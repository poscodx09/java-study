package chapter03;

public class SongTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Song song = new Song("Real", "아이유", "좋은날", "이민수", 2010, 3);
		Song song2 = new Song("아이유", "좋은날");
		
//		song.setAlbum("Real");
//		song.setArtist("아이유");
//		song.setTitle("좋은날");
//		song.setComposer("이민수");
//		song.setYear(0);
//		song.setTrack(3);
		
		
		
		
		
		song.show();
		song2.show();
	}

}
