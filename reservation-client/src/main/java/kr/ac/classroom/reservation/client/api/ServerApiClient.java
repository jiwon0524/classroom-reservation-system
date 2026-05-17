package kr.ac.classroom.reservation.client.api;

import kr.ac.classroom.reservation.common.protocol.ApiPaths;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public final class ServerApiClient {
    private final URI baseUri;
    private final HttpClient httpClient;

    public ServerApiClient(URI baseUri) {
        this.baseUri = baseUri;
        this.httpClient = HttpClient.newHttpClient();
    }

    public String health() throws IOException, InterruptedException {
        return get(ApiPaths.HEALTH);
    }

    public String classrooms() throws IOException, InterruptedException {
        return get(ApiPaths.CLASSROOMS);
    }

    public String reservations() throws IOException, InterruptedException {
        return get(ApiPaths.RESERVATIONS);
    }

    private String get(String path) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(baseUri.resolve(path)).GET().build();
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }
}
