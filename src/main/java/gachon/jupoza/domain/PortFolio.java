package gachon.jupoza.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Entity
@ToString(callSuper = true)
@Transactional
public class PortFolio extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PortFolio_id")
    private Long id;

    @Setter @ManyToOne(optional = false) @JoinColumn(name = "userId")  private UserAccount userAccount;

    @JsonManagedReference
    @Setter
    @OneToMany(mappedBy = "portFolio", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<MyStock> myStockList = new ArrayList<>();


    protected PortFolio() {
    }

    public PortFolio(UserAccount userAccount, List<MyStock> myStockList) {
        this.userAccount = userAccount;
        this.myStockList = myStockList;
    }

    public static PortFolio of(UserAccount userAccount, List<MyStock> myStockList) {
        return new PortFolio(userAccount, myStockList);
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

