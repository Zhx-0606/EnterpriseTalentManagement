package cn.dao;

import cn.entity.Enterprisetalent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnterprisetalentMapper {
    List<Enterprisetalent> SelectEnterprisetalent(@Param("departmentId")Integer departmentId,@Param("id")Integer id);
    boolean UpdateEnterprisetalent(Enterprisetalent enterprisetalent);
    boolean DeleteEnterprisetalent(@Param("id")Integer id);
    boolean InsertEnterprisetalent(Enterprisetalent enterprisetalent);
}
