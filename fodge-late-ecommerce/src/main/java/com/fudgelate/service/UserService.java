package com.fudgelate.service;

import org.wildfly.security.password.PasswordFactory;
import org.wildfly.security.password.interfaces.BCryptPassword;
import org.wildfly.security.password.spec.BCryptPasswordSpec;
import org.wildfly.security.password.spec.EncryptablePasswordSpec;
import org.wildfly.security.password.util.ModularCrypt;
import org.wildfly.security.provider.util.ProviderUtil;

import com.fudgelate.model.User;
import com.fudgelate.repository.UserRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    @Transactional
    public User createUser(User user) throws Exception {
        PasswordFactory passwordFactory = PasswordFactory.getInstance(BCryptPassword.ALGORITHM_BCRYPT,
                ProviderUtil.INSTALLED_PROVIDERS);
        BCryptPassword original = (BCryptPassword) passwordFactory.generatePassword(new EncryptablePasswordSpec(
                user.getPassword().toCharArray(), new BCryptPasswordSpec(BCryptPassword.BCRYPT_SALT_SIZE)));
        String storedUserPassword = ModularCrypt.encodeAsString(original);
        user.setPassword(storedUserPassword);
        userRepository.persist(user);
        return user;
    }

    // Other service methods...
}