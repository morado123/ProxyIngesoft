package proxy.ejemplo;

import proxy.biblotecaMedios.ThirdPartyYouTubeClass;
import proxy.downloader.YouTubeDownloader;
import proxy.proxy.YouTubeCacheProxy;


public class Demo {

    public static void main(String[] args) {
        YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeClass());
        YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy());

        System.out.println("Probando sin caché:");
        long naive = test(naiveDownloader);

        System.out.println("Probando con caché:");
        long smart = test(smartDownloader);

        System.out.print("Tiempo ahorrado por el proxy con caché: " + (naive - smart) + "ms");
    }

    private static long test(YouTubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        // Simulación del comportamiento del usuario en la aplicación:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        // Los usuarios pueden visitar la misma página varias veces.
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Tiempo transcurrido: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}
