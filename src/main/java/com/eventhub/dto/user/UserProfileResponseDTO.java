package com.eventhub.dto.user;

import java.time.OffsetDateTime;

public record UserProfileResponseDTO(
        Long id,
        String name,
        String email,
        OffsetDateTime updatedAt
) {}
