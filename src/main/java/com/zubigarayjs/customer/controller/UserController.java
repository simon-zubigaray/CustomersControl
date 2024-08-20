package com.zubigarayjs.customer.controller;

import com.zubigarayjs.customer.model.User;
import com.zubigarayjs.customer.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private IUserService cs;

    //lectura de muchos objetos
    @GetMapping("/users")
    @ResponseBody
    public List<User> getUsers() {
        List<User> listaUsers;
        listaUsers = cs.getUsers();
        return listaUsers;
    }

    //lectura de un objeto
    @GetMapping("/user/{id}")
    @ResponseBody
    public User getUser(@PathVariable Integer id) {
        return cs.getUser(id);
    }

    //alta
    @PostMapping("/user")
    public String register(@RequestBody User user) {
        cs.saveUser(user);
        return "El user ha sido registrado con exito!";
    }

    //baja
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Integer id) {
        cs.deleteUser(id);
        return "El user ha sido borrado con exito!";
    }

    //modificacion
    @PutMapping("/user/{id_user}")
    public String modifyUser(@PathVariable Integer id_user,
                                 @RequestBody User updateUser) {

        cs.modifyUser(id_user, updateUser);
        return "El user ha sido modificado con exito!";
    }

    //busqueda
    @GetMapping("/user/search")
    public List<User> searchUser(@RequestParam(name = "email", required = false) String email,
                                         @RequestParam(name = "address", required = false) String address) {
        return cs.searchUser(email, address);
    }
}