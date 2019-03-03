package guru.springboot.spring5recipeapp.controllers;

import guru.springboot.spring5recipeapp.domain.Category;
import guru.springboot.spring5recipeapp.repositories.CategoryRepository;
import guru.springboot.spring5recipeapp.repositories.RecipeRepository;
import guru.springboot.spring5recipeapp.repositories.UnitOfMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by Darshana Welikala on 2019-02-17.
 */
@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasurementRepository unitOfMeasurementRepository;
    private final RecipeRepository recipeRepository;

    @Autowired
    public IndexController(CategoryRepository categoryRepository, UnitOfMeasurementRepository unitOfMeasurementRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasurementRepository = unitOfMeasurementRepository;
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        Optional<Category> category = categoryRepository.findByDescription("Canadian");
        System.out.println(category.get().getDescription());
        System.out.println(unitOfMeasurementRepository.findByDescription("Teaspoon").get().getId());
        model.addAttribute("recipes", recipeRepository.findAll());
        return "index";
    }

}
