package com.example.demo.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/user")
public class UserController {

      @Autowired
      private UserService service;
      
       @PostMapping("/post")
      public User addUser(@Validated @RequestBody User user)
      {
        return service.addUser(user);
      }

       @GetMapping("/get")
      public List<User> getUser()
      {
        return service.getUser();
      }

       @PutMapping("/put/{id}")
      public User update(@PathVariable Long id,@RequestBody User user)
      {
          return service.updatebyid(id,user);
      }

       @DeleteMapping("/delete/{id}")
      public String deleteusers(@PathVariable Long id)
      {
          return service.deleteusersbyid(id);
      }

       @GetMapping("/page")
      public Page<User>paginated(@RequestParam int page,@RequestParam int size)
      {
          return service.paginated(page,size);
      }
    
       @GetMapping("/email/{email}")
      public User getUserByEmail(@PathVariable String email) {
          return service.getUserByEmail(email);
      } 

      //map Function using..
      // @GetMapping("/mapUserEmail")
      // public List<String> getAllEmailsByMap(){
      //   return service.getAllUserByEmail();
      // }
    }
