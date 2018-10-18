package com.ddf.dubbo.common.interfaces.user;

import com.ddf.dubbo.common.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author DDf on 2018/10/11
 */
public interface UserService {

    List<User> batchRegistryUser(Iterable<User> iterable);

    User registryUser(User user);

    User login(String username, String password);

    Page<User> list(int page, int size);
}
