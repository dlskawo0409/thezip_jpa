package com.dlskawo0409.demo.common.image.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
//    List<ImageResponseDTO> findByReferenceId(@Param("referenceId") String referenceId, @Param("imageType") ImageType imageType);
    List<Image> findByImageTypeAndReferenceId(ImageType imageType, String referenceId);

}