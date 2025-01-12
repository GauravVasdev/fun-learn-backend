package org.example.clients;

import org.example.http.response.custom.GetAllOrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "catalog-service", url = "http://localhost:8083")
public interface ICatalogapi {

    @GetMapping("/order/get/all-order")
    List<GetAllOrderResponse> getAllOrders();
}
