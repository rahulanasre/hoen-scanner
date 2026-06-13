package com.skyscanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Path("/rental-cars")
@Produces(MediaType.APPLICATION_JSON)
public class RentalCarResourse {

    @GET
    public String getCars() throws Exception {

        InputStream is = getClass().getClassLoader()
                .getResourceAsStream("rental_cars.json");

        if (is == null) {
            return "{\"error\": \"rental_cars.json not found\"}";
        }

        return new String(is.readAllBytes(), StandardCharsets.UTF_8);
    }
}
