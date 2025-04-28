package cat.itacademy.s04.t02.n01.fruits;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitsRepository extends JpaRepository<Fruit, Long> {
    Fruit getById(long id);
}
