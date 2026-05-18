package com.eventhub.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateUserRequestDTO(
        @NotBlank @Size(max = 120) String name,
        @NotBlank @Email @Size(max = 150) String email
) {}
