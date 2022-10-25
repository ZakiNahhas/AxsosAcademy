import java.util.Set;
import java.util.HashMap;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("My Immortal", "I'm so tired of being here");
        trackList.put("Bring Me to Life", "Wake me up inside");
        trackList.put("Party Monster", "I'm good, I'm good, I'm great");
        trackList.put("Everything I own", "I would give everything I own");
        String trackName = trackList.get("My Immortal");
        System.out.println(trackName);
        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.print(" Track: " + key + " -- ");
            System.out.print(" Lyrics: " + trackList.get(key) + " || ");    
        }
    }
}
