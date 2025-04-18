package service;

public class PremiumBehavior implements UserBehavior{
    private int month;

    @Override
    public void createPlaylist(String Title, User Owner) throws InvalidOperationException {
        Playlist pl1 = new Playlist();
    }

    @Override
    public void playMusic(Music music) throws InvalidOperationException {

    }

    @Override
    public void buyPremium(User owner, int month) {
        this.month += month;
    }
}
