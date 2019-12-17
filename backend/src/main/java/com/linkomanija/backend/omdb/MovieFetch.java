package com.linkomanija.backend.omdb;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class MovieFetch {
  @Value("${omdb.api-key}")
  private static String apiKey;

  private static final String url = "http://www.omdbapi.com";
  private static final String charset = "UTF-8";

  public static ImdbMovie findMovieByCode(String imdb_code) throws IOException, ParseException {
    InputStream response = getResponse(imdb_code);
    int a = response.available();
    return parseResponse(response);
  }

  private static InputStream getResponse(String imdb_code) throws IOException {
    String query = String.format("i=%s&apikey=%s",
      URLEncoder.encode(imdb_code, charset),
      URLEncoder.encode("9edbd840", charset));

    URLConnection connection = new URL(url + "?" + query).openConnection();
    connection.setRequestProperty("Accept-Charset", charset);
    return connection.getInputStream();
  }

  private static ImdbMovie parseResponse(InputStream response) throws IOException, ParseException {
    ObjectMapper mapper = new ObjectMapper();
    Map jsonMap = mapper.readValue(response, Map.class);

    String poster_url = String.valueOf(jsonMap.get("Poster"));
    int movie_length = Integer.parseInt(String.valueOf(jsonMap.get("Runtime")).split(" ")[0]);
    String creation_country = String.valueOf(jsonMap.get("Country"));

    SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
    Date release_date = formatter.parse(String.valueOf(jsonMap.get("Released")));

    String actor_list = String.valueOf(jsonMap.get("Actors"));
    String director_list = String.valueOf(jsonMap.get("Director"));
    String writer_list = String.valueOf(jsonMap.get("Writer"));

    double imdb_rating = Double.parseDouble(String.valueOf(jsonMap.get("imdbRating")));
    return new ImdbMovie(actor_list, director_list, writer_list, poster_url, movie_length, creation_country, release_date, imdb_rating);
  }
}
