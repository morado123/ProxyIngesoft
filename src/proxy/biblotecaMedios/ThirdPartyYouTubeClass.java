package proxy.biblotecaMedios;

import java.util.HashMap;

public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

    @Override
    public HashMap<String, Video> popularVideos() {
        connectToServer("http://www.youtube.com");
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer("http://www.youtube.com/" + videoId);
        return getSomeVideo(videoId);
    }

    private void connectToServer(String server) {
        System.out.print("Conectando a " + server + "... ");
        experienceNetworkLatency();
        System.out.print("¡Conectado!\n");
    }

    private void experienceNetworkLatency() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, Video> getRandomVideos() {
        HashMap<String, Video> hmap = new HashMap<>();
        hmap.put("catzzzzzzzzz", new Video("sadgahasgdas", "Catzzzz.avi"));
        return hmap;
    }

    private Video getSomeVideo(String videoId) {
        return new Video(videoId, "Some video title");
    }
}
