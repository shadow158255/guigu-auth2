package com.example.worktext1.mapper;

import com.example.worktext1.pojo.entity.Depart;
import com.example.worktext1.pojo.vo.DepartStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@SpringBootTest
public class departMapperTest {
    @Autowired
    DepartMapper mapper;

    @Test
    public void TextInsert() throws UnknownHostException {
        Depart depart = new Depart();
        depart.setPid(0l);
        String localHost= InetAddress.getLocalHost().getHostAddress();
        depart.setAddIp(localHost);

        depart.setName("香蕉部门6");
        depart.setSort(20);
        LocalDateTime now = LocalDateTime.now();
        depart.setAddTime(now);
        depart.setAddUserId(100l);
        depart.setIsDel(false);
        int rows = mapper.insert(depart);
        log.debug("添加部门完成，受影响行数为："+rows+"添加数据："+depart);
    }

    @Test
    public void TestDeleteById(){
        Long id = 22l;
        int rows = mapper.deleteById(id);
        log.debug("根据【部门id：{}】删除部门完成,受影响行数：{}",id,rows);
    }

    @Test
    public void TestUpdateByDepartId() throws UnknownHostException {
        Long departId=20l;
        Depart depart = new Depart();
        depart.setDepartId(departId);
        depart.setPid(20l);
        depart.setName("研发二部");
        depart.setSort(3);
        String localHost= InetAddress.getLocalHost().getHostAddress();
        depart.setLastEditIp(localHost);
        LocalDateTime now = LocalDateTime.now();
        depart.setLastEditTime(now);
        int rows = mapper.update(depart);
        log.debug("根据【部门id：{}】修改部门完成，受影响行数：{}，修改结果：{}",departId,rows, depart);

    }

    @Test
    public void TestCountByName(){
        String name = "香蕉部门3";
        int count = mapper.countByName(name);
        log.debug("根据名称【{}】查询部门完成,查询结果：{}",name,count);
    }

    @Test
    public void TestSelectByDepartId(){
        Long departId = 30l;
        DepartStandardVO result = mapper.selectByDepartId(departId);
        log.debug("根据【部门id：{}】查询部门完成，查询结果：{}",departId,result);
    }

}
