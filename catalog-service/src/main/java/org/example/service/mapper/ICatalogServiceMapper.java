package org.example.service.mapper;

import org.example.http.response.GetAllOrderResponse;
import org.example.model.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICatalogServiceMapper {

    @Mapping(target = "orderId", source = "id")
    GetAllOrderResponse mapOrdersToGetAllOrderResponseResponse(Orders orders);

    List<GetAllOrderResponse> mapListOfOrdersToGetAllOrderResponse(List<Orders> orders);
}
