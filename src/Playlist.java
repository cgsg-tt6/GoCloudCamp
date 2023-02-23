import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Класс-хранилище плейлиста с музыкой и полями.
 * Наверное, нужно сделать типо вложенный класс, который реализует тип Track.
 * Ваще-то все функции типо play, loop можно было написать тут, а класс Sound выкинуть.
 */
public class Playlist {
    private LinkedList<Track> tracks = new LinkedList<>();

    /**
     * Ваще можно сделать внутренним классом Playlist
     * Но так как нам надо передавать в качестве параметра в Main для недефолтного конструктора плейлиста треки,
     * то нужно чтоб класс Track был доступен и в Main
     * Хотя что нам мешает.. написать Playlist.Track(...)
     * Либо по дефолту создавать пустой плейлист, а добаблять туда треки через add,
     * а в параметрах add передавать то, что уже внутри add делать объектом типа Track
     * -------------------------------------------------------
     * Возможно, у трека должен быть экземпляр типа Clip или в том роде
     */
    static class Track {
        private final String path;
        // duration заполняется только если для этого трека был вызван метод Play
        private long duration;

        public Track(String path_name) {
            path = path_name;
        }

        public String getPath() {
            return path;
        }

        public void setDuration(long duration) {
            this.duration = duration;
        }

        public long getDuration() {
            return duration;
        }
    }

    public Playlist() {

    }

    /**
     * Чтобы не замарачиваться с добавлением файлов, а быстро проверить работу проги.
     * @param debugmode true, false без разницы
     */
    public Playlist(boolean debugmode) {
        Track track1 = new Track("DVRST - Close Eyes.wav");
        tracks.add(track1);
    }

    public void play(int number) {
        try {
            File f = new File(tracks.get(number).getPath());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f.toURI().toURL());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            tracks.get(number).setDuration(clip.getMicrosecondLength()/1000);
            Thread.sleep(tracks.get(number).getDuration());
        }
        catch (IOException | LineUnavailableException | UnsupportedAudioFileException | InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    public void playAll() {
        for (int i = 0; i < tracks.size(); i += 1) {
            play(i);
        }
    }

    public void add(Track track) {
        tracks.add(track);
    }

    public void add(String path_name) {
        tracks.add(new Track(path_name));
    }

    public void delete_by_id(int id) {
        tracks.remove(id);
    }
}
