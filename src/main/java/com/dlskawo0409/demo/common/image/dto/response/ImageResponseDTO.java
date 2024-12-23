package com.dlskawo0409.demo.common.image.dto.response;

import com.dlskawo0409.demo.common.image.domain.ImageType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ImageResponseDTO {
    private Long imageId;
    private String imageURL;
    private ImageType imageType;
}
