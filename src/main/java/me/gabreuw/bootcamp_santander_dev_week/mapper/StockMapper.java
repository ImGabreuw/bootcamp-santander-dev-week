package me.gabreuw.bootcamp_santander_dev_week.mapper;

import me.gabreuw.bootcamp_santander_dev_week.model.Stock;
import me.gabreuw.bootcamp_santander_dev_week.model.dto.StockDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockMapper {


    public Stock toEntity(StockDTO dto) {
        Stock entity = new Stock();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setVariation(dto.getVariation());
        entity.setDate(dto.getDate());

        return entity;
    }

    public StockDTO toDTO(Stock entity) {
        StockDTO dto = new StockDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setVariation(entity.getVariation());
        dto.setDate(entity.getDate());

        return dto;
    }

    public List<StockDTO> toDTOCollection(List<Stock> stocks) {
        return stocks.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
