package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.controller.SingerController;
import rikkei.academy.model.Singer;

import java.util.List;

public class ViewSinger {
    public SingerController singerController = new SingerController();
    List<Singer> singerList = singerController.showListSinger();


    public ViewSinger() {
        System.out.println("Singer manager");
        System.out.println("1: Create Singer");
        System.out.println("2: Show Singer List");
        System.out.println("3: Detail Singer");
        System.out.println("4: Update Singer");
        System.out.println("5: Delete Singer");
        System.out.println("6: Sắp xếp ");
        System.out.println("0: Exit");
        int chooseSinger = Config.scanner().nextInt();
        switch (chooseSinger) {
            case 1:
                createSinger();
                break;
            case 2:
                showListSinger();
                break;
            case 3:
                detailSinger();
                break;
            case 4:
                editSinger();
                break;
            case 5:
                deleteSinger();
                break;
            case 6:
                sortSinger();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Not valid found");

        }
    }

    public void createSinger() {
        System.out.println("=================Create Singer===================");
        while (true) {
            int idSinger;
            if (singerList.size() == 0) {
                idSinger = 1;
            } else {
                idSinger = singerList.get(singerList.size() - 1).getId() + 1;
            }
            System.out.println("Nhập vào tên Singer: ");
            String name = Config.scanner().nextLine();
            System.out.println("Nhập vào tuổi");
            int age = Config.scanner().nextInt();
            Singer singer = new Singer(idSinger, name, age);
            singerController.createSinger(singer);
            System.out.println("Create success");
//            System.out.println("Check List: " + singerController.showListSinger());
            singerController.showListSinger();
            System.out.println("Nhập vào phím bất kì để tiếp tục----Nhập vào quit để thoát");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new ViewSinger();
                break;
            }
        }
    }

    public void showListSinger() {
        System.out.println("|=====STT=====Name=====Age=====|");
        for (int i = 0; i < singerList.size(); i++) {
            int j = i + 1;
            System.out.println("=====" + j + "=====" + singerList.get(i).getName() + "=====" + singerList.get(i).getAge() + "=====");

        }
//        detailSinger();
        System.out.println("Nhập vào phím bất kì để tiếp tục----Nhập vào quit để thoát");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new ViewSinger();
        }
    }

    public void detailSinger() {
        System.out.println("Nhập vào id Singer");
        int idDetail = Config.scanner().nextInt();
        if (singerController.detailSinger(idDetail) == null) {
            System.out.println("Không tồn tại");
        } else {
            Singer singer = singerController.detailSinger(idDetail);

            System.out.println(singer);
        }
        System.out.println("Nhập vào phím bất kì để tiếp tục----Nhập vào quit để thoát");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new ViewSinger();

        }
    }

    public void editSinger() {
        System.out.println("Nhập vào id để sửa");
        int idEdit = Config.scanner().nextInt();
        if (singerController.detailSinger(idEdit) == null) {
            System.out.println("Not found");
        } else {
            Singer singer = singerController.detailSinger(idEdit);
            System.out.println("OLD name: " + singer.getName());
            System.out.println("OLD age: " + singer.getAge());
            System.out.println("Nhập vào tên muốn sửa");
            String newName = Config.scanner().nextLine();
            if (newName.trim().equals("")) {
                newName = singer.getName();
            }
            System.out.println("Nhập vào tuổi muốn sửa");
            String newAge = Config.scanner().nextLine();
            if (newAge.trim().equals("")) {
                newAge = String.valueOf(singer.getAge());
            }
            Singer newSinger = new Singer(newName, newAge);
            singerController.updateSinger(idEdit, newSinger);
            System.out.println("Edit Success");
            singerController.showListSinger();
        }
        System.out.println("Nhập vào phím bất kì để tiếp tục----Nhập vào quit để thoát");
        String backMunu = Config.scanner().nextLine();
        if (backMunu.equalsIgnoreCase("quit")) {
            new ViewSinger();
        }
    }

    public void deleteSinger() {
        System.out.println("Nhập id vào để xóa");
        int idSinger = Config.scanner().nextInt();
        if (singerController.detailSinger(idSinger) == null) {
            System.out.println("Không tồn tại");
        } else {
            System.out.println("Nhập 1 để xóa -- nhập 2 để không xóa");
            int chooseDelete = Config.scanner().nextInt();
            switch (chooseDelete) {
                case 1:
                    singerController.deleteSinger(idSinger);
                    showListSinger();
                    singerController.showListSinger();
                    break;
                case 2:
                    new ViewSinger();
                    break;
            }
        }
    }

    public void sortSinger() {
        System.out.println("|=====STT=====Name=====Age=====|");
        List<Singer> listSort = singerController.sortByNameAndByAge();
        for (int i = 0; i < listSort.size(); i++) {
            int j = i + 1;
            System.out.println("=====" + j + "=====" + singerList.get(i).getName() + "=====" + singerList.get(i).getAge() + "=====");

        }
//        detailSinger();
        System.out.println("Nhập vào phím bất kì để tiếp tục----Nhập vào quit để thoát");
        String backMunu = Config.scanner().nextLine();
        if (backMunu.equalsIgnoreCase("quit")) {
            new ViewSinger();
        }
    }
}
