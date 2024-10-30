package com.example.demo.controller;

import com.example.demo.entity.Attachment;
import com.example.demo.service.AttachmentService;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/attachments")
public class AttachmentController {

    private final AttachmentService attachmentService;
    private final UserService userService;

    /**
     * Загрузить новое вложение
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/add", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Map<String, String>> uploadAttachment(
            @RequestPart(value = "file") MultipartFile file)
            throws IOException {
        Attachment attachment = attachmentService.addAttachment(file);
        Map<String, String> attachmentStatus = new HashMap<>();
        attachmentStatus.put("status", "ok");
        attachmentStatus.put("attachId", attachment.getAttachId().toString());
        return ResponseEntity.ok(attachmentStatus);
    }

    /**
     * Получить ссылку на скачивание загруженного файла
     *
     * @param filename
     * @param request
     * @return
     * @throws IOException
     */
    @GetMapping("/get/{filename:.+}")
    public ResponseEntity<Resource> serveFile(
            @PathVariable String filename, HttpServletRequest request)
            throws IOException {
        Resource resource = attachmentService.loadFileAsResource(filename);
        String contentType;
        contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}