package be.vdab.muziek;

import java.util.Arrays;


record Release(long id, int year, String title, String [] artists) {
    Release (ReleaseResponse response){
        this(response.id(),
                response.year(),
                response.title(),
                Arrays.stream(response.artists()).map(Artist::name).toArray(String[]::new));
    }
}
