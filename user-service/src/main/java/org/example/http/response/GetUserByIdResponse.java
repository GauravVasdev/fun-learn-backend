package org.example.http.response;

public record GetUserByIdResponse(Integer id, String username, String password, String email) {
}
