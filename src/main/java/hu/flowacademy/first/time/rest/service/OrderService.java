package hu.flowacademy.first.time.rest.service;

import hu.flowacademy.first.time.rest.model.Order;
import hu.flowacademy.first.time.rest.service.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    public List<Order> orders = new ArrayList<>();

    public List<OrderDTO> toDto(List<Order> orders) {
        return orders.stream().map((order) -> {
            return toDto(order);
        })
                .collect(Collectors.toList());
    }

    private OrderDTO toDto(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setName(order.getName());
        orderDTO.setPrice(order.getPrice());
        return orderDTO;
    }


}
