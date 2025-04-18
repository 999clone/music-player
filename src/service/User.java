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

    public User(String username, String password) throws InvalidOperationException {
        for (User user : allUsers) {
            if (username.equals(user.getUsername())){
                throw new InvalidOperationException("Username is already in use");
            }
        }
        if (password.length() < 8) {
            throw new InvalidOperationException("Password must be at least 8 characters");
        }
        this.username = username;
        this.password = password;
        this.behavior = new RegularBehavior();
        allUsers.add(this);
    }
    public void follow (User user){
    }
    void createPlaylist (String Title, User Owner) throws InvalidOperationException {
        this.behavior.createPlaylist(Title, Owner);
    }
    void playMusic (Music music) throws InvalidOperationException {
        this.behavior.playMusic(music);
    }
    void buyPremium (User owner, int month) throws InvalidOperationException {
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

    public void addPlaylist (Playlist playlist){
        this.playlists.add(playlist);
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

    public boolean userValidator(String username, String password){
        if (username == null || username.equals("") || password == null || password.equals("")) {
            return false;
        }
        return true;
    }
}
