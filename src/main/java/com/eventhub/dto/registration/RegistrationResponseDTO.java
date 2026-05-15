package com.eventhub.dto.registration;

import java.time.OffsetDateTime;

public record RegistrationResponseDTO(
        Long eventId,
        String eventTitle,
        String status,
        OffsetDateTime registeredAt
) {}
