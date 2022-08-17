package rikkei.academy.controller;

import rikkei.academy.model.Singer;
import rikkei.academy.service.singer.ISingerService;
import rikkei.academy.service.singer.SingerServiceIMPL;

import java.util.List;

public class SingerController {
    ISingerService singerService = new SingerServiceIMPL();

    public List<Singer> showListSinger(){
        return singerService.findAll();
    }
    public void createSinger(Singer singer){
        singerService.save(singer);
    }
    public Singer detailSinger(int id){
        return singerService.findById(id);
    }
    public void updateSinger(int id, Singer singer){
        Singer singer1 = singerService.findById(id);
        singer1.setName(singer.getName());
        singer1.setAge(singer.getAge());
    }
    public void deleteSinger(int id){
        singerService.deleteByID(id);
    }
    public List<Singer> sortByNameAndByAge(){
        return singerService.sortByNameAndByAge();
    }
}
