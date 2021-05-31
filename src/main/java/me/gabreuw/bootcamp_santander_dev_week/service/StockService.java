package me.gabreuw.bootcamp_santander_dev_week.service;

import lombok.RequiredArgsConstructor;
import me.gabreuw.bootcamp_santander_dev_week.exceptions.BusinessException;
import me.gabreuw.bootcamp_santander_dev_week.exceptions.NotFoundException;
import me.gabreuw.bootcamp_santander_dev_week.mapper.StockMapper;
import me.gabreuw.bootcamp_santander_dev_week.model.Stock;
import me.gabreuw.bootcamp_santander_dev_week.model.dto.StockDTO;
import me.gabreuw.bootcamp_santander_dev_week.repository.StockRepository;
import me.gabreuw.bootcamp_santander_dev_week.util.MessageUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StockService {

    private final StockRepository REPOSITORY;
    private final StockMapper MAPPER;

    @Transactional
    public StockDTO save(StockDTO dto) {
        Optional<Stock> stockOptional = REPOSITORY.findByStockToUpdate(
                dto.getId(),
                dto.getName(),
                dto.getDate()
        );

        if (stockOptional.isPresent()) {
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS.getMessage());
        }

        Stock stock = MAPPER.toEntity(dto);

        REPOSITORY.save(stock);

        return MAPPER.toDTO(stock);
    }

    @Transactional
    public StockDTO update(StockDTO dto) {
        Optional<Stock> stockOptional = REPOSITORY.findByNameAndDate(dto.getName(), dto.getDate());

        if (stockOptional.isPresent()) {
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS.getMessage());
        }

        Stock stock = MAPPER.toEntity(dto);

        REPOSITORY.save(stock);

        return MAPPER.toDTO(stock);
    }

    @Transactional
    public void delete(Long id) {
        StockDTO dto = findById(id);

        REPOSITORY.deleteById(dto.getId());
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findAll() {
        return MAPPER.toDTOCollection(REPOSITORY.findAll());
    }

    @Transactional(readOnly = true)
    public StockDTO findById(Long id) {
        return REPOSITORY.findById(id)
                .map(MAPPER::toDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findByToday() {
        return REPOSITORY.findByToday(LocalDate.now())
                .map(MAPPER::toDTOCollection)
                .orElseThrow(NotFoundException::new);
    }
}
