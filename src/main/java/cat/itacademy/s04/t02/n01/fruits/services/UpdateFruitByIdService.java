package cat.itacademy.s04.t02.n01.fruits.services;

import cat.itacademy.s04.t02.n01.fruits.Fruit;
import cat.itacademy.s04.t02.n01.fruits.FruitsRepository;
import cat.itacademy.s04.t02.n01.fruits.exceptions.FruitDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateFruitByIdService {
    private final FruitsRepository fruitsRepository;

    @Autowired
    public UpdateFruitByIdService(FruitsRepository fruitsRepository) {
        this.fruitsRepository = fruitsRepository;
    }

    public void updateFruitById(Long id, Fruit fruit) {
        final Fruit existing = getFruit(id);
        existing.setName(fruit.getName());
        existing.setQuantity(fruit.getQuantity());
        fruitsRepository.save(existing);
    }

    private Fruit getFruit(Long id) {
        Optional<Fruit> existing = fruitsRepository.findById(id);
        if (existing.isEmpty()) throw new FruitDoesNotExistException("Fruit with id " + id + " does not exist");
        return existing.get();
    }
}
