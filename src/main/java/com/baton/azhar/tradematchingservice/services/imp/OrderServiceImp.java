package com.baton.azhar.tradematchingservice.services.imp;

import com.baton.azhar.tradematchingservice.exceptions.InvalidInputException;
import com.baton.azhar.tradematchingservice.model.Order;
import com.baton.azhar.tradematchingservice.services.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @JmsListener(destination = "${orders.inputQueue}")
    public void listenOrders(String message) {
        logger.info("{} recieved from orders.inputQueue", message);
        try {
            processMessage(message);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public Order processMessage(String message) throws Exception {
        Order order = null;
        try {
            order = objectMapper.readValue(message, Order.class);
            //store order to database
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new InvalidInputException("invalid input while listening to orders", illegalArgumentException);
        } catch (JsonProcessingException jsonProcessingException) {
            throw new InvalidInputException("invalid input while listening to orders", jsonProcessingException);
        }
        return order;
    }
}
