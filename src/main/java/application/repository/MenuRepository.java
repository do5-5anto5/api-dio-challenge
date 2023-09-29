package application.repository;

import application.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    boolean existsByMenuName(String name);
    boolean existsByCategoryName(String name);
}
