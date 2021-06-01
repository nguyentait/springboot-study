package com.nguyentc7.app.controller;

import com.nguyentc7.app.model.dto.UserDto;
import com.nguyentc7.app.request.CreateUserReq;
import com.nguyentc7.app.request.UpdateUserReq;
import com.nguyentc7.app.services.IFileHelper;
import com.nguyentc7.app.services.IUserService;
import com.nguyentc7.app.model.UploadForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.File;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IFileHelper fileHelper;

    @GetMapping
    public ResponseEntity<?> getListUser(){
        return ResponseEntity.status(HttpStatus.OK).body( userService.getListUser());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        UserDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam(name = "name", defaultValue = "", required = false) String name){
        return ResponseEntity.ok(userService.searchUserByName(name));
    }
    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserReq user){
        return ResponseEntity.ok(userService.createUser(user));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUserReq userReq, @PathVariable(name = "id")Long id ){
        UserDto userDto = userService.updateUser(userReq, id);
        return ResponseEntity.ok(userDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("Delete user success");
    }
    private static String UPLOAD_DIR = System.getProperty("user.home") + "/upload";
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@ModelAttribute("uploadForm")UploadForm form){
        File uploadDir = new File(UPLOAD_DIR);
        fileHelper.uploadSingleFile(uploadDir, form.getFileData());
        return ResponseEntity.ok("Upload file success");
    }
    @GetMapping("/file/{filename}")
    public ResponseEntity<?> downloadFile(@PathVariable String filename){
        File file = new File(UPLOAD_DIR + "/" + filename);
        return fileHelper.download(file);
    }

}
