package az.ingress.msredis.service;

import az.ingress.msredis.dao.entity.User;
import az.ingress.msredis.dao.repository.UserRepository;
import az.ingress.msredis.mapper.UserMapper;
import az.ingress.msredis.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author caci
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public List<UserDto> getAll() {
        List<User> users = repository.findAll();
        return mapper.entitiesToDtos(users);
    }

    @Override
    public UserDto add(UserDto userDto) {
        User user = mapper.dtoToEntity(userDto);
        return mapper.entityToDto(repository.save(user));
    }

    @Override
    public void delete(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("user was not found"));
        repository.delete(user);
    }

    @Override
    public void update(UserDto dto, Long id) {
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("user was not found"));
        User userNew = mapper.updateUser(user, dto);
        repository.save(userNew);
    }

}
