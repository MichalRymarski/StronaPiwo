package com.test.testproject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service //specjalny @Component ktory przywolujesz se autowired w testach, NIE UZYWAJ  AUTOWIRED W KODZIE
//Serivce z automatu tworzy instancje wstrzykujac konstrutor gdy go potrzebujesz OP OP
@RequiredArgsConstructor // wszystkie pola final maja wygenerowany dla siebie konstruktor od razu
public class UserService {
   private  final UserRepository userRepository;
   private final UserMapper userMapper = UserMapper.INSTACE;

    //TODO : CRUD od razu gdy cos bedziemy z niego potrzebowali

   public void clearDatabase(){
      userRepository.deleteAll();
   }
   public List<UserDTO> getAllUsers() {
      List<User> users = userRepository.findAll();
      if (users.isEmpty()){
         throw new NoSuchElementException("No users found in the list");
      }
      return users.stream()
          .map(userMapper::toDTO)
          .collect(Collectors.toList());
   }

   public UserDTO addUser(UserDTO userDTO){
      User user = userMapper.toEntity(userDTO);
      User savedUser = userRepository.save(user);
      return userMapper.toDTO(savedUser);
   }

   public UserDTO getUserById(final Long id)  {
      Optional<User> user = userRepository.findById(id);
      if (user.isPresent()){
         return userMapper.toDTO(user.get());
      }
      throw new NoSuchElementException("no user found");
   }
   public UserDTO getUserByNickName(final String nickName){
     Optional <User> user = userRepository.findByNickName(nickName);
     if (user.isPresent()){
        return userMapper.toDTO(user.get());
     }
     throw new NoSuchElementException("No user by this nickName was found");
   }
   public UserDTO getUserByNickNameAndPassword(final String nickName,final String hashPassword){
      Optional<User> user = userRepository.findByNickNameAndPasswordHash(nickName,hashPassword);
      if (user.isPresent()){
         return userMapper.toDTO(user.get());
      }
      throw new NoSuchElementException("no user found");
   }

}
