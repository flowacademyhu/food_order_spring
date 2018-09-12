package hu.flowacademy.first.time.rest.resource;

import hu.flowacademy.first.time.rest.service.OrderService;
import hu.flowacademy.first.time.rest.service.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public List<OrderDTO> findAll() {
        return orderService.toDto(orderService.orders);
    }

}
