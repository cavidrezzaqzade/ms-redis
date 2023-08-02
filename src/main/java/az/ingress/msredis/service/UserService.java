package az.ingress.msredis.service;

import az.ingress.msredis.model.UserCriteria;
import az.ingress.msredis.model.UserDto;

import java.util.List;

/**
 * @author caci
 */

public interface UserService {

    List<UserDto> getAll();

    UserDto add(UserDto userDto);

    void delete(Long id);

    void update(UserDto dto, Long id);

}
