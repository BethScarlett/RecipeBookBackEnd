package com.example.RecipeBook.Backend.Controller;

import com.example.RecipeBook.Backend.Model.Ingredient;
import com.example.RecipeBook.Backend.Model.Recipe;
import com.example.RecipeBook.Backend.Model.Step;
import com.example.RecipeBook.Backend.Service.RecipeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class RecipeBookController {

    @Autowired
    RecipeBookService recipeBookService;

    //CREATE

    @PostMapping("/recipe")
    public Recipe createRecipe(@RequestBody Recipe newRecipe) {
        return recipeBookService.createRecipe(newRecipe);
    }

    @PostMapping("/ingredient")
    public List<Ingredient> createIngredients (@RequestBody ArrayList<Ingredient> ingredients) {
        return ingredients;
    }

    @PostMapping("/step")
    public List<Step> createSteps (@RequestBody ArrayList<Step> steps) {
        return steps;
    }

    //READ

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes () {
        return recipeBookService.getAllRecipes();
    }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipeById(@PathVariable long id) {
        return recipeBookService.getRecipeById(id);
    }

    //UPDATE

    @PutMapping("/recipes/{id}")
    public void updateRecipe(@RequestBody Recipe newRecipe, @PathVariable long id) {
        recipeBookService.updateRecipe(newRecipe, id);
    }

    //DELETE

    @DeleteMapping("/recipes/{id}")
    public String deleteRecipe(@PathVariable long id) {
        recipeBookService.deleteRecipe(id);
        return "Recipe removed at id " + id;
    }

}
