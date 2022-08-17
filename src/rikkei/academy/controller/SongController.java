package rikkei.academy.controller;

import rikkei.academy.model.Song;
import rikkei.academy.service.song.ISongService;
import rikkei.academy.service.song.SongServiceIMPL;

import java.util.List;

public class SongController {
    ISongService songService = new SongServiceIMPL();
public List<Song> showSongList(){
    return songService.findAll();
}
public void createSong(Song song){
    songService.save(song);
}
public Song detailSong(int id){
    return songService.findById(id);
}
public void deleteSong(int id){
    songService.deleteByID(id);
}
public void updateSong(int id, Song song){
    Song song1 = songService.findById(id);
    song1.setName(song.getName());

}
public List<Song> topLike(){
    return songService.sortByLike();
}
public List<Song> topListen(){
    return songService.sortByListen();
}


}

