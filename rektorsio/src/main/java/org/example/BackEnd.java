package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BackEnd {
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
    public String wow(String search, String url) {
        System.out.println("getDataByVatNumber CALLED param:" + search);

        //String result;//= sendPost(vatNumber);
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String FullResponse = response.body();

        return FullResponse;
    }

    public void fun(String search, String url) {
        String variable = wow(search, url);

        String[] words = variable.split("\\s+");

        SystemServices systemServices = new SystemServices();
        FrontEnd frontEnd = new FrontEnd();

        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            if (word.contains(search)) {
                System.out.println("Találat: " + word);

                stringBuilder.append(word);

                systemServices.SystemMessage();
                systemServices.SystemAlarm();
                break;
            }
        }
        frontEnd.FoundedItem(stringBuilder.toString());
    }
}
