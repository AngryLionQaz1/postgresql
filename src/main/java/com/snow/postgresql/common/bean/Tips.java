package com.snow.postgresql.common.bean;
public enum Tips {


    FAIL(0,"失败"),
    SUCCESS(1,"成功"),
    DISABLED_TOEK(2,"token过期"),
    AUTHOR_NO(3,"没有访问权限"),
    USER_NOT("用户信息不存在"),
    PASSWORD_FALSE("密码错误"),
    TYPE_FALSE("文件类型不支持"),
    PROJECT_HAD("项目信息已存在"),
    PROJECT_NOT("项目信息不存在"),
    PROJECTNAME_HAD("项目名已存在"),
    EARLY_MAPPING_HAD("前期测绘已存在"),
    EARLY_MAPPING_NOT("前期测绘不存在"),
    MAPPING_CHECK_HAD("测绘审查已存在"),
    MAPPING_CHECK_NOT("测绘审查不存在"),
    SITE_SURVEY_NOT("现场踏勘不存在"),
    IMPLEMENT_UNIT_NOT("项目实施(施工单位)不存在"),
    SUPERVISION_UNIT_NOT("项目实施(监理单位)不存在"),
    IMPLEMENT_SELF_NOT("施工自验不存在"),
    SUPERVISION_CHECK_NOT("监理验收不存在"),
    WORKEND_MAPPING_NOT("竣工测绘不存在"),
    PLAN_CHECK_NOT("规划设计与实施方案评审不存在"),
    FUKEN_ENTRUST_NOT("复垦委托不存在"),
    WORKEND_CHECK_NOT("竣工测绘审查不存在"),
    COUNTY_ALL_CHECK_NOT("区县验收不存在"),
    AREA_PUBLIC_NOT("面积公示不存在"),
    PROBLEM_NOT("问题记录不存在"),
    LOG_NOT("日志不存在"),
    WRONG_STAGE("错误的施工状态标识"),
    USER_HAD("用户信息已存在"),
    ROLE_NOT("角色信息不存在"),
    APPLAY_NOT("申请信息不存在"),
    EX_NOT("须知信息不存在"),
    ID_NOT("无效的ID"),
    MSG_NOT("查无信息"),
    CHECKMSG_NOT("暂无审核数据"),
    CODE_FALSE("验证码错误"),
    PARAMETER_FALSE("参数错误")

    ;


    public Integer code;
    public String msg;


    Tips(String msg) {
        this.msg = msg;
    }

    Tips(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
