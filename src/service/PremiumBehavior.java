package service;

public class PremiumBehavior implements UserBehavior{
    private int month;

    public PremiumBehavior(int month) throws InvalidOperationException {
        if (month < 1 || month > 12) {
            throw new InvalidOperationException("Invalid month");
        }
        this.month = month;
    }

    @Override
    public void createPlaylist(String Title, User Owner) throws InvalidOperationException {
        if (Title == null || Title.isEmpty()) {
            throw new InvalidOperationException("Invalid title");
        }
        if (Owner == null) {
            throw new InvalidOperationException("Invalid owner");
        }
        Playlist pl1 = new Playlist(Title, Owner);
        Owner.addPlaylist(pl1);
    }

    @Override
    public void playMusic(Music music) throws InvalidOperationException {
        if (music == null) {
            throw new InvalidOperationException("music is null");
        }
        music.play();
    }

    @Override
    public void buyPremium(User owner, int month) {
        this.month += month;
    }
}
