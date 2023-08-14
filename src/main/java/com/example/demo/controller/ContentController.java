package com.example.demo.controller;

import com.example.demo.model.Content;
import com.example.demo.repository.ContentCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    private final ContentCollectionRepository contentCollectionRepository;
    @Autowired
    public ContentController(ContentCollectionRepository contentCollectionRepository) {
        this.contentCollectionRepository = contentCollectionRepository;
    }
    @GetMapping("")
    public List<Content> findAll() {
        return this.contentCollectionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return this.contentCollectionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content) {
        contentCollectionRepository.save(content);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        if (!contentCollectionRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        contentCollectionRepository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if (!contentCollectionRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        contentCollectionRepository.deleteById(id);
    }
}
