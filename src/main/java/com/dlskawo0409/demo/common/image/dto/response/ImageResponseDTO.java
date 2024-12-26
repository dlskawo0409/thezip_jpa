package com.dlskawo0409.demo.common.image.dto.response;

import com.dlskawo0409.demo.common.image.domain.ImageType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
public record ImageResponseDTO(
        Long imageId,
        String imageURL,
        ImageType imageType
) {

}
