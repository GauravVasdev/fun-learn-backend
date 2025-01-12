package org.example.clients;

import org.example.constant.UserServiceConstants;
import org.example.http.response.custom.GetAllOrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "${service.catalog.name}", url = "${service.catalog.url}")
public interface ICatalogapi {

    @GetMapping(UserServiceConstants.ORDER_BASE_URL + UserServiceConstants.GET_ALL_ORDER)
    List<GetAllOrderResponse> getAllOrders();
}
