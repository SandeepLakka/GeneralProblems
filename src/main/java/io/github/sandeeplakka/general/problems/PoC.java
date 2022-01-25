package io.github.sandeeplakka.general.problems;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.sandeeplakka.general.problems.exception.NYI;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PoC {

//    public static void main(String[] args) {
//        String kolkataTime = String.format("%02d:%02d",
//                LocalTime.now().getHour(),
//                LocalTime.now().getMinute());
//        final int MINUTES_PER_LONGITUDE = 4;
//        int hydLongitude = getLongitude("Hyderabad");
//        int kolkLongitude = getLongitude("Kolkata");
//        System.out.println("Longitude at Hyderabad : " + hydLongitude);
//        System.out.println("Longitude at Kolkata : " + kolkLongitude);
//        System.out.println("Time in Kolkata : " + kolkataTime);
//        System.out.println("Adjusted time in Hyderabad : " + adjustTime(kolkataTime, MINUTES_PER_LONGITUDE * (hydLongitude - kolkLongitude)));
//    }

    public String getAdjustedTime(String currentPlace) {
        String kolkataTime = String.format("%02d:%02d",
                LocalTime.now().getHour(),
                LocalTime.now().getMinute());
        return adjustTime(kolkataTime,
                Math.abs(getLongitude(currentPlace) - getLongitude("Kolkata")));
    }

    //This has to be implemented by my friend.
    //Waiting for her to share her solution, so I can complete this whole setup :)
    private String adjustTime(String timeZoneTime, int i) {
        throw new NYI();
    }

    public int getLongitude(final String place) {

        final String API_URL = String.format("https://nominatim.openstreetmap.org/search.php?" +
                "q=%s&limit=1&format=jsonv2", place);
        HashMap<String, String> myMap = null;

        try {
            HttpURLConnection conn = (HttpURLConnection) (new URL(API_URL)).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            byte[] output;
            String outputStr = br.readLine().substring(1);
            outputStr = outputStr.substring(0, outputStr.length() - 1);
            output = outputStr.getBytes(StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            myMap = mapper.readValue(output, HashMap.class);
        } catch (IOException mue) {
            mue.printStackTrace();
        }


        assert myMap != null;
        return Integer.parseInt(myMap.get("lon").substring(0, myMap.get("lon").indexOf(".")));
    }


}
