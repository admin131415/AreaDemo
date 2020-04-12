package com.imooc.demo.service.impl;

import com.imooc.demo.dao.AreaDao;
import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 方法实现层
 *
 * @author 1469023020
 */
@Service("AreaService")
public class AreaServiceImpl implements AreaService {
    /**
     * 获得区域操作方法
     */
    @Autowired
    private AreaDao areaDao;

    /**
     * 根据区名查区列表
     *
     * @param areaName 区域名
     * @return area list
     */
    @Override
    public List<Area> getAreaListByName(String areaName) {
        return areaDao.queryAreaByName(areaName);
    }

    /**
     * 查询所有区
     *
     * @return area list
     */
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    /**
     * 根据id查区域
     *
     * @param areaId 区id
     * @return Area
     */
    @Override
    public Area getAreaById(int areaId) {

        return areaDao.queryAreaById(areaId);
    }

    /**
     * 新增区域
     *
     * @param area 区信息
     * @return number
     */
    @Transactional
    @Override
    public boolean addArea(Area area) {
        //空值判断
        if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
            //区域名唯一性校验
            Area area1 = areaDao.getAreaByName(area.getAreaName());
            if (area1 != null) {
                throw new RuntimeException("区域名重复！");
            }
            //设置默认值
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effertedNum = areaDao.insertArea(area);
                if (effertedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入区域信息失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    /**
     * 修改区
     *
     * @param area 区信息
     * @return number
     */
    @Transactional
    @Override
    public boolean modifyArea(Area area) {
        //空值校验，主要是areaId不能为空
        if (area.getAreaId() != null && area.getAreaId() > 0) {
            //设置默认值
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新区域失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新区域失败" + toString());
            }
        } else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    /**
     * 删除区
     *
     * @param areaId 区id
     * @return number
     */
    @Transactional
    @Override
    public boolean deleteArea(int areaId) {
        if (areaId > 0) {
            try {
                //删除信息
                int effectedNum = areaDao.deleteArea(areaId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除区域失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域失败" + e.toString());
            }
        } else {
            throw new RuntimeException("区域id不能为空!");
        }
    }
}
