package br.com.SevenDaysOfCode.Imdb;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpConnectTimeoutException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class dayOne {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		HttpRequest request = HttpRequest.newBuilder()
				//Requisição - Conteúdo
				.GET()
				.uri(URI.create("https://imdb-api.com/en/API/SearchMovie/k_oy0vazi6/thepatriot2000"))
				.timeout(Duration.ofSeconds(10))
				.build();
		HttpClient client = HttpClient.newBuilder()
				// Execuçao - Como será executado
				.connectTimeout(Duration.ofSeconds(10))
				.build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		System.out.println(response.body());
	}
}
