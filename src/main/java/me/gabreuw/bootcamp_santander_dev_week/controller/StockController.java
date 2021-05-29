package me.gabreuw.bootcamp_santander_dev_week.controller;

import me.gabreuw.bootcamp_santander_dev_week.model.dto.StockDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/stock") // Forma para acessar este Controller
public class StockController {

    private final List<StockDTO> MOCK_LIST = new ArrayList<>() {{
        StockDTO stock1 = new StockDTO();
        stock1.setId(1L);
        stock1.setName("Mangazine Luiza");
        stock1.setPrice(100D);
        stock1.setVariation(10D);
        stock1.setDate(LocalDate.now());

        StockDTO stock2 = new StockDTO();
        stock2.setId(2L);
        stock2.setName("Ponto Frio");
        stock2.setPrice(200D);
        stock2.setVariation(5D);
        stock2.setDate(LocalDate.now());

        add(stock1);
        add(stock2);
    }};

    /*
        consumes = indicar qual o formato dos dados aceitos pela API
        produces = indicar qual o formato dos dados devolvidos, como resposta, pela API
     */
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto) {
        return ResponseEntity.ok(dto);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto) {
        return ResponseEntity.ok(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll() {
        return ResponseEntity.ok(MOCK_LIST);
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StockDTO> findById(@PathVariable Long id) {
        StockDTO dto = MOCK_LIST.stream()
                .filter(stock -> stock.getId().compareTo(id) == 0)
                .findFirst()
                .get();

        return ResponseEntity.ok(dto);
    }

}
