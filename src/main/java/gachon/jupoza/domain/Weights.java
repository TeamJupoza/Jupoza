package gachon.jupoza.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@ToString
@Entity
public class Weights {

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

    private Weights(float weight1, float weight2, float weight3, float weight4, float weight5) {
        this.weight1 = weight1;
        this.weight2 = weight2;
        this.weight3 = weight3;
        this.weight4 = weight4;
        this.weight5 = weight5;
    }

    public Weights(Long id, float weight1, float weight2, float weight3, float weight4, float weight5) {
        this.id = id;
        this.weight1 = weight1;
        this.weight2 = weight2;
        this.weight3 = weight3;
        this.weight4 = weight4;
        this.weight5 = weight5;
    }

    public Weights() {
    }

    public static Weights of(float weight1, float weight2, float weight3, float weight4, float weight5)
    {
        return new Weights(weight1,weight2,weight3,weight4,weight5);
    }

    public static Weights of(Long id, float weight1, float weight2, float weight3, float weight4, float weight5)
    {
        return new Weights(id,weight1,weight2,weight3,weight4,weight5);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weights)) return false;
        Weights weights = (Weights) o;
        return Objects.equals(id, weights.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
