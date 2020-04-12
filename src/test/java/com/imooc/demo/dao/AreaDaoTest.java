package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;
    @Test
    public void queryAreaByName() {
        List<Area> areaList = areaDao.queryAreaByName("o");
        assertEquals(1, areaList.size());
    }

    @Test
    @Ignore
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2, areaList.size());
    }

    @Test
    @Ignore
    public void queryAreaById() {
        Area area = new Area();
        area = areaDao.queryAreaById(2);

        assertEquals("book", area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("沙河1");
       // area.setAreaId(3);
        area.setPriority(4);
        int effortNumber = areaDao.insertArea(area);
        assertEquals(1, effortNumber);

    }

    @Test
    @Ignore
    public void updateArea() {
        Area area = new Area();
        area.setAreaName("中山");
        area.setAreaId(4);
        int effortNumber = areaDao.updateArea(area);
        assertEquals(1, effortNumber);
    }

    @Test
    @Ignore
    public void deleteArea() {
        int effortNumber = areaDao.deleteArea(4);
        assertEquals(1, effortNumber);
    }


}