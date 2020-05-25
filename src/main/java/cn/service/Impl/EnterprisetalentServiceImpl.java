package cn.service.Impl;

import cn.dao.EnterprisetalentMapper;
import cn.entity.Enterprisetalent;
import cn.service.EnterprisetalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("enterprisetalentService")
public class EnterprisetalentServiceImpl implements EnterprisetalentService {
    @Autowired
    private EnterprisetalentMapper enterprisetalentMapper;
    @Override
    public List<Enterprisetalent> SelectEnterprisetalent(Integer departmentId,Integer id) {
        return enterprisetalentMapper.SelectEnterprisetalent(departmentId,id);
    }

    @Override
    public boolean UpdateEnterprisetalent(Enterprisetalent enterprisetalent) {
        return enterprisetalentMapper.UpdateEnterprisetalent(enterprisetalent);
    }

    @Override
    public boolean DeleteEnterprisetalent(Integer id) {
        return enterprisetalentMapper.DeleteEnterprisetalent(id);
    }

    @Override
    public boolean InsertEnterprisetalent(Enterprisetalent enterprisetalent) {
        return enterprisetalentMapper.InsertEnterprisetalent(enterprisetalent);
    }
}
