package com.example.worktext1.service;

import com.example.worktext1.pojo.dto.DepartAddNewDTO;
import com.example.worktext1.pojo.dto.DepartUpdateDTO;
import com.example.worktext1.pojo.vo.DepartStandardVO;

import java.net.UnknownHostException;

public interface DepartService {
    /**
     * 添加部门的业务
     * @param departAddNewDTO 添加业务的对象
     * @throws UnknownHostException
     */
    void addNew(DepartAddNewDTO departAddNewDTO) throws UnknownHostException;

    /**
     * 根据id删除部门
     * @param id
     */
    void deleteById(Long id);

    /**
     * 更改部门详情的业务
     * @param departUpdateDTO
     * @throws UnknownHostException
     */
    void update(DepartUpdateDTO departUpdateDTO) throws UnknownHostException;

    /**
     * 查询部门详情
     * @param
     */
    DepartStandardVO getInfoById(Long id);

}
