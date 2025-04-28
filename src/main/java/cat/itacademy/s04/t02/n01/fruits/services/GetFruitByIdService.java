package cat.itacademy.s04.t02.n01.fruits.services;

import cat.itacademy.s04.t02.n01.fruits.Fruit;
import cat.itacademy.s04.t02.n01.fruits.FruitsRepository;
import cat.itacademy.s04.t02.n01.fruits.exceptions.FruitNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetFruitByIdService {
    private final FruitsRepository fruitsRepository;

    @Autowired
    public GetFruitByIdService(FruitsRepository fruitsRepository) {
        this.fruitsRepository = fruitsRepository;
    }

    public Fruit getFruitById(Long id)  {
        Optional<Fruit> fruit = fruitsRepository.findById(id);
        if (fruit.isEmpty()){
            throw new FruitNotFoundException("Fruit with id " + id + " not found");
        }
        return fruit.get();
    }
}
