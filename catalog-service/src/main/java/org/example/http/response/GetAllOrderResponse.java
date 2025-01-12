package org.example.http.response;

public record GetAllOrderResponse(int orderId, String itemName, String itemCategory, String itemDescription) {
}
