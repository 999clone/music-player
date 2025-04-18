package service;

import java.util.ArrayList;

public class Music {
    private String title;
    private User singer;
    private int numberOfStreams;
    private static ArrayList<Music> allMusics = new ArrayList<Music>();

    public void play() {
        System.out.println("Now playing: " + title + " by " + singer.getUsername());
        numberOfStreams++;
    }

    public static ArrayList<Music> Search (String title) {
        ArrayList<Music> resault = new ArrayList<Music>();
        for (Music m : allMusics) {
            if (m.title.equals(title)) {
                resault.add(m);
            }
        }
        return resault;
    }
    public static Music Search (String title, String singerUsername) {
        for (Music m : allMusics) {
            if (m.title.equals(title) && m.singer.getUsername().equals(singerUsername)) {
                return m;
            }
        }
        return null;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setSinger(User singer) {
        this.singer = singer;
    }
    public void setNumberOfStreams(int numberOfStreams) {
        this.numberOfStreams = numberOfStreams;
    }

    public String getTitle() {
        return title;
    }
    public User getSinger() {
        return singer;
    }
    public int getNumberOfStreams() {
        return numberOfStreams;
    }

}
