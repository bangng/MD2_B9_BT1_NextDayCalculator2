package rikkei.academy.service.singer;

import rikkei.academy.config.Config;
import rikkei.academy.controller.SingerController;
import rikkei.academy.model.Singer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingerServiceIMPL implements ISingerService{
    public static String PATH_SINGER = "D:\\IdeaProjects\\Test\\src\\rikkei\\academy\\database\\singer.txt";

    public static List<Singer> singerList = new Config<Singer>().readFile(PATH_SINGER);
//    static {
//        singerList.add(new Singer(1,"David",30));
//        singerList.add(new Singer(2,"Justin",26));
//        singerList.add(new Singer(3,"Jame",28));
//        singerList.add(new Singer(4,"John",34));
//        singerList.add(new Singer(5,"Justin",22));
//
//    }

    @Override
    public List<Singer> findAll() {
        new Config<Singer>().writeFile(PATH_SINGER,singerList);
        return singerList;
    }

    @Override
    public void save(Singer singer) {
        singerList.add(singer);

    }

    @Override
    public Singer findById(int id) {
        for (int i = 0; i < singerList.size(); i++) {
            if (id == singerList.get(i).getId()){
              return singerList.get(i);
            }

        }
        return null;
    }

    @Override
    public void deleteByID(int id) {
        for (int i = 0; i < singerList.size(); i++) {
            if (id == singerList.get(i).getId()){
                singerList.remove(i);
            }

        }

    }

    @Override
    public List<Singer> sortByNameAndByAge() {
       List<Singer> listSort = new ArrayList<>();
        for (int i = 0; i < singerList.size(); i++) {
            listSort.add(singerList.get(i));
        }
        Collections.sort(listSort);
        return listSort;
    }
}
