package com.example.demo.repository;

import com.example.demo.model.Content;
import com.example.demo.model.Status;
import com.example.demo.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    public ContentCollectionRepository() {
    }

    private final List<Content> contentList = new ArrayList<>();
    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.getId().equals(content.getId()));
        this.contentList.add(content);
    }

    public void deleteById(Integer id) {
        contentList.removeIf(c -> c.getId().equals(id));
    }

    public boolean existsById(Integer id) {
        return this.contentList.stream().filter(c -> c.getId().equals(id)).count() == 1;
    }

    @PostConstruct
    public void init() {
        Content c = new Content(1,
        "First Blog",
        "Description",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
        null,
        "");

        contentList.add(c);
    }
}
