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


    @Setter @ManyToOne(optional = false) @JoinColumn(name = "userId") private UserAccount userAccount;
    @Setter @OneToMany private List<Stock> StockList;

    @Setter @ManyToOne(optional = false) private Weights weights;


    protected PortFolio() {
    }

    public PortFolio(List<Stock> stockList, Weights weights) {
        StockList = stockList;
        this.weights = weights;
    }

    public PortFolio(UserAccount userAccount, List<Stock> stockList, Weights weights) {
        this.userAccount = userAccount;
        StockList = stockList;
        this.weights = weights;
    }

    public static PortFolio of(List<Stock> stockList, Weights weights)
    {
        return new PortFolio(stockList, weights);
    }

    public static PortFolio of(UserAccount userAccount, List<Stock> stockList, Weights weights)
    {
        return new PortFolio(userAccount, stockList, weights);
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
