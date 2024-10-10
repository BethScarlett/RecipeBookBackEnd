package com.example.RecipeBook.Backend.Model;

import jakarta.persistence.*;

@Entity
public class Step {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String step;
    private int step_number;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public int getStep_number() {
        return step_number;
    }

    public void setStep_number(int step_number) {
        this.step_number = step_number;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Step{" +
                "id=" + id +
                ", step='" + step + '\'' +
                ", step_number=" + step_number +
                ", recipe=" + recipe +
                '}';
    }
}
