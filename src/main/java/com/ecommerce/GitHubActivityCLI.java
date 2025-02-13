package com.ecommerce;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GitHubActivityCLI {

    private static final String GITHUB_API_URL = "https://api.github.com/users/";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java GitHubActivityCLI <username>");
            return;
        }

        String username = args[0];
        fetchGitHubActivity(username);
    }

    private static void fetchGitHubActivity(String username) {
        try {
            URL url = new URL(GITHUB_API_URL + username + "/events");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                parseAndDisplayActivity(response.toString());
            } else {
                System.out.println("Failed to fetch activity. HTTP Response Code: " + responseCode);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void parseAndDisplayActivity(String jsonResponse) {
        try {
            JSONArray events = new JSONArray(jsonResponse);
            System.out.println("Recent GitHub Activity:");

            for (int i = 0; i < Math.min(events.length(), 5); i++) { // Display up to 5 events
                JSONObject eventObj = events.getJSONObject(i);
                String type = eventObj.getString("type");
                JSONObject repo = eventObj.getJSONObject("repo");
                String repoName = repo.getString("name");

                System.out.println("- " + type + " in " + repoName);
            }
        } catch (Exception e) {
            System.out.println("Error parsing activity data: " + e.getMessage());
        }
    }
}

