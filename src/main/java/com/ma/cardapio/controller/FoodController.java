package com.ma.cardapio.controller;

import com.ma.cardapio.food.Food;
import com.ma.cardapio.food.FoodRepository;
import com.ma.cardapio.food.FoodRequestDTO;
import com.ma.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(originPatterns = "*",allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
    }

    @CrossOrigin(originPatterns = "*",allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO>  foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();

        return foodList;
    }
}
