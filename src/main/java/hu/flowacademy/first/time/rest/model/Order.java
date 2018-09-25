package hu.flowacademy.first.time.rest.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    // a cascade fogja elmenteni a listaban levo elemeket
    @ManyToMany(cascade = CascadeType.ALL)
    // az inverseJoinColumn jelzi, hogy a sajat id-k oszlopat
    // a joinColumns pedig a masik entitas id-jeit tartalmazo oszlopot
    @JoinTable(
            inverseJoinColumns =
        @JoinColumn(name = "order_id"),
            joinColumns =
        @JoinColumn(name = "food_id")
    )
    private List<Food> foods;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
