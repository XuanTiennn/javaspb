package com.example.learn.service;

import com.example.learn.dto.TagDTO;
import com.example.learn.model.Tag;
import com.example.learn.repo.TagRepo;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TagService {
    private final TagRepo tagRepo;

    public TagService(TagRepo tagRepo) {
        this.tagRepo = tagRepo;
    }

    public List<Tag> getList() {
        return tagRepo.findAll();
    }

    @SneakyThrows
    public Tag createTag(Tag request) {
//        validate(request);
        return tagRepo.save(request);
    }

    public Tag updateTag(Long id, TagDTO request) {
        // Kiểm tra xem tag có tồn tại không
        Tag tag = tagRepo.findById(id).orElse(new Tag());
        if (tag == null) {
            // Trả về null hoặc thông báo lỗi tùy theo yêu cầu
            return null;
        }

        // Cập nhật thông tin cho tag
        tag.setName(request.getName());
        tag.setFollowers(request.getFollowers());
        tag.setHashTagColor(request.getHashTagColor());

        // Lưu tag vào cơ sở dữ liệu
        Tag savedTag = tagRepo.save(tag);
        if (savedTag == null) {
            // Xử lý các trường hợp lỗi tùy theo yêu cầu (ví dụ như báo lỗi hoặc trả về một giá trị đặc biệt)
        }
        return tag;
    }

    public Optional<Tag> getById(Long id) {
        return tagRepo.findById(id);
    }

    public ResponseEntity<Object> validate(Tag tag) throws Exception {
        if(tag.getName() == null){
            return new ResponseEntity<>("ErrorResponseException", HttpStatus.BAD_REQUEST);
        }
        return null;
    }

}
