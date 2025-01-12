package org.example.service;

import org.example.http.response.GetAllOrderResponse;

import java.util.List;

public interface ICatalogService {
    List<GetAllOrderResponse> getAllOrders();
}
