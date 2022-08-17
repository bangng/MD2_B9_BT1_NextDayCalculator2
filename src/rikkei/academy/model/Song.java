package rikkei.academy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Song implements Serializable, Comparable<Song>{
    private int id;
    private String name;
    private int like;
    private int listen;
    private List<Singer> singerList = new ArrayList<>();


    public Song() {
    }


    public List<Singer> getSingerList() {
        return singerList;
    }

    public void setSingerList(List<Singer> singerList) {
        this.singerList = singerList;
    }

    public Song(int id, String name, int like, int listen, List<Singer> singerList) {
        this.id = id;
        this.name = name;
        this.like = like;
        this.listen = listen;
        this.singerList = singerList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getListen() {
        return listen;
    }

    public void setListen(int listen) {
        this.listen = listen;
    }

    @Override
    public String toString() {
        return "song.txt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", like=" + like +
                ", listen=" + listen +
                '}';
    }

    @Override
    public int compareTo(Song o) {

        return o.getLike() -this.getLike();
    }
}
