package todo.restserver;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;




public class TodoGrizzlyApp {
    private static URI BASE_URI = URI.create("http://localhost:5000/");

    public static HttpServer startServer(final String[] args, int  waitSecondsForServer) throws IOException {
        final URI baseURI = (args.length >= 1 ? uri.create(args[0] : BASE_URI));
        final ResourceConfig resourceconfig = (args.length >= 2 ? new ListeklasseConfig(args[1]) : new ListeklasseConfig());
        final HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(baseUri, resourceConfig);
        if (waitSecondsForServer < 0) {
            return httpServer;
        }
        while (waitSecondsForServer > 0) {
            try {
                final URL clientUrl = new URL(baseURI + ListeklasseService.LAT_LONG_SERVICE_PATH);
                final HttpURLConnection connection = (HttpURLConnection) clientUrl.openConnection();
                final int responseCode = connection.getResponseCode();
                System.out.println("Trying " + clientUrl + ": " + responseCode);
                connection.disconnect();
                if (responseCode == 200) {
                    return httpServer;
                }
            } catch (final Exception e) {
            }
            try {
                Thread.sleep(1000);
                waitSecondsForServer -= 1;
            } catch (final InterruptedException e) {
                return null;
            }
        }
        return null;
    }

    public static void stopServer(final HttpServer server) throws IOException {
        server.shutdown();
    }

    public static void main(final String[] args) throws IOException {
        try {
            final HttpServer server = startServer(args, -1);
            Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));
            Thread.currentThread().join();
        } catch (final InterruptedException ex) {
            Logger.getLogger(TodoGrizzlyApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

