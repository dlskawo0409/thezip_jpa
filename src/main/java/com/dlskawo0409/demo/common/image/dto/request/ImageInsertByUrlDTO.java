package com.dlskawo0409.demo.common.image.dto.request;

import com.dlskawo0409.demo.common.image.domain.ImageType;
import lombok.Builder;

@Builder
public record ImageInsertByUrlDTO(
        String referenceId,
        ImageType imageType,
        String imageUrl
) {
}
