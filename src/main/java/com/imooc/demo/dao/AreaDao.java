package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;

import java.util.List;

/**
 * area方法接口
 * @author 1469023020
 */
public interface AreaDao {
    /**
     * 查询所有区
     * @return area list
     */
    List<Area> queryArea();

    /**
     *根据区名查区列表
     * @param areaName 区域名
     * @return area list
     */
    List<Area> queryAreaByName(String areaName);

    /**
     * 根据id查区域
     * @param areaId 区id
     * @return Area
     */
    Area queryAreaById(int areaId);

    /**
     * 新增区域
     * @param area 区信息
     * @return number
     */
    int insertArea(Area area);

    /**
     * 修改区
     * @param area 区信息
     * @return number
     */
    int updateArea(Area area);

    /**
     * 删除区
     * @param areaId 区id
     * @return number
     */
    int deleteArea(int areaId);

    /**
     * 根据区名查区域
     * @param areaName 区名
     * @return Area
     */
    Area getAreaByName(String areaName);


}
