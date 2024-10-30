package com.example.demo.service;

import com.example.demo.domain.model.User;
import com.example.demo.entity.Attachment;
import jakarta.annotation.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

public interface AttachmentService {

    /**
     * Загрузить новый файл
     *
     * @param file
     * @param user
     * @throws IOException
     */
    Attachment addAttachment(MultipartFile file, User user) throws IOException;


    /**
     * Найти Вложение по его ID
     *
     * @param attachId
     * @return
     */
    Attachment findAttachById(Long attachId);

    /**
     * Скачать файл
     *
     * @param uploadYear
     * @param fileName
     * @return
     * @throws MalformedURLException
     */
    Resource loadFileAsResource(String uploadYear, String fileName) throws MalformedURLException;

}