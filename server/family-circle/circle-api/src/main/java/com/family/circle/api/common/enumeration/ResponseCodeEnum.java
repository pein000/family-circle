package com.family.circle.api.common.enumeration;

/**
 * @author zuo
 */
public enum ResponseCodeEnum {

    /**
     * 通用
     */
    SUCCESS("0", "成功"),
    SYSTEM_LOADING("-1000", "系统加载中。。。"),
    SYSTEM_EXCEPTION("999", "系统异常"),

    USER_NOT_EXIST("102", "账号不存在"),
    PASSWORD_ERROR("103", "密码错误"),
    USER_IS_DISABLED("104", "账号已被禁用，请联系管理员"),
    NOT_LOGIN("105", "未登录"),
    LOGIN_OVERDUE("106", "登录过期"),
    SESSION_INVALID("107", "会话过期"),
    USER_LOGIN_ERROR("108", "登录异常"),
    NO_PERMISSION("109", "无访问权限，请联系管理员申请"),
    OLD_PASSWORD_NOT_CORRECT("110", "旧密码不正确"),
    ADMIN_SHOULD_NOT_CHANGE("111", "超级管理员不能被修改"),
    ADMIN_ROLE_SHOULD_NOT_CHANGE("112", "超级管理员角色不能被修改"),
    AUTHORITY_NAME_HAS_EXIST("113", "权限名已存在"),
    USERNAME_EXIST("114", "用户名已存在"),
    NETWORK_ERROR("115", "网络异常"),
    NO_PERMISSION_ADD_ADMIN_ROLE("116", "没有权限新增超级管理员"),
    ADMIN_USERNAME_NOT_CHANGE("117", "管理员账号不能修改"),
    ADMIN_USERNAME_NOT_NULL("118", "管理员账号不能为空"),
    PWD_ONLY_SELF("119", "密码只能用户自己修改"),
    ROLE_NOT_CHANGE("120", "角色不能修改会删除"),
    NO_VALID_ORG("121", "未关联有效的企业或机构，请联系管理员"),
    ROLE_NOT_EXISTS("122", "角色不存在"),

    PARAM_ERROR("201", "参数错误"),
    DATA_NOT_EXISTS("202", "数据不存在"),
    FILES_NOT_EXISTS("203", "文件不存在"),
    FILE_NOT_SUPPORT("204", "文件格式不支持"),
    FILE_OVERSIZE("205", "文件太大"),
    DOWNLOAD_ERROR("206", "文件下载失败"),
    UPLOAD_ERROR("207", "文件上传失败"),
    DATA_EXISTS("208", "数据已存在"),

    COMPANY_EXIST("301", "企业已存在"),
    STRUCTURE_EXIST("302", "组织架构已存在"),
    QCC_ERROR("303", "调用企查查接口异常，请联系管理员"),
    COMPANY_CODE_NULL("304", "企业编码不能为空"),
    IDNO_EXIST("305", "身份证号码已存在"),
    STRUCTURE_CHILDREN_EXIST("306", "存在下级架构，需先删除下级"),
    POSITION_RISK_EXIST("307", "该岗位下已存在此风险因素"),
    CONFIG_DATA_ERROR("308", "配置数据异常"),
    DATA_PROCESSING("309", "数据处理中"),

    ITEM_NOT_EXISTS("401", "记录不存在"),
    MOBILEPHONE_EXISTS("402", "手机号已存在"),
    NOT_COMPLETE_PRE_EXAMINE("501", "您还未完成的履职考核前工作，请完成后再发起履职考核"),
    NOT_COMPLETE_EXAMINE("502", "今日履职考核未完成，请完成后再发起安全承诺"),
    STATION_RISK_EXAMINE_EXIST("503", "该岗位下今日履职考核已完成"),
    COMPANY_NOT_EXIST("601", "企业不存在"),
    COMPANY_PIPELINE_CONFIG_NOT_EXISTS("701", "企业审批流配置未找到审批人"),

    // 第三方评价机构
    EVALUATION_ORG_NOT_EXISTS("1001", "机构不存在"),
    EVALUATION_ORG_CODE_FORBID_UPDATE("1002", "机构代码不能修改"),
    EVALUATION_ORG_ADMIN_FORBID_UPDATE("1003", "机构管理员账号不能修改"),
    EVALUATION_ORG_VALID_NOT_UPDATE("1004", "机构状态不能在编辑时修改"),
    EVALUATION_ORG_CODE_EXIST("1005", "机构代码已存在"),
    EVALUATION_ORG_NAME_EXIST("1006", "机构名称已存在"),

    EVALUATION_PROJECT_EXIST("1101", "项目不存在"),
    NOT_EDIT_AUDITOR_FIRST("1102", "相互一审已通过，不能修改一审人员"),
    NOT_REPEAT_AUDITOR("1103", "一审人员和二审人员不能相同"),
    NOT_REPEAT_OWNER("1104", "审核人员和项目负责人不能相同"),
    NOT_OWNER("1105", "请先设置项目负责人"),
    PROJECT_FINISHED("1106", "项目已完成"),
    NULL_ORGCODE_UN_AUTH_VIEW("1107", "无权限查看项目进度"),
    PROJECT_AMOUNT_NEED_GT_ADVANCE("1108", "预收款金额不得大于项目金额"),
    PROJECT_STATUS_NOT_SUBMIT_REPORT("1109", "当前状态不可提交报告"),
    PROJECT_PROCESS_EMPTY("1110", "过程文件数据不能为空"),
    PROJECT_ID_NOT_NULL("1111", "项目文件不能为空"),
    AMOUNT_NOT_GT_PROJECT("1112", "预收款金额+到账金额不得大于项目金额"),
    AUDIT_REJECT_NEED_MEMO("1113", "审核被拒需要填写被拒原因"),
    PROJECT_STATUS_NOT_AUDIT_REPORT("1114", "当前状态不可审核报告"),
    COMMISSION_RATE_ERROR("1115", "提成比例不得大于100%"),
    MUST_SELF("1116", "非管理员账户，只能查看本人数据"),
    RISK_EVALUATE_NOT_EXISTS("1117", "风险评估记录不存在！"),
    RISK_EVALUATE_TYPE_NOT_EXISTS("1117", "风险评估类型不存在！"),
    RISK_NEED_NOT_IDENTIFY("1118", "该风险因素无需评估！"),
    PROJECT_CODE_EXIST("1119", "对应合同编号下项目编号已存在"),
    PROJECT_CODE_SUBMIT_EXIST("1120", "提交信息中项目编号不能重复"),

    ;

    /**
     * 返回码
     */
    private final String code;

    /**
     * 返回信息
     */
    private final String msg;

    ResponseCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "[" + this.code + "]" + this.msg;
    }
}
