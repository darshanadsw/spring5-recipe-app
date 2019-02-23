package guru.springboot.spring5recipeapp.repositories;

import guru.springboot.spring5recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Darshana Welikala on 2019-02-23.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
