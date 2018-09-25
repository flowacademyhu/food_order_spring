package hu.flowacademy.first.time.rest.model;

import javax.persistence.*;

@Entity
@Table(name = "other_food_data")
public class OtherFoodData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String data;

    @OneToOne(mappedBy = "otherFoodData")
    private Food food;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
