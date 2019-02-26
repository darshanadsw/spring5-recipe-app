package guru.springboot.spring5recipeapp.bootstrap;

import guru.springboot.spring5recipeapp.domain.Notes;
import guru.springboot.spring5recipeapp.domain.Recipe;
import guru.springboot.spring5recipeapp.repositories.NotesRepository;
import guru.springboot.spring5recipeapp.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Darshana Welikala on 2019-02-21.
 */
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final NotesRepository notesRepository;
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeBootstrap(NotesRepository notesRepository, RecipeRepository recipeRepository) {
        this.notesRepository = notesRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Recipe recipe = new Recipe();
        recipe.setCookTime(20);
        recipe.setDescription("Recipe");
        recipe.setDirections("Direction");
        recipe.setPrepTime(10);
        recipe.setServings(221);
        recipe.setSource("Source");
        recipe.setUrl("Url");
        recipe.setImage(new Byte[]{});

        Notes notes = new Notes();
        notes.setRecipeNotes("Recipe Notes");

        notes.setRecipe(recipe);
        recipe.setNotes(notes);

        recipeRepository.save(recipe);
    }
}
