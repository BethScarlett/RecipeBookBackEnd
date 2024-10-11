package com.example.RecipeBook.Backend.Repository;

import com.example.RecipeBook.Backend.Model.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StepRepository extends JpaRepository<Step, Long> {

    @Query(value = "SELECT * FROM recipe_book.step WHERE recipe_id = ?1", nativeQuery = true)
    List<Step> getAllSteps(long recipe_id);

    @Query(value = "SELECT id FROM recipe_book.step WHERE recipe_id = ?1", nativeQuery = true)
    List<Long> getAllIds(long recipe_id);

    void deleteStepById(long id);
}
