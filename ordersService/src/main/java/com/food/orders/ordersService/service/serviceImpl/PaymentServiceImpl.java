package com.food.orders.ordersService.service.serviceImpl;

import com.food.orders.ordersService.service.serviceInter.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    @Override
    public Boolean isPaymentDone() {
        return false;
    }
}
