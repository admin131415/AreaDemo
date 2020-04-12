package com.imooc.demo.web;

import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AreaController area控制层，服务端传来的数据
 * @author 1469023020
 */
@RestController
@RequestMapping("/superadmin")
public class AreaController {
    /**
     * 加载区域服务接口
     */
    @Autowired
    private AreaService areaService;

    /**
     * 根据区域名查询区域列表
     *
     * @param areaName 区域名
     * @return modelMap
     */
    @RequestMapping(value = "/listareabyname", method = RequestMethod.GET)
    public Map<String, Object> listAreaByName(String areaName) {
        Map<String, Object> modelMap = new HashMap<>();
        List<Area> list = areaService.getAreaListByName(areaName);
        modelMap.put("areaList", list);
        return modelMap;
    }

    /**
     * 获得区域列表
     *
     * @return modelMap
     */
    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    public Map<String, Object> listArea() {
        Map<String, Object> modelMap = new HashMap<>();
        List<Area> list = areaService.getAreaList();
        modelMap.put("areaList", list);
        return modelMap;
    }

    /**
     * 根据区域id获取区域
     *
     * @param areaId 区域id
     * @return modelMap
     */
    @RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
    public Map<String, Object> getAreaById(Integer areaId) {
        Map<String, Object> modelMap = new HashMap<>();
        Area area = areaService.getAreaById(areaId);
        modelMap.put("area", area);
        return modelMap;
    }

    /**
     * 新增区域
     *
     * @param area 区域信息
     * @return modelMap
     */
    @RequestMapping(value = "/addarea", method = RequestMethod.POST)
    public Map<String, Object> addArea(@RequestBody Area area) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.addArea(area));
        return modelMap;
    }

    /**
     * 修改区域
     *
     * @param area 区域信息
     * @return modelMap
     */
    @RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
    public Map<String, Object> modifyArea(@RequestBody Area area) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.modifyArea(area));
        return modelMap;
    }

    /**
     * 删除区域
     *
     * @param areaId 区域id
     * @return modelMap
     */
    @RequestMapping(value = "/removearea", method = RequestMethod.GET)
    public Map<String, Object> removeArea(Integer areaId) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.deleteArea(areaId));
        return modelMap;
    }

}