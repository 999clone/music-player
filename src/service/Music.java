package service;

import java.util.ArrayList;

public class Music {
    private String title;
    private User singer;
    private int numberOfStreams = 0;
    private static ArrayList<Music> allMusics = new ArrayList<Music>();

    public Music(String title, User singer) throws InvalidOperationException {
        if (title.isEmpty() || singer == null) {
            throw new InvalidOperationException("title and singer cannot be empty");
        }
        this.title = title;
        this.singer = singer;
        allMusics.add(this);
    }

    public void play() {
        System.out.println("Now playing: " + title + " by " + singer.getUsername() + "\tstreams : " + numberOfStreams);
        numberOfStreams++;
    }

    public static ArrayList<Music> Search (String title) {
        boolean found = false;
        ArrayList<Music> resault = new ArrayList<Music>();
        for (Music m : allMusics) {
            if (m.title.equals(title)) {
                found = true;
                resault.add(m);
            }
        }
        if (!found) {
            return null;
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
