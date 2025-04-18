package service;

public class RegularBehavior implements UserBehavior{
    private int playingLimit = 5;

    @Override
    public void createPlaylist(String Title, User Owner) throws InvalidOperationException {
        throw new InvalidOperationException("Regular users cannot create a playlist. you can buy primium!");
    }

    @Override
    public void playMusic(Music music) throws InvalidOperationException {
        if (playingLimit <= 0) {
            throw new InvalidOperationException("you have reached your play limit. upgrade to primium to continue listining.");
        }
        music.play();
        playingLimit--;

    }

    @Override
    public void buyPremium(User owner, int month) throws InvalidOperationException {
        owner.setBehavior(new PremiumBehavior(month));
    }
}
