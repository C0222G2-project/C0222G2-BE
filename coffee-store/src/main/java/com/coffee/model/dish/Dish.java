package com.coffee.model.dish;

import com.coffee.model.dish_order.DishOrder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String code;

    private String name;

    private Double price;

    @Column(columnDefinition = "text")
    private String image;

    private Date creationDate;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "dish_type_id", referencedColumnName = "id")
    private DishType dishType;

    @OneToMany(mappedBy = "dish")
    @JsonIgnore
    private List<DishOrder> dishOrders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Dish dish = (Dish) o;
        return id != null && Objects.equals(id, dish.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
