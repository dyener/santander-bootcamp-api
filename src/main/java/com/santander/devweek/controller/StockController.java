package com.santander.devweek.controller;

import com.santander.devweek.model.dto.StockDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @PostMapping()
    public ResponseEntity<StockDTO> save(@RequestBody StockDTO dto){

        return ResponseEntity.ok(dto);
    }

    @PutMapping()
    public ResponseEntity<StockDTO> update(@RequestBody StockDTO dto){

        return ResponseEntity.ok(dto);
    }

    @GetMapping()
    public ResponseEntity<List<StockDTO>> findall(){

        return ResponseEntity.ok(this.buildFakeData());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){

        StockDTO dto = this.buildFakeData().stream().filter(x -> x.getId().compareTo(id) == 0).findFirst().get();
        return ResponseEntity.ok(dto);
    }

    private List<StockDTO> buildFakeData(){
        List<StockDTO> list = new ArrayList<StockDTO>();
        StockDTO dto = new StockDTO();
        dto.setId(1L);
        dto.setName("Magazine Luiza");
        dto.setPrice(100D);
        dto.setDate(LocalDate.now());

        StockDTO dto2 = new StockDTO();
        dto2.setId(2L);
        dto2.setName("Ponto Frio");
        dto2.setPrice(200D);
        dto2.setDate(LocalDate.now());

        list.add(dto);
        list.add(dto2);

        return list;
    }


}

