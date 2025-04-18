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

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public ArrayList<User> getFollowerList() {
        return followerList;
    }
    public ArrayList<User> getFollowingList() {
        return followingList;
    }
    public ArrayList<User> getAllUsers(){
        return allUsers;
    }
}
