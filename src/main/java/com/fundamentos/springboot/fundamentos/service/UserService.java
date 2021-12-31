package com.fundamentos.springboot.fundamentos.service;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void saveTransactional(List<User> userList){
        userList.stream()
                .peek(user -> log.info("insert service: "+user))
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    public void delete(Long id) {
        userRepository.delete(User.builder().withId(id).build());
    }

    public User update(User newUser, Long id) {
        return userRepository.findById(id)
                .map(
                        user -> {
                            user.setEmail(newUser.getEmail());
                            user.setName(newUser.getName());
                            user.setFecah(newUser.getFecah());
                            return userRepository.save(user);
                        }
                ).get();
    }

    public List<User> getAllPaginationUsers(int page, int size) {
            return userRepository.findAll(PageRequest.of(page, size)).getContent();
    }
}
