package service;

import java.util.ArrayList;
import java.util.Collections;

public class Playlist {
    private String title;
    private User owner;
    private ArrayList<Music> playlist = new ArrayList<>();

    public Playlist(String title, User owner) {
        if (title == null || owner == null) {
            throw new NullPointerException("Title and owner cannot be null");
        }
        this.title = title;
        this.owner = owner;
    }

    public void editTitle(String newTitle, String password) throws InvalidOperationException {
        if (!owner.getPassword().equals(password)){
            throw new InvalidOperationException("incorrect password.");
        }
        if (newTitle == null || newTitle.isEmpty()) {
            throw new InvalidOperationException("Title cannot be empty");
        }
        title = newTitle;
    }

    public void addMusic(Music music, String password) throws InvalidOperationException {
        if (!owner.getPassword().equals(password)){
            throw new InvalidOperationException("incorrect password.");
        }
        if (playlist.contains(music)){
            throw new InvalidOperationException("music already exists in playlist");
        }
        playlist.add(music);
    }

    public void removeMusic(Music music, String password) throws InvalidOperationException {
        if (!owner.getPassword().equals(password)){
            throw new InvalidOperationException("incorrect password.");
        }
        if (!playlist.contains(music)){
            throw new InvalidOperationException("music does not exist in playlist");
        }
            playlist.remove(music);
    }

    public ArrayList<Music> searchInPlaylist(String title) {
        boolean found = false;
        ArrayList<Music> resault = new ArrayList<>();
        for (Music m : playlist) {
            if (m.getTitle().equals(title)) {
                found = true;
                resault.add(m);
            }
        }
        if (!found) {
            return null;
        }
        return resault;
    }
    public Music searchInPlaylist  (String title, String singerUsername) {
        for (Music m : playlist) {
            if (m.getTitle().equals(title) && m.getSinger().getUsername().equals(singerUsername)) {
                return m;
            }
        }
        return null;
    }

    public void playPlaylist(){
        for (Music m : playlist) {
            m.play();
        }
    }
    public void shufflePlaylist(){
        ArrayList<Music> shuffledPlaylist = new ArrayList<>();
        shuffledPlaylist.addAll(playlist);
        Collections.shuffle(shuffledPlaylist);
        for (Music m : shuffledPlaylist) {
            m.play();
        }
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) throws InvalidOperationException {
        if (title == null || title.isEmpty()) {
            throw new InvalidOperationException("Title cannot be empty");
        }
        this.title = title;
    }
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) throws InvalidOperationException {
        if (owner == null) {
            throw new InvalidOperationException("Owner cannot be null");
        }
        this.owner = owner;
    }
    public ArrayList<Music> getPlaylist() {
        return playlist;
    }
}
