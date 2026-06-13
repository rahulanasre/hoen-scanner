package com.skyscanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Path("/hotels")
@Produces(MediaType.APPLICATION_JSON)
public class HotelResource {

    @GET
    public String getHotels() throws Exception {
        InputStream is = getClass().getClassLoader()
                .getResourceAsStream("hotels.json");

        if (is == null) {
            return "{\"error\": \"hotels.json not found\"}";
        }

        return new String(is.readAllBytes(), StandardCharsets.UTF_8);
    }
}
