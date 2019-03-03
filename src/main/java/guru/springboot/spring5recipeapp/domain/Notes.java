package guru.springboot.spring5recipeapp.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Darshana Welikala on 2019-02-21.
 */
@Data
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNotes;

    public Notes() {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Notes;
    }

}
