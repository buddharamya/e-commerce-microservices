//package com.microserviceprojects.user_service.Controller;
//
//import com.microserviceprojects.user_service.DTO.UserDTO;
//import com.microserviceprojects.user_service.Service.UserService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/credentials")
//@Slf4j
//public class CredentialController {
//
//    @Autowired
//    UserService userService;
//
//    @PostMapping
//    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO)
//    {
//        log.info("UserController save");
//        UserDTO dbUser = userService.save(userDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(dbUser);
//    }
//
//    @GetMapping("/{userId}")
//    public ResponseEntity<UserDTO> findById(@PathVariable Integer userId) {
//        log.info("userController findById");
//        return ResponseEntity.ok(userService.findById(userId));
//    }
//
//    @GetMapping("/{userName}")
//    public ResponseEntity<UserDTO> findByUserName(@PathVariable String userName) {
//        log.info("userController findByUserName");
//        return ResponseEntity.ok(userService.findByUserName(userName));
//    }
//
//    public ResponseEntity<Void> deleteById(@PathVariable Integer userId) {
//        log.info("userController deleteById");
//        userService.deleteById(userId);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping("/update-user")
//    public ResponseEntity<Void> updateUser(@PathVariable Integer userId, @RequestBody UserDTO userDTO) {
//        log.info("userController updateUser");
//        userService.updateUser(userId,userDTO);
//        return ResponseEntity.ok().build();
//    }
//}
