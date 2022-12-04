package com.example.worktext1.mapper;

import com.example.worktext1.pojo.entity.Depart;
import com.example.worktext1.pojo.vo.DepartStandardVO;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartMapper {
    /**
     *插入部门数据
     * @param depart 部门数据
     * @return 受影响行数
     */
    int insert(Depart depart);

    /**
     * 根据部门Id删除部门
     * @param id 部门id
     * @return
     */
    int deleteById(Long id);
    /**
     * 修改一个部门
     */
    int update(Depart depart);

    /**
     * 根据名称查询表中部门的数量
     * @param name
     * @return
     */
    int countByName(String name);

    /**
     * 根据部门id查询部门
     * @param departId 部门id
     * @return
     */
    DepartStandardVO selectByDepartId(Long departId);
}
