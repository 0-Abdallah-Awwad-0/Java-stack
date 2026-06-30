import java.util.HashMap;

public class Hashmatique {

    public static void main(String[] args) {

        HashMap<String, String> trackList = new HashMap<String, String>();


        trackList.put("Morning Light", "The sun is rising over the city.");
        trackList.put("Lost Signal", "I keep calling but the line is gone.");
        trackList.put("Blue Horizon", "We run toward the open sky.");
        trackList.put("Silent Roads", "The night is quiet but my mind is loud.");


        String lyrics = trackList.get("Blue Horizon");

        System.out.println("Lyrics for Blue Horizon:");
        System.out.println(lyrics);


        System.out.println("\n----- All Tracks -----");

        for (String track : trackList.keySet()) {
            System.out.println(track + ": " + trackList.get(track));
        }

    }

}