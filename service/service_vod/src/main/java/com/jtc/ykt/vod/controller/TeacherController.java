package com.jtc.ykt.vod.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jtc.exception.YktException;
import com.jtc.ykt.Result;
import com.jtc.ykt.model.vod.Teacher;
import com.jtc.ykt.model.vod.TeacherQueryVo;
import com.jtc.ykt.vod.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author 天赐
 * @since 2023-08-23
 */
@RestController
@RequestMapping("/admin/vod/teacher")
@Api("教师管理")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    //查询所有讲师列表
    @ApiOperation("查看教师列表")
    @GetMapping("findAll")
    public Result findAll(){
        List<Teacher> list = teacherService.list();
        return Result.ok(list).message("查询数据成功");
    }
    //删除讲师
    @DeleteMapping("remove/{id}")
    @ApiOperation("删除教师")
    public Result removeById(@ApiParam("删除教师ID") @PathVariable String id){
        boolean isSuccess = teacherService.removeById(id);
        if(isSuccess){
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    //条件查询分页列表
    @ApiOperation("获取分页列表")
    @PostMapping("{page}/{limit}")
    public Result index(
            @ApiParam(name = "page",value = "当前页码",required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit",value = "每页记录数",required = true)
            @PathVariable Long limit,
            @ApiParam(name = "teacherVo",value = "查询对象",required = false)
            @RequestBody(required = false) TeacherQueryVo teacherQueryVo){
        //创建page对象，传递当前页和每页记录数
        Page<Teacher> pageParam = new Page<>(page,limit);
        //获取条件值
        String name = teacherQueryVo.getName();//讲师名称
        Integer level = teacherQueryVo.getLevel();//讲师级别
        String joinDateBegin = teacherQueryVo.getJoinDateBegin();//开始时间
        String joinDateEnd = teacherQueryVo.getJoinDateEnd();
        //封装条件
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(joinDateBegin)){
            wrapper.ge("join_date",joinDateBegin);
        }
        if(!StringUtils.isEmpty(joinDateEnd)){
            wrapper.le("join_date",joinDateEnd);
        }
        //调用方法
        IPage<Teacher> pageModel = teacherService.page(pageParam,wrapper);
        return Result.ok(pageModel);
    }

    @ApiOperation("新增")
    @PostMapping("save")
    public Result save(
            @ApiParam(name = "teacher", value="添加讲师对象",required = true)
            @RequestBody Teacher teacher){
        teacherService.save(teacher);
        return Result.ok(null);
    }

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        Teacher teacher = teacherService.getById(id);
        return Result.ok(teacher);
    }

    @ApiOperation(value = "修改")
    @PutMapping("update")
    public Result updateById(@RequestBody Teacher teacher) {
        teacherService.updateById(teacher);
        return Result.ok(null);
    }


    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        teacherService.removeByIds(idList);
        return Result.ok(null);
    }

}


