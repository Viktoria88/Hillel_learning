
public class AdapterMain {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp4", "take me away.mp4");
        audioPlayer.play("mp3", "like lovers do.mp3");
        audioPlayer.play("vlc", "summer time.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
