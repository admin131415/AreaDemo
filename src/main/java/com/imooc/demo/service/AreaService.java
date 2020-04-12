package com.imooc.demo.service;

import com.imooc.demo.entity.Area;

import java.util.List;

public interface AreaService {

    /**
     * 根据区域名模糊查询
     *
     * @param areaName
     * @return
     */
    List<Area> getAreaListByName(String areaName);

    /**
     *获得所有区域
     *
     * @return
     */
    List<Area> getAreaList();

    Area getAreaById(int areaId);

    /**
     * 新增区域
     *
     * @param area
     * @return
     */
    boolean addArea(Area area);

    /**
     * 修改区域信息
     *
     * @param area
     * @return
     */
    boolean modifyArea(Area area);

    /**
     * 删除区域信息
     *
     * @param areaId
     * @return
     */
    boolean deleteArea(int areaId);
}
