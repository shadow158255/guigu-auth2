package com.example.worktext1.service.impl;

import com.example.worktext1.ex.ServiceException;
import com.example.worktext1.mapper.DepartMapper;
import com.example.worktext1.pojo.dto.DepartAddNewDTO;
import com.example.worktext1.pojo.dto.DepartUpdateDTO;
import com.example.worktext1.pojo.entity.Depart;
import com.example.worktext1.pojo.vo.DepartStandardVO;
import com.example.worktext1.service.DepartService;
import com.example.worktext1.web.JsonResult;
import com.example.worktext1.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@Slf4j
@Service
public class DepartServiceImpl implements DepartService, ServiceCode {


    public DepartServiceImpl() {
        log.info("创建业务对象：DepartServiceImpl");
    }

    @Autowired
    DepartMapper departMapper;

    @Override
    public void addNew(DepartAddNewDTO departAddNewDTO) throws UnknownHostException {
        log.debug("开始处理【添加部门】的业务，参数：{}", departAddNewDTO);
        String name = departAddNewDTO.getName();
        log.debug("尝试添加的部门名称为【{}】，在数据库中的数量为{}",departAddNewDTO.getName(),departMapper.countByName(name));
        if (departMapper.countByName(name)>0){
            String message = "添加部门【{}】失败，该部门已存在";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT,message);
        }

        //补全属性
        Depart depart = new Depart();
        //将DTO对像中属性复制到entity中
        BeanUtils.copyProperties(departAddNewDTO,depart);
        //获取ip地址
        String localHost= InetAddress.getLocalHost().getHostAddress();
        depart.setAddIp(localHost);
        //获取时间
        LocalDateTime now = LocalDateTime.now();
        //补全添加时间
        depart.setAddTime(now);
        //默认创建人id为100
        depart.setAddUserId(100l);
        //默认数据状态为正常
        depart.setIsDel(false);
        log.debug("即将像数据库中插入数据：{}",depart);
        int rows = departMapper.insert(depart);
        if (rows !=1 ){
            String message = "添加部门失败，服务器忙，请稍后再试";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_INSERT,message);
        }
    }

    @Override
    public void deleteById(Long id) {
        log.debug("开始处理【根据id删除部门】的业务，当前删除id为{}的部门", id);
        DepartStandardVO departId = departMapper.selectByDepartId(id);
        if (departId==null){
            String message = "尝试删除部门失败，该部门不存在";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }
        //执行删除
        log.debug("即将删除id为{}的部门。。。",id);
        //真删除
       /* int rows = departMapper.deleteById(id);
        if (rows != 1){
            String message = "尝试删除部门失败，请稍后再试！";
            throw new ServiceException(ServiceCode.ERR_DELETE,message);
        }*/

        //逻辑删除
        Depart depart = new Depart();
        depart.setIsDel(true);
        if (depart.getIsDel()==false){
            String message = "尝试删除部门失败，请稍后再试！";
            throw new ServiceException(ServiceCode.ERR_DELETE,message);
        }
        log.debug("删除完成！");
    }

    @Override
    public void update(DepartUpdateDTO departUpdateDTO) throws UnknownHostException {
        log.debug("开始处理【修改部门信息】的业务，参数：{}", departUpdateDTO);
        Long departId = departUpdateDTO.getDepartId();
        DepartStandardVO departIdOld = departMapper.selectByDepartId(departId);
        log.debug("尝试修改的部门id为【{}】，在数据库中的数量为{}",departId,departIdOld);
        if (departIdOld==null){
            String message = "尝试修改部门失败，该部门不存在";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }

        //补全属性
        Depart depart = new Depart();
        //将DTO对像中属性复制到entity中
        BeanUtils.copyProperties(departUpdateDTO,depart);
        //获取修改ip地址
        String localHost= InetAddress.getLocalHost().getHostAddress();
        depart.setLastEditIp(localHost);

        //获取时间
        LocalDateTime now = LocalDateTime.now();
        //补全修改时间
        depart.setLastEditTime(now);
        log.debug("即将从数据库中修改数据：{}",depart);
        int rows = departMapper.update(depart);
        if (rows !=1 ){
            String message = "修改部门失败，服务器忙，请稍后再试";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_INSERT,message);
        }
        log.debug("修改部门成功：{}",depart);
    }

    @Override
    public DepartStandardVO getInfoById(Long id) {
        log.debug("开始处理【根据id查询部门】的业务，当前查询id为{}的部门", id);
        DepartStandardVO depart = departMapper.selectByDepartId(id);
        if (depart==null){
            String message = "尝试查询部门失败，该部门不存在";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }
        return depart;
    }


}
