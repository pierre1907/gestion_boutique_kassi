package sn.ksi.gestion_boutique_kassi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sn.ksi.gestion_boutique_kassi.service.IPhotoService;

@Service
public class PhotoService implements IPhotoService {

    private final IPhotoService photoService;

    @Autowired
    public PhotoService(@Value("${photoservice.implementation}") String implementation,
                        PhotoServiceCloudinary cloudinaryService,
                        PhotoServiceFirebase firebaseService) {
        this.photoService = "firebase".equalsIgnoreCase(implementation) ? firebaseService : cloudinaryService;
    }

    @Override
    public String saveImage(MultipartFile file) {
        return photoService.saveImage(file);
    }
}
