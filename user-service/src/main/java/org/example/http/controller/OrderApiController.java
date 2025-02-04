package org.example.http.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.example.constant.UserServiceConstants;
import org.example.http.response.custom.GetAllOrderResponse;
import org.example.service.IUserService;
import org.slf4j.ILoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(UserServiceConstants.USER_BASE_URL + UserServiceConstants.ORDER_BASE_URL)
public class OrderApiController {

    private final IUserService userService;

    public OrderApiController(IUserService userService) {
        this.userService = userService;
    }

    int retryCountDebug = 0;

    @GetMapping(UserServiceConstants.GET_ALL_ORDER)
    //@CircuitBreaker(name = UserServiceConstants.USER_SERVICE_INSTANCE_NAME_CK, fallbackMethod = UserServiceConstants.GET_ALL_ORDER_FALLBACK_METHOD_NAME_CK)
    //@Retry(name = UserServiceConstants.USER_SERVICE_INSTANCE_NAME_CK, fallbackMethod = UserServiceConstants.GET_ALL_ORDER_FALLBACK_METHOD_NAME_CK)
    @RateLimiter(name = UserServiceConstants.USER_SERVICE_INSTANCE_NAME_CK, fallbackMethod = UserServiceConstants.GET_ALL_ORDER_FALLBACK_METHOD_NAME_CK)
    public ResponseEntity<List<GetAllOrderResponse>> getAllOrders(){
        retryCountDebug++;
        System.out.println("RetryCount Is : " + retryCountDebug);
        List<GetAllOrderResponse> orders = userService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    public ResponseEntity<List<GetAllOrderResponse>> getAllAvailableProducts(Exception e){
        List<GetAllOrderResponse> getAllOrderResponses = List.of(
                new GetAllOrderResponse(1, "testName", "testCategroy", "testDescription"));
        return new ResponseEntity<>(getAllOrderResponses, HttpStatus.OK);
    }
}
