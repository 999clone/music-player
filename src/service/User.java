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
                throw new InvalidOperationException("Username already exists");
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

    public void follow (User user) throws InvalidOperationException {
        if (user == null) {
            throw new InvalidOperationException("User cannot be null");
        }
        if (followerList.contains(user)) {
            throw new InvalidOperationException("User is already followed");
        }
        followerList.add(user);
    }

    public void createPlaylist (String Title) throws InvalidOperationException {
        if (Title == null || Title.isEmpty()) {
            throw new InvalidOperationException("Title cannot be null");
        }
        this.behavior.createPlaylist(Title, this);
    }

    public void playMusic (Music music) throws InvalidOperationException {
        if (music == null) {
            throw new InvalidOperationException("Music cannot be null");
        }
        this.behavior.playMusic(music);
    }
    public void buyPremium (User owner, int month) throws InvalidOperationException {
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
    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public boolean userValidator(String username, String password){
        if (username == null || username.equals("") || password == null || password.equals("")) {
            return false;
        }
        return true;
    }
}
