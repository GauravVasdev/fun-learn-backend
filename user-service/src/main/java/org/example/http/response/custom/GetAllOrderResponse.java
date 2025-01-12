package org.example.http.response.custom;

public record GetAllOrderResponse(int orderId, String itemName, String itemCategory, String itemDescription) {
}
