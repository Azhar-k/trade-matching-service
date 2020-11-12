package com.baton.azhar.tradematchingservice.services;

import com.baton.azhar.tradematchingservice.exceptions.InvalidInputException;
import com.baton.azhar.tradematchingservice.model.Order;

public interface OrderService {
    public void listenOrders(String message);
}
