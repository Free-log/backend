package com.techeer3rd.freelogbackend.domain.test.controller;

import com.techeer3rd.freelogbackend.domain.test.domain.TestData;
import com.techeer3rd.freelogbackend.domain.test.dto.mapper.TestDataMapper;
import com.techeer3rd.freelogbackend.domain.test.dto.request.TestDataCreateRequestDto;
import com.techeer3rd.freelogbackend.domain.test.dto.request.TestDataUpdateRequestDto;
import com.techeer3rd.freelogbackend.domain.test.dto.response.TestDataResponseDto;
import com.techeer3rd.freelogbackend.domain.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService service;
    private final TestDataMapper mapper;

    @PostMapping
    public ResponseEntity<TestDataResponseDto> create(
            @Valid @RequestBody TestDataCreateRequestDto dto
    ){
        TestData entity = service.create(dto);
        TestDataResponseDto response = mapper.toResponseDto(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestDataResponseDto> getOne(@PathVariable UUID id) {
        return ResponseEntity
                .ok(mapper.toResponseDto(service.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestDataResponseDto> update(
            @Valid @RequestBody TestDataUpdateRequestDto dto
    ) {
        return ResponseEntity
                .ok(mapper.toResponseDto(service.update(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
