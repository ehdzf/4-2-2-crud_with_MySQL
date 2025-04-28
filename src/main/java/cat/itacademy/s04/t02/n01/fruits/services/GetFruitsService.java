package cat.itacademy.s04.t02.n01.fruits.services;

import cat.itacademy.s04.t02.n01.fruits.Fruit;
import cat.itacademy.s04.t02.n01.fruits.FruitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetFruitsService {
    private final FruitsRepository fruitsRepository;

    @Autowired
    public GetFruitsService(FruitsRepository fruitsRepository) {
        this.fruitsRepository = fruitsRepository;
    }
    public List<Fruit> findAll() {
        return fruitsRepository.findAll();
    }
}
