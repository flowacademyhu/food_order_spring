package hu.flowacademy.first.time.rest.repository;

import hu.flowacademy.first.time.rest.model.Food;
import hu.flowacademy.first.time.rest.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findByName(String name);
    // select f from Food f where f.name = ?1

//    @Query(value = "select * from product_order ", nativeQuery = true)
//    List<Order> getProductOrders();

}
