package gachon.jupoza.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@ToString(callSuper = true)
@Entity
public class PortFolio extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @OneToMany
    private List<Stock> StockList = new ArrayList<>();

    @Setter @ManyToOne(optional = false) private weights weights;


    protected PortFolio() {
    }

    public PortFolio(List<Stock> stockList, weights weights) {
        StockList = stockList;
        this.weights = weights;
    }

    public static PortFolio of(ArrayList<Stock> stockList, weights weights)
    {
        return new PortFolio(stockList, weights);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PortFolio)) return false;
        PortFolio portFolio = (PortFolio) o;
        return Objects.equals(id, portFolio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
