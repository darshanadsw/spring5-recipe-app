package guru.springboot.spring5recipeapp.bootstrap;

import guru.springboot.spring5recipeapp.domain.*;
import guru.springboot.spring5recipeapp.repositories.CategoryRepository;
import guru.springboot.spring5recipeapp.repositories.NotesRepository;
import guru.springboot.spring5recipeapp.repositories.RecipeRepository;
import guru.springboot.spring5recipeapp.repositories.UnitOfMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Darshana Welikala on 2019-02-21.
 */
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final NotesRepository notesRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasurementRepository unitOfMeasurementRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public RecipeBootstrap(NotesRepository notesRepository, RecipeRepository recipeRepository, UnitOfMeasurementRepository unitOfMeasurementRepository, CategoryRepository categoryRepository) {
        this.notesRepository = notesRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasurementRepository = unitOfMeasurementRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Recipe recipe = new Recipe();
        recipe.setCookTime(20);
        recipe.setDescription("Perfect Guacamole");
        recipe.setDirections("Direction");
        recipe.setPrepTime(10);
        recipe.setServings(221);
        recipe.setSource("Internet");
        recipe.setUrl("www.simplyrecipes.com");
        recipe.setImage(new Byte[]{});
        recipe.setDifficulty(Difficulty.HARD);

        Notes notes = new Notes();
        notes.setRecipeNotes("Perfect Guacamole Recipe Notes");

        notes.setRecipe(recipe);
        recipe.setNotes(notes);

        Set<Ingredient> ingredients = new HashSet<>();
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setAmount(new BigDecimal(2));
        ingredient1.setUom(unitOfMeasurementRepository.findByDescription("Pinch").get());
        ingredient1.setDescription("Ripe avocados");
        ingredient1.setRecipe(recipe);
        ingredients.add(ingredient1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setAmount(new BigDecimal(0.5));
        ingredient2.setUom(unitOfMeasurementRepository.findByDescription("Teaspoon").get());
        ingredient2.setDescription("Kosher salt");
        ingredient2.setRecipe(recipe);
        ingredients.add(ingredient2);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setAmount(new BigDecimal(1));
        ingredient3.setUom(unitOfMeasurementRepository.findByDescription("TableSpoon").get());
        ingredient3.setDescription("fresh lime juice or lemon juice");
        ingredient3.setRecipe(recipe);
        ingredients.add(ingredient3);

        Ingredient ingredient4 = new Ingredient();
        ingredient4.setAmount(new BigDecimal(0.25));
        ingredient4.setUom(unitOfMeasurementRepository.findByDescription("Cup").get());
        ingredient4.setDescription("minced red onion or thinly sliced green onion");
        ingredient4.setRecipe(recipe);
        ingredients.add(ingredient4);

        Ingredient ingredient5 = new Ingredient();
        ingredient5.setAmount(new BigDecimal(1));
        ingredient5.setUom(unitOfMeasurementRepository.findByDescription("Pinch").get());
        ingredient5.setDescription("serrano chiles, stems and seeds removed, minced");
        ingredient5.setRecipe(recipe);
        ingredients.add(ingredient5);

        recipe.setIngredients(ingredients);
        Set<Category> categories = new HashSet<>();
        Category category1 = categoryRepository.findByDescription("American").get();
        //ategory1.getRecipes().add(recipe);

        Category category2 = categoryRepository.findByDescription("Mexican").get();
        //category2.getRecipes().add(recipe);
        categories.add(category1);
        categories.add(category2);
        recipe.setCategories(categories);

        recipeRepository.save(recipe);
    }
}
