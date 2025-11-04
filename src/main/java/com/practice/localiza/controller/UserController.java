//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//
//
//@RestController
//@RequestMapping("/api/user")
//@CrossOrigin("*")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/findAll")
//    public ResponseEntity<List<User>> findAll(){
//        List<User> lista = this.userService.findAll();
//        return new ResponseEntity<>(lista, HttpStatus.OK);
//    }
//
//    @GetMapping("/findById/{id}")
//    public ResponseEntity<User> findById(@PathVariable("id") long id){
//        User user = this.userService.findById(id);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/deleteById/{id}")
//    public ResponseEntity<String> deleteById(@PathVariable("id") long id){
//        String mensagem = this.userService.deleteById(id);
//        return new ResponseEntity<>(mensagem, HttpStatus.OK);
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<String> save(@RequestBody User user){
//        String mensagem = this.userService.save(user);
//        return new ResponseEntity<>(mensagem, HttpStatus.OK);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<String> update(@RequestBody User user, @PathVariable("id") long id){
//        String mensagem = this.userService.update(user, id);
//        return new ResponseEntity<>(mensagem, HttpStatus.OK);
//    }
//
//    @PutMapping("/changePassword/{id}")
//    public ResponseEntity<String> alterarSenha(@PathVariable("id") long id, @RequestParam("newPassword") String newPassword){
//        String mensagem = this.userService.changePassword(newPassword, id);
//        return new ResponseEntity<>(mensagem, HttpStatus.OK);
//    }
//
//}