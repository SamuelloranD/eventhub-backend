package com.eventhub.service.impl;

import com.eventhub.dto.user.*;
import com.eventhub.entity.User;
import com.eventhub.entity.enums.Role;
import com.eventhub.exception.BusinessException;
import com.eventhub.exception.ResourceNotFoundException;
import com.eventhub.repository.UserRepository;
import com.eventhub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

import static com.eventhub.exception.ErrorMessages.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserProfileResponseDTO me() {
        return toResponse(getAuthenticatedUser());
    }

    @Override
    public UserProfileResponseDTO updateMyProfile(UpdateUserProfileRequestDTO request) {
        User user = getAuthenticatedUser();
        user.setName(request.name());
        user.setUpdatedAt(OffsetDateTime.now());
        return toResponse(userRepository.save(user));
    }

    @Override
    public UserProfileResponseDTO createUser(CreateUserRequestDTO request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new BusinessException(EMAIL_ALREADY_EXISTS);
        }

        User user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.ROLE_USER)
                .createdAt(OffsetDateTime.now())
                .updatedAt(OffsetDateTime.now())
                .build();

        return toResponse(userRepository.save(user));
    }

    @Override
    public List<UserProfileResponseDTO> findAllUsers() {
        return userRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public UserProfileResponseDTO findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND));
        return toResponse(user);
    }

    @Override
    public UserProfileResponseDTO updateUser(Long id, UpdateUserRequestDTO request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND));
        user.setName(request.name());
        user.setEmail(request.email());
        user.setUpdatedAt(OffsetDateTime.now());
        return toResponse(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException(USER_NOT_FOUND);
        }
        userRepository.deleteById(id);
    }

    private User getAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getName() == null) {
            throw new BusinessException(UNAUTHENTICATED_USER);
        }
        return userRepository.findByEmail(auth.getName())
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND));
    }

    private UserProfileResponseDTO toResponse(User user) {
        return new UserProfileResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getUpdatedAt());
    }
}
