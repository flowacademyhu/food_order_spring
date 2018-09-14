package hu.flowacademy.first.time.rest.service;

import hu.flowacademy.first.time.rest.model.Food;
import hu.flowacademy.first.time.rest.repository.FoodRepository;
import hu.flowacademy.first.time.rest.service.dto.FoodDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class FoodService {

    @Autowired
    private final FoodRepository foodRepository;


    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Transactional(readOnly = true)
    public FoodDTO findOne(Long id) {
        return foodRepository.findById(id).map(this::toDto).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<FoodDTO> findAll() {
        return foodRepository.findAll().stream().map(this::toDto)
                .collect(Collectors.toList());
    }

    public FoodDTO save(FoodDTO foodDTO) {
        Food entity = toEntity(foodDTO);
        return toDto(foodRepository.save(entity));
    }

    public void delete(Long id) {
        foodRepository.deleteById(id);
    }

    public Food toEntity(FoodDTO foodDTO) {
        if (foodDTO == null) {
            return null;
        }
        Food food = new Food();
        food.setId(foodDTO.getId());
        food.setName(foodDTO.getName());
        food.setPrice(foodDTO.getPrice());
        food.setDescription(foodDTO.getDescription());
        return food;
    }

    public FoodDTO toDto(Food food) {
        if (food == null) {
            return  null;
        }
        FoodDTO foodDto = new FoodDTO();
        foodDto.setId(food.getId());
        foodDto.setName(food.getName());
        foodDto.setDescription(food.getDescription());
        foodDto.setPrice(food.getPrice());
        return foodDto;
    }

    public List<FoodDTO> toDto(List<Food> foods) {
        return foods.stream().map(this::toDto).collect(Collectors.toList());
    }

}
