package com.eventhub.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Request para registro de usuário")
public record RegisterRequestDTO(
        @Schema(example = "John Doe")
        @NotBlank @Size(max = 120) String name,
        @Schema(example = "john.doe@email.com")
        @NotBlank @Email @Size(max = 150) String email,
        @Schema(example = "StrongPass@123")
        @NotBlank @Size(min = 8, max = 100) String password
) {}
