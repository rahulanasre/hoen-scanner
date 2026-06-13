package com.skyscanner;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.ArrayList;
import java.util.List;

public class HoenScannerApplication extends Application<HoenScannerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HoenScannerApplication().run(args);
    }

    @Override
    public String getName() {
        return "hoen-scanner";
    }

    @Override
    public void initialize(final Bootstrap<HoenScannerConfiguration> bootstrap) {
        // nothing to do here
    }

    @Override
    public void run(final HoenScannerConfiguration configuration,
                    final Environment environment) {

        List<SearchResult> searchResults = new ArrayList<>();

        searchResults.add(new SearchResult("Delhi", "Taj Mahal", "HOTEL"));
        searchResults.add(new SearchResult("Delhi", "Red Fort", "ATTRACTION"));
        searchResults.add(new SearchResult("Mumbai", "Gateway of India", "ATTRACTION"));
        searchResults.add(new SearchResult("Mumbai", "Taj Hotel", "HOTEL"));

        environment.jersey().register(
                new SearchResource(searchResults)
        );
    }
}