package com.example.demo.service.impl;

import com.example.demo.configuration.AppProperties;
import com.example.demo.configuration.FileTools;
import com.example.demo.domain.model.User;
import com.example.demo.entity.Attachment;
import com.example.demo.repository.AttachmentRepository;
import com.example.demo.service.AttachmentService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final AppProperties appProperties;
    private final FileTools fileTools;

    /**
     * Загрузить новый файл
     *
     * @param file
     * @param user
     * @throws IOException
     */
    @Override
    public Attachment addAttachment(MultipartFile file, User user) throws IOException {
        // Создаем директорию если ее не существует
        File uploadDir = new File(appProperties.getUploadPath());
        // Если директория uploads не существует, то создаем ее
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        String curDate = LocalDateTime.now().toString();
        // Создаем уникальное название для файла и загружаем файл
        String fileName =
                "attach_" + curDate + "_" + file.getOriginalFilename().toLowerCase().replaceAll(" ", "-");
        file.transferTo(new File(uploadDir + "/" + fileName));
        Attachment attachment = Attachment.builder()
                .attachTitle(fileName)
                .uploadDate(LocalDate.now())
                .extension(fileTools.getFileExtension(file.getOriginalFilename()))
                .downloadLink("/attachments/get/" + Year.now() + "/" + fileName)
                .build();
        attachmentRepository.save(attachment);
        return attachment;
    }


    /**
     * Найти Вложение по его ID
     *
     * @param attachId
     * @return
     */
    @Override
    public Attachment findAttachById(Long attachId) {
        return attachmentRepository
                .findById(attachId)
                .orElseThrow(() -> new AttachmentNotFoundException("Attachment not found!"));
    }


    /**
     * Скачать файл
     *
     * @param fileName
     * @return
     * @throws MalformedURLException
     */
    @Override
    public Resource loadFileAsResource(String fileName)
            throws MalformedURLException {
        Path fileStorageLocation =
                Paths.get(appProperties.getUploadPath()).toAbsolutePath().normalize();
        Path filePath = fileStorageLocation.resolve(fileName).normalize();
        return new UrlResource(filePath.toUri());
    }

}
