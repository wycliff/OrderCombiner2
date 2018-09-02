package com.apartmentnotification.client;

import com.apartmentnotification.model.DirectionResponse;
import java.io.IOException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public class ApartmentClient {

    private static final String BASE_URI = "https://maps.googleapis.com/maps/api";
    private static final String API_KEY = "AIzaSyCXnwOwrv_Kt7bkbO5vXtpPelu08yp-3iY";

    /**
     * end point for read distanceMatrix
     */
    private WebTarget distanceMatrix;

    public ApartmentClient() {
        Client client = LazySingleton.getClient();
        distanceMatrix = client.target(BASE_URI + "/distancematrix");

    }

    public DirectionResponse getDirectionInfo(String origins, String destionations) throws IOException {
        return distanceMatrix.path("/json")
                .queryParam("units", "imperial")
                .queryParam("origins", origins)
                .queryParam("destinations", destionations)
                .queryParam("key", API_KEY)
                .request()
                .get()
                .readEntity(DirectionResponse.class);
    }
    
    public static void main(String[] args) throws IOException {
        ApartmentClient wc = new ApartmentClient();
        DirectionResponse direction = wc.getDirectionInfo("Vaidavas 6/3", "Domina Shopping");
        System.out.println("Duration in hours :"+direction.getRows().get(0).getElements().get(0).getDuration().getText());
        System.out.println("Distance  in metr : "+direction.getRows().get(0).getElements().get(0).getDistance().getValue());
    }
}
