package edu.duke.ece651.Dukiture.repository;

import edu.duke.ece651.Dukiture.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByUser_Username(String username);
}
