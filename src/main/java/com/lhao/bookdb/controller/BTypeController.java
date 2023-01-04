package com.lhao.bookdb.controller;

import com.github.pagehelper.PageInfo;
import com.lhao.bookdb.bean.Type;
import com.lhao.bookdb.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName BTypeController
 * @Description :
 * @Author 小豪
 * @Date 2022/9/15 21:47
 * @Version 1.0
 **/
@Controller
public class BTypeController {

    @Resource
    TypeService typeService;

    /*
页面跳转
*/

    /**
     * @return
     * @Description:To：类型添加页面
     */
    @GetMapping("/type_add.html")
    public String type_add() {
        return "type/type_add";
    }

    /**
     * @return
     * @Description:To:类型列表页面
     */
    @GetMapping("/type_list.html")
    public String type_list() {
        return "type/type_list";
    }


    @RequestMapping("/type_modify.html")
    public String type_modify() {
        return "type/type_modify";
    }


    /**
     * @return :Map<String,Object>
     * @Description:获取指定页面信息
     */
    @ResponseBody
    @GetMapping("/page")
    public Map<String, Object> getPage(@RequestParam("pageNum") Integer pageNum) {
        PageInfo<Type> pageInfo = typeService.getPage(pageNum, 6);
        HashMap<String, Object> map = new HashMap<>();
        map.put("page", pageInfo);
        return map;
    }

    /**
     * @return ；返回指定id用户类型的信息
     * @Description:跳转到修改页面
     */
    @GetMapping("/type_modify")
    public String getType(@RequestParam("id") Integer id,
                          HttpServletRequest request) {
        Type type = typeService.getById(id);
        request.setAttribute("type", type);
        return "forward:/type_modify.html";
    }

    /**
     * @return
     * @Description:更新类型信息
     */
    @PutMapping("/type")
    public String update(Type type) {
        if (typeService.saveOrUpdate(type)) {
            return "redirect:/type_list.html";
        } else {
            return null;
        }
    }

    /**
     * @return
     * @Description:删除指定类型
     */
    @ResponseBody
    @DeleteMapping("/type/{id}")
    public Map<String, Object> delete(@PathVariable("id") Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        if (typeService.removeById(id)) {
            map.put("status", 200);
        } else {
            map.put("status", 400);
        }
        return map;
    }

}
