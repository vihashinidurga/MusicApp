import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
   private String albumName;
   private String artist;
   private ArrayList<Song> songs;

    public Album(String albumName, String artist) {
        this.albumName = albumName;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public Album(){

    }
    public Song findSong(String title){
        for(Song checkedSong:songs){
            if(checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }

    public boolean addSong (String title,double duration){
        if (findSong(title)==null){
            songs.add(new Song(title,duration));
            System.out.println(title+" successfully added to the list");
            return true;
        }
        else{
            System.out.println("Song with title " +title +"already exists in the list");
            return false;
        }
    }
    public boolean addToPlayList(int trackNumber, LinkedList<Song>PlayList){
        int index=trackNumber-1;
        if(index>0 && index<=this.songs.size()){
            PlayList.add(this.songs.get(index));
            return true;
        }
       System.out.println("This album doesn't have song with track number" +trackNumber);
        return false;
    }
    public boolean addToPlayList(String title, LinkedList<Song> PlayList){
      for(Song checkedSong: this.songs){
          if(checkedSong.getTitle().equals(title)) {
              PlayList.add(checkedSong);
              return true;
          }
      }
        System.out.println(title +" There is no such songs in album");
        return false;
    }
}
