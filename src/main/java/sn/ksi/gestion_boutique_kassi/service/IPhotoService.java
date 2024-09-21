package sn.ksi.gestion_boutique_kassi.service;

import org.springframework.web.multipart.MultipartFile;

public interface IPhotoService {
    String saveImage(MultipartFile file);
}
