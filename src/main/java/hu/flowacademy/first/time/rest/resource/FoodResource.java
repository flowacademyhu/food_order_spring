package hu.flowacademy.first.time.rest.resource;

import hu.flowacademy.first.time.rest.service.FoodService;
import hu.flowacademy.first.time.rest.service.dto.FoodDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodResource {

    private final FoodService foodService;

    public FoodResource(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/")
    public ResponseEntity<List<FoodDTO>> findAll() {
        return ResponseEntity.ok(foodService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<FoodDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.findOne(id));
    }

    @PostMapping("/")
    public ResponseEntity<FoodDTO> save(@RequestBody FoodDTO foodDTO) {
        return ResponseEntity.ok(foodService.save(foodDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        foodService.delete(id);
        return ResponseEntity.ok().build();
    }

}
