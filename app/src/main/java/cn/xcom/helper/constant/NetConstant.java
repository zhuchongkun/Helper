package cn.xcom.helper.constant;

/**
 * Created by zhuchongkun on 16/5/29.
 */
public interface NetConstant extends HelperConstant {
    /**
     *注册
     */
    public final static String NET_REGISTER=NET_HOST_PREFIX+"a=AppRegister&";
    /**
     * 登录
     */
    public final static String NET_LOGIN=NET_HOST_PREFIX+"a=applogin&";
    /**
     * 验证用户是否注册
     */
    public final static String NET_CHECK_PHONE=NET_HOST_PREFIX+"a=checkphone&";
    /**
     * 发送验证码
     */
    public final static String NET_GET_CODE=NET_HOST_PREFIX+"a=SendMobileCode&";
    /**
     * 修改密码
     */
    public final static String NET_RESET_PASSWORD=NET_HOST_PREFIX+"a=forgetpwd&";
    /**
     * 获取个人资料
     */
    public final static String NET_GET_USER_INFO=NET_HOST_PREFIX+"a=getuserinfo&";
    /**
     * 上传图片
     */
    public final static String NET_UPLOAD_IMG=NET_HOST_PREFIX+"a=uploadimg";
    /**
     * 图片路径
     */
    public final static String NET_DISPLAY_IMG=NET_HOST+"/uploads/images/";
    /**
     * 修改头像
     */
    public final static  String NET_UPDATE_HEAD=NET_HOST_PREFIX+"a=UpdateUserAvatar&";
    /**
     * 修改性别
     */
    public final static String NET_UPDATE_GENDER=NET_HOST_PREFIX+"a=UpdateUserSex&";
    /**
     * 修改城市
     */
    public final static String NET_UPDATE_CITY=NET_HOST_PREFIX+"a=UpdateUserCity&";
    /**
     * 修改姓名
     */
    public final static String NET_UPDATE_NAME=NET_HOST_PREFIX+"a=UpdateUserName&";
    /**
     * 通过用户编号获取身份认证状态
     */
    public final static String NET_GET_IDENTITY=NET_HOST_PREFIX+"a=getAuthRecord&";
    /**
     * 身份认证
     */
    public final static String NET_IDENTITY_AUTHENTICATION=NET_HOST_PREFIX+"a=Authentication&";
    /**
     * 获取任务分类列表
     */
    public final static String NET_GET_TASKLIST=NET_HOST_PREFIX+"a=getTaskTypeList&";
    /**
     * 获取我的今天是否签到
     */
    public final static String NET_GET_SIGN_STATE=NET_HOST_PREFIX+"a=GetMySignLog";
    /**
     * 签到
     */
    public final static String NET_TO_SIGN=NET_HOST_PREFIX+"a=SignDay";
    /**
     * 获取我的钱包
     */
    public final static String NET_GET_WALLET=NET_HOST_PREFIX+"a=GetMyWallet";
    /**
     *获取我的收支记录
     */
    public final static String NET_GET_WALLET_LOG=NET_HOST_PREFIX+"a=GetMyWalletLog";
    /**
     *获取我的体现申请记录
     */
    public final static String NET_GET_WITHDRAW_LOG=NET_HOST_PREFIX+"a=GetMyWithdrawLog";
    /**
     * 获取认证帮列表
     */
    public final static String NET_GET_AUTHENTICATION_LIST=NET_HOST_PREFIX+"a=getAuthenticationUserList";

}
