package rikkei.academy.view;

import rikkei.academy.config.Config;

public class Main {
    public Main(){
        System.out.println("MENU");
        System.out.println("1: Singer manager");
        System.out.println("2: Song manager");
        int chooseMenu = Config.scanner().nextInt();
        switch (chooseMenu){
            case 1:
                new ViewSinger();
                break;
            case 2:
                new ViewSong();
                break;
        }
    }
    public static void main(String[] args) {
       new Main();
    }
}
