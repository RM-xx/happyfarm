package cn.itcast.user.service;

import cn.itcast.user.mapper.CityUserMapper;
import cn.itcast.user.pojo.CityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityUserService {

    @Autowired(required = false)
    private CityUserMapper cityUserMapper;


    public CityUser queryUserByCode(String code) {
        return this.cityUserMapper.selectByPrimaryKey(code);
    }

    public int insertCityUser(CityUser cityUser) {
        return this.cityUserMapper.insert(cityUser);
    }


}