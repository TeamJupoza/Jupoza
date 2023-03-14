package gachon.jupoza.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Entity
@AllArgsConstructor
@DynamicUpdate
public class MyStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JsonBackReference
    @Setter
    private PortFolio portFolio;

    int StockId;

    float weight;

    @Setter
    String userId;
    public MyStock() {

    }

    public MyStock(int stockId, float weight) {
        StockId = stockId;
        this.weight = weight;
    }

    public static MyStock of(int stockId, float weight) {
        return new MyStock(stockId,weight);
    }

    public MyStock(int stockId, float weight, String userId) {
        StockId = stockId;
        this.weight = weight;
        this.userId = userId;
    }
    public static MyStock of(int stockId, float weight, String UserId) {
        return new MyStock(stockId,weight,UserId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyStock)) return false;
        MyStock myStock = (MyStock) o;
        return id.equals(myStock.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
