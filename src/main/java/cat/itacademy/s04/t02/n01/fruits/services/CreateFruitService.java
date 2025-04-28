package cat.itacademy.s04.t02.n01.fruits.services;

import cat.itacademy.s04.t02.n01.fruits.Fruit;
import cat.itacademy.s04.t02.n01.fruits.FruitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateFruitService {
    private final FruitsRepository fruitsRepository;

    @Autowired
    public CreateFruitService(FruitsRepository fruitsRepository) {
        this.fruitsRepository = fruitsRepository;
    }
    public Fruit createFruit(Fruit fruit) {
        return fruitsRepository.save(fruit);
    }
}
