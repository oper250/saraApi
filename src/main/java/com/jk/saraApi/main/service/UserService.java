package com.jk.saraApi.main.service;

import com.jk.saraApi.common.CommonException;
import com.jk.saraApi.common.CommonService;
import com.jk.saraApi.main.dao.UserDAO;
import com.jk.saraApi.main.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor=Exception.class)
public class UserService extends CommonService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService() {super(UserService.class);}

    public int joinProcess(UserDTO userDTO) throws Exception {
        int cnt = userDAO.checkExistsId(userDTO);

        if(cnt > 0) {
            throw new CommonException( "0001", "이미 존재하는 아이디입니다." );
        }

        userDTO.setUserPwd(bCryptPasswordEncoder.encode(userDTO.getUserPwd()));       // 패스워드 암호화
        userDTO.setRole("ROLE_USER");           // 권한 부여

        return userDAO.joinProcess(userDTO);
    }

}

