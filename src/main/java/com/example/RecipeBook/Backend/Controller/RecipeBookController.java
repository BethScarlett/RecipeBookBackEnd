package com.example.RecipeBook.Backend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeBookController {

    //CREATE



    //READ

    @GetMapping("/recipes")
    public String getAllRecipes () {
        return "These are the recipes";
    }

    //UPDATE



    //DELETE



}
