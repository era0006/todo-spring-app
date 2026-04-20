package todo.controller;

import todo.dto.DtoTag;
import todo.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping
    public ResponseEntity<List<DtoTag>> getAllTags() {
        return ResponseEntity.ok(tagService.getAllTags());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoTag> getTagById(@PathVariable Long id) {
        DtoTag tag = tagService.getTagById(id);
        return tag != null ?
                ResponseEntity.ok(tag) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<DtoTag> getTagByName(@PathVariable String name) {
        DtoTag tag = tagService.getTagByName(name);
        return tag != null ?
                ResponseEntity.ok(tag) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DtoTag> createTag(@RequestBody DtoTag dtoTag) {
        try {
            DtoTag createdTag = tagService.createTag(dtoTag);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTag);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DtoTag> updateTag(
            @PathVariable Long id,
            @RequestBody DtoTag dtoTag) {
        try {
            DtoTag updatedTag = tagService.updateTag(id, dtoTag);
            return ResponseEntity.ok(updatedTag);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        try {
            tagService.deleteTag(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}