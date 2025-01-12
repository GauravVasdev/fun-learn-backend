package org.example.http.controller;

import org.example.constant.CatalogServiceConstants;
import org.example.http.response.GetAllOrderResponse;
import org.example.service.ICatalogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(CatalogServiceConstants.ORDER_BASE_URL)
public class CatalogApiController {

    private final ICatalogService catalogService;

    public CatalogApiController(ICatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping(CatalogServiceConstants.GET_ALL_ORDER)
    public ResponseEntity<List<GetAllOrderResponse>> getAllOrders(){
        List<GetAllOrderResponse> orders = catalogService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
