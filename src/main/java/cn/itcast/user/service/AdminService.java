package cn.itcast.user.service;

import cn.itcast.user.mapper.AdminMapper;
import cn.itcast.user.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {

    @Autowired(required = false)
    private AdminMapper adminMapper;


    public Admin queryAdminById(int id) {
        return this.adminMapper.selectByPrimaryKey(id);
    }


}