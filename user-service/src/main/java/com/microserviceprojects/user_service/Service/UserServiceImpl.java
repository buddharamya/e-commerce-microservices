package com.microserviceprojects.user_service.Service;


import com.microserviceprojects.user_service.DTO.UserDTO;
import com.microserviceprojects.user_service.Entity.CredentialEntity;
import com.microserviceprojects.user_service.Entity.UserEntity;
import com.microserviceprojects.user_service.Mapper.CredentialMapper;
import com.microserviceprojects.user_service.Mapper.UserMapper;
import com.microserviceprojects.user_service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CredentialMapper credentialMapper;

    @Override
    public UserDTO save(UserDTO userDto) {
        // need to convert userDTO to User Entity
        UserEntity user = userMapper.toEntity(userDto);
        CredentialEntity credential = credentialMapper.toEntity(userDto.getCredential());

        //Bidirectional relationship
        credential.setUser(user);
        user.setCredential(credential);

        UserEntity savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    @Override
    public UserDTO findById(Integer userId) {
        return userRepository.findById(userId).map(userMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found in db"));
    }

    @Override
    public UserDTO findByUserName(String username) {
        return userRepository.findByCredentialUserName(username).map(userMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User with username not found in db"));
    }

    @Override
    public void deleteById(Integer userId) {
        if(!userRepository.existsById(userId)) {
            throw new RuntimeException("Cannot Delete User");
        }
        userRepository.deleteById(userId);
    }

    @Override
    public UserDTO updateUser(Integer userId, UserDTO userDTO) {
        if(!userRepository.existsById(userId)) {
            throw new RuntimeException("Cannot Update user");
        }
        // Map DTO to Entity
        UserEntity user = userMapper.toEntity(userDTO);
        CredentialEntity credential=user.getCredential();

        //Bidirectional relationship
        credential.setUser(user);
        user.setCredential(credential);

        // Save updated entity
        UserEntity updatedUser = userRepository.save(user);

        // Map back to DTO and return
        return userMapper.toDTO(updatedUser);

    }
}
