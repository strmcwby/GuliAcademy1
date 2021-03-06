package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduCourse;

import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-03-24
 */
public interface EduCourseService extends IService<EduCourse> {

   String saveCourseInfo(CourseInfoVo courseInfoVo);

   //根据课程id查询课程基本信息
   CourseInfoVo getCourseInfo(String courseId);

   //修改课程信息
   void updateCourseInfo(CourseInfoVo courseInfoVo);

   //根据课程id查询课程确认信息
   CoursePublishVo publishCourseInfo(String id);

   //删除课程
   void removeCourse(String courseId);
}
