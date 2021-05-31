package me.gabreuw.bootcamp_santander_dev_week.controller;

import lombok.RequiredArgsConstructor;
import me.gabreuw.bootcamp_santander_dev_week.model.dto.StockDTO;
import me.gabreuw.bootcamp_santander_dev_week.service.StockService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "/stock") // Forma para acessar este Controller
public class StockController {

    private final StockService SERVICE;

    /*
        consumes = indicar qual o formato dos dados aceitos pela API
        produces = indicar qual o formato dos dados devolvidos, como resposta, pela API
     */
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto) {
        return ResponseEntity
                .ok()
                .body(SERVICE.save(dto));
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto) {
        return ResponseEntity
                .ok()
                .body(SERVICE.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll() {
        return ResponseEntity
                .ok()
                .body(SERVICE.findAll());
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StockDTO> findById(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(SERVICE.findById(id));
    }

    @GetMapping(path = "/today")
    public ResponseEntity<List<StockDTO>> findByToday() {
        return ResponseEntity
                .ok()
                .body(SERVICE.findByToday());
    }

    @DeleteMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        SERVICE.delete(id);

        return ResponseEntity
                .noContent()
                .build();
    }

}
