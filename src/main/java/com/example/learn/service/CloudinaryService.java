package com.example.learn.service;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Service

public class CloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryService(@Value("${cloudinary.cloud-name}") String cloudName,
                             @Value("${cloudinary.api-key}") String apiKey,
                             @Value("${cloudinary.api-secret}") String apiSecret) {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret));
    }

    public Map<String, String> uploadImage(MultipartFile file) throws IOException {
        // Tải ảnh lên Cloudinary
        Map<String, String> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());

        // Lấy publicId và URL từ kết quả tải lên
        String publicId = uploadResult.get("public_id");
        String imageUrl = uploadResult.get("url");

        // Tạo map kết quả với publicId và URL
        Map<String, String> result = new HashMap<>();
        result.put("publicId", publicId);
        result.put("imageUrl", imageUrl);

        return result;
    }
    public void deleteImage(String publicId) throws IOException{
        Map<String, String> options = new HashMap<>();
        // Các tùy chọn xóa ảnh (nếu cần)
        // options.put("key", "value");

        cloudinary.uploader().destroy(publicId, options);
    }
}
