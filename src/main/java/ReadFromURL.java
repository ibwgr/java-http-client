import java.net.*;
import java.io.*;

public class ReadFromURL {

    public static void main(String[] args) {
        try {
            // Da wir eine http:// beginnende URL verwenden, wird im Hintergrund eine HTTP Verbindung geöffnet
            URL url = new URL(args[0]);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
