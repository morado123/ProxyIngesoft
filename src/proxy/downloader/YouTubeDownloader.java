package proxy.downloader;

import proxy.biblotecaMedios.ThirdPartyYouTubeLib;
import proxy.biblotecaMedios.Video;

import java.util.HashMap;

public class YouTubeDownloader {
    private ThirdPartyYouTubeLib api;

    public YouTubeDownloader(ThirdPartyYouTubeLib api) {
        this.api = api;
    }

    public void renderVideoPage(String videoId) {
        Video video = api.getVideo(videoId);
        System.out.println("\n-------------------------------");
        System.out.println("Página de video (imaginemos HTML elegante)");
        System.out.println("ID: " + video.id);
        System.out.println("Título: " + video.title);
        System.out.println("Video: " + video.data);
        System.out.println("-------------------------------\n");
    }

    public void renderPopularVideos() {
        HashMap<String, Video> list = api.popularVideos();
        System.out.println("\n-------------------------------");
        System.out.println("Videos más populares en YouTube (imaginemos HTML elegante)");
        for (Video video : list.values()) {
            System.out.println("ID: " + video.id + " / Título: " + video.title);
        }
        System.out.println("-------------------------------\n");
    }
}
