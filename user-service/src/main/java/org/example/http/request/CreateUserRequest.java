package org.example.http.request;

public record CreateUserRequest(String username, String password, String email) {
}
