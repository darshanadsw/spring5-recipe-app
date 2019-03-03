package guru.springboot.spring5recipeapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Darshana Welikala on 2019-02-21.
 */
@Data
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

}
