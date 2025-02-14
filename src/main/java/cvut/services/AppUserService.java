package cvut.services;

import cvut.dao.AppUserDao;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppUserService {
    private final AppUserDao appUserDao;
    private final PasswordEncoder passwordEncoder;

    public AppUserService(AppUserDao appUserDao, PasswordEncoder passwordEncoder) {
        this.appUserDao = appUserDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public boolean exists(String username) {
        return appUserDao.findByUsername(username) != null;
    }

}
