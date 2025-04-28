package cat.itacademy.s04.t02.n01.fruits;

import cat.itacademy.s04.t02.n01.fruits.services.CreateFruitService;
import cat.itacademy.s04.t02.n01.fruits.services.GetFruitByIdService;
import cat.itacademy.s04.t02.n01.fruits.services.GetFruitsService;
import cat.itacademy.s04.t02.n01.fruits.services.UpdateFruitByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitsController {
    private final GetFruitsService getFruitsService;
    private final CreateFruitService createFruitService;
    private final GetFruitByIdService getFruitByIdService;
    private final UpdateFruitByIdService updateFruitByIdService;
    @Autowired
    public FruitsController(GetFruitsService getFruitsService, CreateFruitService createFruitService, GetFruitByIdService getFruitByIdService, UpdateFruitByIdService updateFruitByIdService) {
        this.getFruitsService = getFruitsService;
        this.createFruitService = createFruitService;
        this.getFruitByIdService = getFruitByIdService;
        this.updateFruitByIdService = updateFruitByIdService;
    }

    @GetMapping
    public ResponseEntity<List<Fruit>> getFruits() {
        return new ResponseEntity<>(getFruitsService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Fruit> createFruit(@RequestBody Fruit fruit) {
        return new ResponseEntity<>(createFruitService.createFruit(fruit), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Fruit> getFruit(@PathVariable Long id) {

        return new ResponseEntity<>(getFruitByIdService.getFruitById(id), HttpStatus.OK);

    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Void> updateFruit(@PathVariable Long id, @RequestBody Fruit fruit) {
            updateFruitByIdService.updateFruitById(id, fruit);
            return new ResponseEntity<>(HttpStatus.OK);


    }
}
