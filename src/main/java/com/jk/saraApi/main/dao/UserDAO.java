package com.jk.saraApi.main.dao;

import com.jk.saraApi.common.CommonDAO;
import com.jk.saraApi.main.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository( "JoinDAO" )
public class UserDAO extends CommonDAO {
    // 회원가입 프로세스
    public int joinProcess(UserDTO userDTO) throws Exception {
        return sqlSession.insert( "UserMapper.joinProcess", userDTO);
    }

    // 아이디 중복 체크
    public int checkExistsId(UserDTO userDTO) throws Exception {
        return sqlSession.selectOne( "UserMapper.checkExistsId", userDTO);
    }

    public Map<String, Object> selectUserInfo(String userId) {
        return sqlSession.selectOne("UserMapper.selectUserInfo", userId);
    }

}
