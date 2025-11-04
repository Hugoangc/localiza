//
//import java.util.List;
//import java.util.Optional;
//
//import com.practice.localiza.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder bcryptEncoder;
//
//
//
//    public List<User> findAll(){
//        List<User> lista = this.userRepository.findAll();
//        for(int i=0; i<lista.size(); i++) {
//            lista.get(i).setPassword("");
//        }
//        return lista;
//    }
//
//    public User findById(long id) {
//        Optional<User> user = this.userRepository.findById(id);
//        if(user.isPresent()) {
//            User user = user.get();
//            user.setPassword("");
//            return user;
//        }
//        else
//            return null;
//    }
//
//    public String save(User user) {
//
//        String senhaCriptografada = bcryptEncoder.encode(user.getPassword());
//        user.setPassword(senhaCriptografada);
//
//        this.userRepository.save(user);
//        return "User salvo com sucesso";
//    }
//
//    public String update(User user, long id) {
//        user.setId(id);
//
//        if(!user.getPassword().equals("")) {
//            String senhaCriptografada = bcryptEncoder.encode(user.getPassword());
//            user.setPassword(senhaCriptografada);
//        }else {
//            String senhaCriptografada = this.findSenhaCriptografada(id);
//            user.setPassword(senhaCriptografada);
//        }
//
//        this.userRepository.save(user);
//        return "User atualizado com sucesso";
//    }
//
//    public String alterarSenha(String novaSenha, long id) {
//
//        String senhaCriptografada = bcryptEncoder.encode(novaSenha);
//
//        this.userRepository.changePassword(senhaCriptografada, id);
//        return "Senha atualizada com sucesso";
//    }
//
//
//    private String findSenhaCriptografada(long id) {
//        Optional<User> user = this.userRepository.findById(id);
//        if(user.isPresent()) {
//            User user = user.get();
//            return user.getPassword();
//        }
//        else
//            return null;
//    }
//
//
//    public String deleteById(long id) {
//        this.userRepository.deleteById(id);
//        return "User deletado com sucesso";
//    }
//
//}