package cn.com.tianyudg.mvpdemo.mvp.network;


public class ApiConfig {
    public static final String HOST = "http://dongguan.huifang.cn/";//测试环境
//    public static final String HOST = "http://dg.huifang.cn/";//正式环境

    //登录
    public static final String API_LOGIN = "api/Dealer_userLogin";

    //首页新房列表
    public static final String API_HOME_NEW_LIST = "api/Dealer_estateList";
    //新房详情
    public static final String API_HOME_NEW_DETAIL = "api/Dealer_estateDetail";
    //首页二手房列表
    public static final String API_HOME_SECOND_HAND_LIST = "api/Dealer_estateList_fang";
    //二手房详情
    public static final String API_HOME_SECOND_HAND_DETAIL = "api/Dealer_estateDetail_fang";
    //首页租房列表
    public static final String API_HOME_RENT_LIST = "api/Dealer_estateList_rent";
    //首页租房详情
    public static final String API_HOME_RENT_DETAIL = "api/Dealer_estateDetail_rent";
    //首页渠道团队
    public static final String API_HOME_CHANNEL_TEAM_LIST = "api/Dealer_QD_teamList";
    //首页筛选列表
    public static final String API_SUBJECT_FILTER_LIST = "api/publicLabelAndStandardData";
    //地区筛选列表
    public static final String API_REGION_LIST_FILTER = "api/publicRegionList";


    //项目新房列表
    public static final String API_PROJECT_NEW_LIST = "api/Dealer_projectDistributeList_estate";
    //项目二手房列表
    public static final String API_PROJECT_SECOND_HAND_LIST = "api/Dealer_projectDistributeList_fang";
    //项目租房列表
    public static final String API_PROJECT_RENT_LIST = "api/Dealer_projectDistributeList_rent";
    //添加项目
    public static final String API_ADD_PROJECT = "api/Dealer_addProject";
    //上传图片
    public static final String API_UPLOAD_IMAGE = "http://dongguan.huifang.cn/api/publicUpload";

    //渠道-公司列表
    public static final String API_COMPANY_LIST = "api/Dealer_QD_company";
    //渠道-门店列表
    public static final String API_STORE_LIST = "api/Dealer_QD_mendian";
    //渠道-团队列表
    public static final String API_TEAM_LIST = "api/Dealer_QD_team";
    //渠道-经纪人列表
    public static final String API_AGENT_LIST = "api/Dealer_QD_agent";
    //渠道-添加渠道
    public static final String API_ADD_CHANNEL = "api/Dealer_addQD";
    //门店详情
    public static final String API_STORE_DETAIL = "api/Dealer_mendianDetail";
    //公司详情
    public static final String API_COMPANY_DETAIL = "api/Dealer_companyDetail";
    //经纪人详情
    public static final String API_AGENT_DETAIL = "api/Dealer_agentDetail";

    //我的-用户信息
    public static final String API_USER_INFO = "api/Dealer_userInfo";
    //我的-代理列表
    public static final String API_MY_AGENT_LIST = "api/Dealer_dailiList";
    //我的-代理列表
    public static final String API_MY_EMPLOYEE_LIST = "api/Dealer_dailiDetail";
    //我的-门店分配
    public static final String API_MY_STORE_DISTRIBUTE_LIST = "api/Dealer_employeeMendians";
    //我的-门店绑定员工
    public static final String API_MY_STORE_BIND_EMPLOYEE = "api/Dealer_mendianTieEmployee";
    //我的-添加代理
    public static final String API_ADD_AGENT = "api/Dealer_addDaili";
    //我的-添加员工
    public static final String API_ADD_EMPLOYEE = "api/Dealer_addEmployee";
    //我的提现记录列表
    public static final String API_WITHDRAW_RECORD_LIST = "api/Dealer_userFinance_withdraw";
    // 我的钱包
    public static final String API_MY_WALLET = "api/Dealer_userFinance";

    // 我的银行卡列表
    public static final String API_MY_BANK_CARD_LIST = "api/Dealer_userBankCardList";
    //申请提现页面
    public static final String API_APPLY_WITHDRAW = "api/Dealer_userWithdraw";
    //申请提现成功
    public static final String API_APPLY_WITHDRAW_SUCCESS = "api/Dealer_userWithdraw_success";

    //我的账单列表
    public static final String API_MY_BILL_LIST = "api/Dealer_userBill";
    //绑定银行卡
    public static final String API_BIND_BANK_CARD = "api/Dealer_userSaveCard";

    //登出
    public static final String API_LOGOUT = "api/Dealer_userLogout";
    //修改登录密码
    public static final String API_RESET_LOGIN_PSW = "api/Dealer_userResetPassword";
    //绑定新手机
    public static final String API_BIND_NEW_PHONE = "api/Dealer_userSetMobile";
    //修改支付密码
    public static final String API_RESET_PAY_PSW = "api/Dealer_userResetPaypass";
    //修改支付密码
    public static final String API_FIND_BACK_PAY_PSW = "api/Dealer_userFindPaypass";

}

