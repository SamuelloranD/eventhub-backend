package com.eventhub.service;

import com.eventhub.dto.user.*;

import java.util.List;

public interface UserService {
    UserProfileResponseDTO me();
    UserProfileResponseDTO updateMyProfile(UpdateUserProfileRequestDTO request);

    UserProfileResponseDTO createUser(CreateUserRequestDTO request);
    List<UserProfileResponseDTO> findAllUsers();
    UserProfileResponseDTO findUserById(Long id);
    UserProfileResponseDTO updateUser(Long id, UpdateUserRequestDTO request);
    void deleteUser(Long id);
}
