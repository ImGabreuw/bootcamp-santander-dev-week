package me.gabreuw.bootcamp_santander_dev_week.repository;

import me.gabreuw.bootcamp_santander_dev_week.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByNameAndDate(String name, LocalDate date);

    @Query(
            "SELECT stock " +
            "FROM Stock stock " +
            "WHERE stock.id <> :id AND stock.name = :name AND stock.date = :date "
    )
    Optional<Stock> findByStockToUpdate(Long id, String name, LocalDate date);

    @Query(
            "SELECT stock " +
            "FROM Stock stock " +
            "WHERE stock.date = :date "
    )
    Optional<List<Stock>> findByToday(LocalDate date);
}