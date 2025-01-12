package org.example.service.impl;

import org.example.http.response.GetAllOrderResponse;
import org.example.model.Orders;
import org.example.repository.ICatalogRepository;
import org.example.service.ICatalogService;
import org.example.service.mapper.ICatalogServiceMapper;

import java.util.List;

public class CatalogServiceImpl implements ICatalogService {

    private final ICatalogRepository catalogRepository;
    private final ICatalogServiceMapper catalogServiceMapper;

    public CatalogServiceImpl(ICatalogRepository catalogRepository, ICatalogServiceMapper catalogServiceMapper) {
        this.catalogRepository = catalogRepository;
        this.catalogServiceMapper = catalogServiceMapper;
    }


    @Override
    public List<GetAllOrderResponse> getAllOrders() {
        List<Orders> orders = catalogRepository.findAll();
        return catalogServiceMapper.mapListOfOrdersToGetAllOrderResponse(orders);
    }
}
