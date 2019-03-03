package guru.springboot.spring5recipeapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Darshana Welikala on 2019-02-22.
 */
@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}
