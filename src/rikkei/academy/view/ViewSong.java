package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.controller.SingerController;
import rikkei.academy.controller.SongController;
import rikkei.academy.model.Singer;
import rikkei.academy.model.Song;

import java.util.ArrayList;
import java.util.List;

public class ViewSong {
    private SongController songController = new SongController();
    private List<Song> songList = songController.showSongList();
    private SingerController singerController = new SingerController();
    List<Singer> singerList = singerController.showListSinger();

    public ViewSong() {
        System.out.println("Song manager");
        System.out.println("1: Create Song");
        System.out.println("2: Show Song List");
        System.out.println("3: Detail Song");
        System.out.println("4: Delete Song");
        System.out.println("5: Top 5 like Song");
        System.out.println("6: Top 5 Listen Song ");
        System.out.println("0: Exit");
        int chooseSong = Config.scanner().nextInt();
        switch (chooseSong) {
            case 1:
                createSong();
                break;
            case 2:
                showListSong();
                break;
            case 3:
                detailSong();
                break;
            case 4:
                deleteSong();
                break;
            case 5:
                topLikeSong();
                break;
            case 6:
                topListenSong();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Not valid found");
        }
    }

    private void showSong() {
        showListSong();
        System.out.println("Nhập vào phím bất kì để tiếp tục----Nhập vào quit để thoát");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new ViewSong();
        }
    }

    private void showListSong() {
        System.out.println("=====STT=====NameSong=====");
        for (int i = 0; i < songList.size(); i++) {
            int j = i + 1;
            System.out.println("=====" + j + "=====" + songList.get(i).getName() + "=====");
        }
        showSong();
    }
    private void createSong() {
        System.out.println("===========CREATE SONG==============");
        while (true) {
            int idSong;
            if (songList.size() == 0) {
                idSong = 1;
            } else {
                idSong = songList.get(songList.size() - 1).getId() + 1;
            }
            System.out.println("Nhập Tên Bài Hát");
            String name = Config.scanner().nextLine();
            List<Singer> listSelectSinger = new ArrayList<>();
            selectSinger(listSelectSinger);
            Song song = new Song(idSong, name, 0, 0, listSelectSinger);
            songController.createSong(song);
            songController.showSongList();
            System.out.println("Create Song Success");
            System.out.println("=====ID======NAME=====LIKE=====LISTEN=====LIST SINGER");
            for (int i = 0; i < songList.size(); i++) {
                System.out.println("====" + songList.get(i).getId() + "====" + songList.get(i).getName() + "====" + songList.get(i).getLike() + "====" + songList.get(i).getListen() + "=====" + songList.get(i).getSingerList() + "=====");
            }
            showSong();
        }
    }
    private void selectSinger(List<Singer> listSelectSinger) {
        for (int i = 0; i < singerList.size(); i++) {
            System.out.println("=====" + singerList.get(i).getId() + "=====" + singerList.get(i).getName() + "=====");
        }
        System.out.println("Enter id of Singer to select: ");
        int idSinger = Config.scanner().nextInt();
        Singer singer = singerController.detailSinger(idSinger);
        listSelectSinger.add(singer);
        System.out.println("Enter any key to continue - Enter quit to exit select Singer");
        String exitSelect = Config.scanner().nextLine();
        if (exitSelect.equalsIgnoreCase("quit")) {
            return;
        } else {
            selectSinger(listSelectSinger);
        }
    }

    private void detailSong() {
        showListSong();
        System.out.println("Nhập vào id Song");
        int idDetailSong = Config.scanner().nextInt();
        if (songController.detailSong(idDetailSong) == null) {
            System.out.println("Không tồn tại");
        } else {
            Song song = songController.detailSong(idDetailSong);
            song.setListen(song.getListen() + 1);

            songController.showSongList();

            System.out.println("=====ID======NAME=====LIKE=====LISTEN=====LIST SINGER");
            System.out.println(song.getId()+"===="+song.getName()+"===="+song.getLike()+"===="+song.getListen()+"====");
            for (int i = 0; i < song.getSingerList().size(); i++) {
                System.out.println(song.getSingerList().get(i).getName()+",");
            }
            System.out.println("Like hay ăn đấm:::::");
            String like = Config.scanner().nextLine();
            if (like.equalsIgnoreCase("like")){
                song.setLike(song.getLike()+1);
                songController.showSongList();
            }
            System.out.println("Nhập vào quit để quay lại Song Manager: ");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new ViewSong();
            }
        }
    }
    private void deleteSong() {
        System.out.println("Nhập vào id để xóa");
        int idSong = Config.scanner().nextInt();
        if (songController.detailSong(idSong) == null){
            System.out.println("Không tồn tại");
        }else {
            System.out.println("Nhập 1 để xóa - Nhập 2 để giữ lại");
            int choice = Config.scanner().nextInt();
            switch (choice){
                case 1:
                    songController.deleteSong(idSong);
                    showListSong();
                    songController.showSongList();
                    break;
                case 2:
                    new ViewSong();
                    break;
            }
        }
        showSong();
    }
    private void editSong(){
        System.out.println("Nhập id Song để sửa");
        int idEdit = Config.scanner().nextInt();
        if (songController.detailSong(idEdit) == null){
            System.out.println("không tìm thấy");
        }else {
            Song song = songController.detailSong(idEdit);
            System.out.println("Old name: "+ song.getName());
            System.out.println("Nh" +
                    "" +
                    "");
        }
    }
    private void topLikeSong(){
       songController.topLike();
    }
    private void topListenSong(){
        songController.topListen();
    }
}
