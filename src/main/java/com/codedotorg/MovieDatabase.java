package com.codedotorg;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class MovieDatabase {
    
    public static JSONArray retrieveData() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
            .url("https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1")
            .get()
            .addHeader("accept", "application/json")
            .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjMDY0NzJiYjQ4NDg5NGM2MTFiOWVmYmI0YTcxMjFlMiIsInN1YiI6IjY0OTFkMWFlYzJmZjNkMDBlMmUyMzE2YSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.pWzZsB2oK7-JIW9xr1xNCI-GRTgzLGFJwTEVRcHbx4U")
            .build();
        
        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            JSONObject json = new JSONObject(responseBody);
            JSONArray results = json.getJSONArray("results");
            return results;
        } catch (Exception e) {
            System.out.println("Error connecting to movie database");
        }

        return null;
    }

    public static ArrayList<Movie> createMovieList() {
        JSONArray movieResults = retrieveData();
        ArrayList<Movie> tempMovieList = new ArrayList<Movie>();

        for (int index = 0; index < movieResults.length(); index++) {
            JSONObject movie = movieResults.getJSONObject(index);
            
            if (movie.getString("original_language").equals("en")) {
                String title = movie.getString("original_title");
                
                String releaseDate = movie.getString("release_date");
                releaseDate = releaseDate.substring(0, releaseDate.indexOf("-"));
                int year = Integer.parseInt(releaseDate);

                tempMovieList.add(new Movie(title, year));
            }
        }

        return tempMovieList;
    }

}
