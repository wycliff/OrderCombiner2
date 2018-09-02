package com.ordercombiner.client;

import com.ordercombiner.model.DirectionResponse;
import java.io.IOException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public class DistanceMatrixClient {

    private static final String BASE_URI = "https://maps.googleapis.com/maps/api";
    private static final String API_KEY = "AIzaSyCQB6hAaF8KyG9CZ-mOpCN_5UPbw3iqwqE";  // 
    
    /**
     * end point for read distanceMatrix
     */
    private WebTarget distanceMatrix;

    
    public DistanceMatrixClient() {
        Client client = LazySingleton.getClient();
        distanceMatrix = client.target(BASE_URI + "/distancematrix");

    }
    
    
    public DirectionResponse getDirectionInfo(String origins, String destinations) throws IOException {
        return distanceMatrix.path("/json")
                .queryParam("units", "metric")
                .queryParam("origins", origins)
                .queryParam("destinations", destinations)
                .queryParam("key", API_KEY)
                .request()
                .get()
                .readEntity(DirectionResponse.class);
    }
    
    
      // Distance using the Distance Matrix API.
    public  double distanceGetter(double lat1 , double lon1, double lat2,
        double lon2) throws IOException{
        String origin, destination;
        Double distance;
            DistanceMatrixClient dc = new DistanceMatrixClient();
            origin = Double.toString(lat1)+","+Double.toString(lon1);
            destination = Double.toString(lat1)+","+Double.toString(lon1);

            DirectionResponse direction = dc.getDirectionInfo(origin, destination);

            //Distance in kilometres
            distance = Double.parseDouble(direction.getRows().get(0).getElements().get(0).getDistance().getValue())/1000;

    return distance;
    }
    
    
//    public static void main(String[] args) throws IOException {
//        DistanceMatrixClient wc = new DistanceMatrixClient();
//        //DirectionResponse direction = wc.getDirectionInfo("Vaidavas 6/3", "Domina Shopping"); // Can give lat long instead 
//        DirectionResponse direction = wc.getDirectionInfo("44.928046,-94.410307", "33.695787,-116.359998");
//              
//        //System.out.println("Duration in hours :"+direction.getRows().get(0).getElements().get(0).getDuration().getText());
//        System.out.println("Distance  in metr : "+direction.getRows().get(0).getElements().get(0).getDistance().getValue()); //perfect
//    }
}
