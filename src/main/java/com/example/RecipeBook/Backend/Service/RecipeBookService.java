package com.example.RecipeBook.Backend.Service;

import com.example.RecipeBook.Backend.Model.Recipe;
import com.example.RecipeBook.Backend.Repository.RecipeBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeBookService {

    @Autowired
    RecipeBookRepository recipeBookRepository;

    //Create



    //Read

    public List<Recipe> getAllRecipes () {
        return recipeBookRepository.getAllRecipes();
    }

    //Update



    //Delete



}
