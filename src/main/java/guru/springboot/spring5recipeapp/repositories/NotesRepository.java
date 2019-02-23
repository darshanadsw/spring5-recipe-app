package guru.springboot.spring5recipeapp.repositories;

import guru.springboot.spring5recipeapp.domain.Notes;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Darshana Welikala on 2019-02-21.
 */
public interface NotesRepository extends CrudRepository<Notes, Long> {
}
