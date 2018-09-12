package hu.flowacademy.first.time.rest.service;

import hu.flowacademy.first.time.rest.model.Order;
import hu.flowacademy.first.time.rest.repository.OrderRepository;
import hu.flowacademy.first.time.rest.service.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> orders = new ArrayList<>();

    public OrderDTO save(OrderDTO orderDTO) {
        Order entity = toEntity(orderDTO);
        return toDto(orderRepository.save(entity));
    }

    public List<OrderDTO> findAll() {
        return toDto(orderRepository.findAll());
    }

    public OrderDTO findOne(Long id) {
        return orderRepository.findById(id)
                .map(this::toDto).orElse(null);
    }

    public List<OrderDTO> toDto(List<Order> orders) {
        return orders.stream().map((order) -> {
            return toDto(order);
        })
                .collect(Collectors.toList());
    }

    private OrderDTO toDto(Order order) {
        if (order == null) {
            return null;
        }
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setName(order.getName());
        orderDTO.setPrice(order.getPrice());
        return orderDTO;
    }

    private Order toEntity(OrderDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setName(orderDTO.getName());
        order.setPrice(orderDTO.getPrice());
        return order;
    }


}
