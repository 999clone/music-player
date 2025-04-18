package service;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<User> followerList = new ArrayList<User>();
    private ArrayList<User> followingList = new ArrayList<User>();
    private UserBehavior behavior;
    private ArrayList<Playlist> playlists = new ArrayList<Playlist>();
    private static ArrayList<User> allUsers = new ArrayList<User>();

    void follow (User user){

    }
    void createPlaylist (String Title, User Owner){
        this.behavior.createPlaylist(title, owner);
    }
    void playMusic (Music music) throws InvalidOperationException {
        this.behavior.playMusic(music);
    }
    void buyPremium (User owner, int month){
        this.behavior.buyPremium(owner, month);
    }
}
