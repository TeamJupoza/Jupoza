package gachon.jupoza.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Entity
@AllArgsConstructor
public class MyStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(optional = false)
    @Setter
    @JoinColumn(name = "port_folio_port_folio_id")
    private PortFolio portFolio;

    int StockId;

    float weight;


    public MyStock() {

    }

    public MyStock(int stockId, float weight) {
        StockId = stockId;
        this.weight = weight;
    }

    public static MyStock of(int stockId, float weight) {
        return new MyStock(stockId,weight);
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
