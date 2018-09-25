package hu.flowacademy.first.time.rest.model;

import javax.persistence.*;

@Entity
@Table
public class FoodComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // JoinColumn azert kell, hogy a db-ben,
    // letrejojjon a kapcsolat szamara az oszlop
    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
