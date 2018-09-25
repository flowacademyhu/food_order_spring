package hu.flowacademy.first.time.rest.model;

import hu.flowacademy.first.time.rest.service.dto.FoodType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private Long price;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private FoodType foodType;

    @OneToOne
    @JoinColumn(name = "other_food_data_id")
    private OtherFoodData otherFoodData;

    // a mappedBy erteke meg kell, hogy egyezzen a
    // @ManyToOne valtozo nevevel
    @OneToMany(mappedBy = "food")
    private List<FoodComponent> foodComponent;

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public OtherFoodData getOtherFoodData() {
        return otherFoodData;
    }

    public void setOtherFoodData(OtherFoodData otherFoodData) {
        this.otherFoodData = otherFoodData;
    }

    public List<FoodComponent> getFoodComponent() {
        return foodComponent;
    }

    public void setFoodComponent(List<FoodComponent> foodComponent) {
        this.foodComponent = foodComponent;
    }
}
