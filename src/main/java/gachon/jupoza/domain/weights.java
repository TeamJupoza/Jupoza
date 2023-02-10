package gachon.jupoza.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@ToString
@Entity
public class weights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Column(nullable = false)
    private float weight1;

    @Setter @Column(nullable = false)
    private float weight2;

    @Setter @Column(nullable = false)
    private float weight3;

    @Setter @Column(nullable = false)
    private float weight4;

    @Setter @Column(nullable = false)
    private float weight5;

    private weights(float weight1, float weight2, float weight3, float weight4, float weight5) {
        this.weight1 = weight1;
        this.weight2 = weight2;
        this.weight3 = weight3;
        this.weight4 = weight4;
        this.weight5 = weight5;
    }

    public weights() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof weights)) return false;
        weights weights = (weights) o;
        return Objects.equals(id, weights.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
