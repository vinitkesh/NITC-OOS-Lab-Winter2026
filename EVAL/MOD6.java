
import java.util.ArrayList;
import java.util.List;

// A media player can play media files of type mpeg, mp3 and wav. All these files have certain
// attributes in common like duration, file size and the file content (can be an integer array). The
// common methods are computeDuration() and computeFileSize(). Specific files have decode()
// function to decode the file. A media player should support load() and play() functions. play()
// function make use of decode() function to decode the file. The load functionality accepts a
// filename (string) and the type of the file. Make use of inheritance and generics to model this
// scenario.

class MediaFile {
    protected String filename; // extra
    protected int duration; // in seconds
    protected int fileSize; // in bytes
    protected int[] fileContent;

    public MediaFile(String filename, int duration, int fileSize, int[] fileContent) {
        this.filename = filename;
        this.duration = duration;
        this.fileSize = fileSize;
        this.fileContent = fileContent;
    }

    public int computeDuration() {
        return duration;    
    }

    public int computeFileSize() {
        return fileSize;
    }

    public void decode() {
        // Nodecode by default
        return;
    }
}

class MPEGFile extends MediaFile {
    public MPEGFile(String filename, int duration, int fileSize, int[] fileContent) {
        super(filename, duration, fileSize, fileContent);
    }
    public void decode() {
        // Implementation to decode MPEG file
    }
}

class MP3File extends MediaFile {
    public MP3File(String filename, int duration, int fileSize, int[] fileContent) {
        super(filename, duration, fileSize, fileContent);
    }
    public void decode() {
        // Implementation to decode MP3 file
    }
}

class WAVFile extends MediaFile {
    public WAVFile(String filename, int duration, int fileSize, int[] fileContent) {
        super(filename, duration, fileSize, fileContent);
    }
    public void decode() {
        // Implementation to decode WAV file
    }
}


class MediaPlayer<T extends MediaFile> {
    private T mediaFile;

    public void load(String filename, Class<T> fileType, int duration, int fileSize, int[] fileContent) {
        // Implementation to load the file based on filename and fileType
        // This is a placeholder implementation
        try {
            mediaFile = fileType.getConstructor(String.class, int.class, int.class, int[].class)
                    .newInstance(filename, duration, fileSize, fileContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (mediaFile != null) {
            mediaFile.decode();
            // Additional code to play the media file
            System.out.println("Playing media file with duration: " + mediaFile.computeDuration() + " seconds and size: " + mediaFile.computeFileSize() + " bytes.");
        }
    }

    @Override
    public String toString() {
        return "MediaPlayer playing: " + mediaFile.filename + " \n  (Duration: " + mediaFile.computeDuration() + " seconds, Size: " + mediaFile.computeFileSize() + " bytes)";
    }
}
// Extra, just to play around
// A multi media player that can play any type of media file using the MediaPlayer class
// Keeps a playlist of media files ( evenv of diff types) and can play them sequentially

class MultiMediaPlayer {
    private List<MediaPlayer<? extends MediaFile>> playlist = new ArrayList<>();

    public void addMediaToPlaylist(MediaFile media) {
        // Implementation to add media to playlist by creating a concrete MediaPlayer for each type
        if (media instanceof MPEGFile) {
            MediaPlayer<MPEGFile> player = new MediaPlayer<>();
            player.load(media.filename, MPEGFile.class, media.computeDuration(), media.computeFileSize(), media.fileContent);
            playlist.add(player);
        } else if (media instanceof MP3File) {
            MediaPlayer<MP3File> player = new MediaPlayer<>();
            player.load(media.filename, MP3File.class, media.computeDuration(), media.computeFileSize(), media.fileContent);
            playlist.add(player);
        } else if (media instanceof WAVFile) {
            MediaPlayer<WAVFile> player = new MediaPlayer<>();
            player.load(media.filename, WAVFile.class, media.computeDuration(), media.computeFileSize(), media.fileContent);
            playlist.add(player);
        }
    }

    public void displayPlaylist() {
        for (MediaPlayer<? extends MediaFile> player : playlist) {
            System.out.println(player.toString());
        }
    }

    public void playAll() {
        for (MediaPlayer<? extends MediaFile> player : playlist) {
            player.play();
        }
    }
}


public class MOD6 {
    public static void main(String[] args) {
        // MediaPlayer<MPEGFile> mpegPlayer = new MediaPlayer<>();
        // mpegPlayer.load("sample.mpeg", MPEGFile.class);
        // mpegPlayer.play();

        // MediaPlayer<MP3File> mp3Player = new MediaPlayer<>();
        // mp3Player.load("sample.mp3", MP3File.class);
        // mp3Player.play();

        // MediaPlayer<WAVFile> wavPlayer = new MediaPlayer<>();
        // wavPlayer.load("sample.wav", WAVFile.class);
        // wavPlayer.play();

        MultiMediaPlayer multiPlayer = new MultiMediaPlayer();
        multiPlayer.addMediaToPlaylist(new MPEGFile("sample.mpeg", 300, 5000000, new int[0]));
        multiPlayer.addMediaToPlaylist(new MP3File("sample.mp3", 200, 3000000, new int[0]));
        multiPlayer.addMediaToPlaylist(new WAVFile("sample.wav", 400, 7000000, new int[0]));

        // Play all media files in the playlist
        multiPlayer.displayPlaylist();
        multiPlayer.playAll();
    }
}
