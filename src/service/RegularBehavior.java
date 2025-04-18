package service;

public class RegularBehavior implements UserBehavior{
    private int playingLimit;

    @Override
    public void createPlaylist(String Title, User Owner) throws InvalidOperationException {
        throw new InvalidOperationException("Regular users cannot create a playlist. you can buy primium!");
    }

    @Override
    public void playMusic(Music music) throws InvalidOperationException {
        if (playingLimit <= 0) {
            throw new InvalidOperationException("you have reached your play limit. upgrade to primium to continue listining.");
        }
        playingLimit--;

    }

    @Override
    public void buyPremium(User owner, int month) {

    }
}
