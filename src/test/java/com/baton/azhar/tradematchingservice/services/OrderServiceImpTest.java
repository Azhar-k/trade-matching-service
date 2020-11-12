package com.baton.azhar.tradematchingservice.services;

import com.baton.azhar.tradematchingservice.exceptions.InvalidInputException;
import com.baton.azhar.tradematchingservice.model.Order;
import com.baton.azhar.tradematchingservice.services.imp.OrderServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderServiceImpTest {
    @InjectMocks
    OrderServiceImp orderServiceImp;

    @Test
    public void processMessageTestValid() throws Exception {
        String input = "{\"party\" : \"A\",\"stock\" : \"IBM\",\"type\" : \"sell\",\"price\" : 110}";
        Order expected = new Order("A", "IBM", "sell", 110);
        Order actual = orderServiceImp.processMessage(input);
        assertAll(() -> {
            assertEquals(expected.getParty(), actual.getParty());
            assertEquals(expected.getStock(), actual.getStock());
            assertEquals(expected.getType(), actual.getType());
            assertEquals(expected.getPrice(), actual.getPrice());
            assertEquals(expected.getStatus(), actual.getStatus());
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void processMessageTestInvalid(String input) {
        InvalidInputException actual = assertThrows(InvalidInputException.class, () -> {
            orderServiceImp.processMessage(input);
        });
        assertEquals("invalid input while listening to orders",actual.getMessage());
    }
}
