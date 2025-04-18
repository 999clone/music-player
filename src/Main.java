import service.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InvalidOperationException {
        int passed = 0, failed = 0;

        // setup users and tracks
        User user1 = null;
        User user2 = null;
        try {
            user1 = new User("alice", "securePass");
            user2 = new User("bob", "anotherPass");
            passed++;
        } catch (InvalidOperationException e) {
            System.out.println("Setup users failed: " + e.getMessage());
            failed++;
        }
        Music track1 = new Music("SongA", user1);
        Music track2 = new Music("SongB", user2);
        Playlist playlist = new Playlist("MyList", user1);

        // test duplicate username
        try {
            new User("alice", "newPassword");
            System.out.println("Test duplicate username FAILED");
            failed++;
        } catch (InvalidOperationException e) {
            System.out.println("Test duplicate username passed");
            passed++;
        }

        // test short password
        try {
            new User("charlie", "short");
            System.out.println("Test short password FAILED");
            failed++;
        } catch (InvalidOperationException e) {
            System.out.println("Test short password passed");
            passed++;
        }

        // test regular play limit
        try {
            for (int i = 0; i < 5; i++) {
                user1.playMusic(track1);
            }
            try {
                user1.playMusic(track1);
                System.out.println("Test play limit FAILED");
                failed++;
            } catch (InvalidOperationException e) {
                System.out.println("Test play limit passed");
                passed++;
            }
        } catch (Exception e) {
            System.out.println("Test regular behavior error: " + e.getMessage());
            failed++;
        }
        track1.setNumberOfStreams(0);
        // test play count and search
        track1.play();
        track1.play();
        if (track1.getNumberOfStreams() == 2) {
            System.out.println("Test play count passed");
            passed++;
        } else {
            System.out.println("Test play count FAILED");
            failed++;
        }

        ArrayList<Music> results = Music.Search("SongA");
        if (results.contains(track1)) {
            System.out.println("Test search by title passed");
            passed++;
        } else {
            System.out.println("Test search by title FAILED");
            failed++;
        }
        Music found = Music.Search("SongB", "bob");
        if (found == track2) {
            System.out.println("Test search by title and singer passed");
            passed++;
        } else {
            System.out.println("Test search by title and singer FAILED");
            failed++;
        }

        // test playlist operations
        try {
            try {
                playlist.addMusic(track1, "wrongPass");
                System.out.println("Test add wrong pass FAILED");
                failed++;
            } catch (InvalidOperationException e) {
                System.out.println("Test add wrong pass passed");
                passed++;
            }
            playlist.addMusic(track1, user1.getPassword());
            if (!playlist.searchInPlaylist("SongA").isEmpty()) {
                System.out.println("Test add music passed");
                passed++;
            } else {
                System.out.println("Test add music FAILED");
                failed++;
            }
            playlist.removeMusic(track1, user1.getPassword());
            if (playlist.searchInPlaylist("SongA") == null) {
                System.out.println("Test remove music passed");
                passed++;
            } else {
                System.out.println("Test remove music FAILED");
                failed++;
            }
            playlist.addMusic(track1, user1.getPassword());
            playlist.addMusic(track2, user1.getPassword());
            playlist.playPlaylist();
            playlist.shufflePlaylist();
            int total = playlist.searchInPlaylist("SongA").size() + playlist.searchInPlaylist("SongB").size();
            if (total == 2) {
                System.out.println("Test shuffle size passed");
                passed++;
            } else {
                System.out.println("Test shuffle size FAILED");
                failed++;
            }
        } catch (Exception e) {
            System.out.println("Test playlist operations error: " + e.getMessage());
            failed++;
        }

        // test premium behavior
        try {
            user1.buyPremium(user1, 2);
            user1.createPlaylist("VIPList", user1);
            if (!user1.getPlaylists().isEmpty()) {
                System.out.println("Test premium upgrade passed");
                passed++;
            } else {
                System.out.println("Test premium upgrade FAILED");
                failed++;
            }
        } catch (Exception e) {
            System.out.println("Test premium behavior error: " + e.getMessage());
            failed++;
        }

        System.out.println("Tests completed: passed=" + passed + " failed=" + failed);
    }
}