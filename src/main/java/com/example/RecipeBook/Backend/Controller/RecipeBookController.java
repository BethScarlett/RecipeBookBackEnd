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
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipe;
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
        //TODO - Replace this with call to db
//        HashMap<Long, Recipe> testSet = new HashMap<Long, Recipe>();
//        Recipe testOne = new Recipe(1, "t", "Chicken Pot Pie", "Yummy", "Meat");
//        Recipe testTwo = new Recipe(2, "t", "Battered Fish", "Scrummy", "Meat");
//        Recipe testThree = new Recipe(3, "t", "Pea soup", "Delish", "Soup");
//        testSet.put(1L, testOne);
//        testSet.put(2L, testTwo);
//        testSet.put(3L, testThree);
//        return testSet.get(id);
        return new Recipe(1, "t", "Chicken Pot Pie", "Yummy", "Meat");
    }

    //UPDATE

    @PutMapping("/recipes/{id}")
    public Recipe updateRecipe(@RequestBody Recipe newRecipe, @PathVariable long id) {
        return newRecipe;
    }

    //DELETE

    @DeleteMapping("/recipes/{id}")
    public String deleteRecipe(@PathVariable long id) {
        return "Recipe removed at id " + id;
    }

}
