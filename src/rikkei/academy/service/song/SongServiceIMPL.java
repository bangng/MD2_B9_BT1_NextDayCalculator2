package rikkei.academy.service.song;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import rikkei.academy.config.Config;
import rikkei.academy.controller.SortByListen;
import rikkei.academy.model.Song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SongServiceIMPL implements ISongService{
    public static final String PATH_SONG = "D:\\IdeaProjects\\Test\\src\\rikkei\\academy\\database\\song.txt";
    public static List<Song> songList = new Config<Song>().readFile(PATH_SONG);
//    static {
//        songList.add(new Song(1,"Mùa Đông"));
//        songList.add(new Song(2,"Mùa Xuân"));
//        songList.add(new Song(3,"Mùa Hạ"));
//        songList.add(new Song(4,"Mùa Thu"));
//        songList.add(new Song(5,"Bốn Mùa"));
//    }
    @Override
    public List<Song> findAll() {
        new Config<Song>().writeFile(PATH_SONG,songList);
        return songList;
    }

    @Override
    public void save(Song song) {
        songList.add(song);

    }

    @Override
    public Song findById(int id) {
        for (int i = 0; i < songList.size(); i++) {
            if (songList.get(i).getId() == id){
                return songList.get(i);
            }

        }
        return null;
    }

    @Override
    public void deleteByID(int id) {
        for (int i = 0; i < songList.size(); i++) {
            if (id == songList.get(i).getId()){
                songList.remove(i);
            }
        }

    }

    @Override
    public List<Song> sortByLike() {
        List<Song> sortByLike = new ArrayList<>();
        for (int i = 0; i < songList.size(); i++) {

            sortByLike.add( songList.get(i));

        }
        Collections.sort(sortByLike);
        List<Song> topLike = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
           topLike.add(sortByLike.get(i));
        }
        return topLike;
    }

    @Override
    public List<Song> sortByListen() {
        List<Song> listen = new ArrayList<>();
        for (int i = 0; i < songList.size(); i++) {
            listen.add(songList.get(i));
        }
        SortByListen sortByListen = new SortByListen();
        Collections.sort(listen,sortByListen);
        List<Song> topListen = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            topListen.add(listen.get(i));
        }
        return topListen;
    }
}
