package cn.xcom.helper;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.multidex.MultiDex;

import com.baidu.mapapi.SDKInitializer;
import com.easemob.redpacketsdk.RedPacket;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import cn.xcom.helper.chat.DemoHelper;
import cn.xcom.helper.utils.ToolUtil;

/**
 * Created by zhuchongkun on 16/5/27.
 */
public class HelperApplication  extends Application{
    private Context mContext;
    private static HelperApplication instance;
    // login user name
    public final String PREF_USERNAME = "username";
    /**
     * nickname for current user, the nickname instead of ID be shown when user receive notification from APNs
     */
    public static String currentUserNick = "";
    /**
     * 把全国的省市区的信息以json的格式保存
     */
    public static JSONObject mCityJson;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        instance = this;
        //初始化Fresco
        Fresco.initialize(mContext);
        //初始化地图
        SDKInitializer.initialize(mContext);
        //初始化ImageLoader
        initImageLoader(mContext);
        //初始化城市数据
        initJsonData();
        //初始化聊天
//        initChat();
        //初始化聊天
        DemoHelper.getInstance().init(mContext);
        RedPacket.getInstance().initContext(mContext);
    }
    public static HelperApplication getInstance() {
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    private void initChat() {
        int pid = android.os.Process.myPid();
        String processAppName = getAppName(pid);
        if (processAppName == null ||!processAppName.equalsIgnoreCase(mContext.getPackageName())) {
            // 则此application::onCreate 是被service 调用的，直接返回
            return;
        }
        EMOptions options = new EMOptions();
        // 默认添加好友时，是不需要验证的，改成需要验证
        options.setAcceptInvitationAlways(false);
        //初始化
        EMClient.getInstance().init(mContext, options);
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true);
    }

    private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = this.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
                // Log.d("Process", "Error>> :"+ e.toString());
            }
        }
        return processName;

    }

    /**
     * 从assert文件夹中读取省市区的json文件，然后转化为json对象
     */
    private void initJsonData(){
        try {
            String s=ToolUtil.readFromAsset(mContext,"city.json");
            if(s!=null){
                mCityJson=new JSONObject(s);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void initImageLoader(Context mContext){
//        File cacheDir = StorageUtils.getOwnCacheDirectory(mContext,"caterin/Cache");
//        // LruCache通过构造函数传入缓存值，以KB为单位。
//        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
//        // 使用最大可用内存值的1/8作为缓存的大小。
//        int cacheSize = maxMemory / 8;
        // 创建配置ImageLoader(所有的选项都是可选的,只使用那些你真的想定制)，这个可以设定在APPLACATION里面，设置为全局的配置参数
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(mContext)
//                .memoryCacheExtraOptions(480, 800)
//                .threadPoolSize(3)// 线程池内加载的数量
//                .threadPriority(Thread.NORM_PRIORITY - 1).tasksProcessingOrder(QueueProcessingType.FIFO) // default
//                .denyCacheImageMultipleSizesInMemory().memoryCache(new UsingFreqLimitedMemoryCache(cacheSize))
//                // You can pass your own memory cache
//                .memoryCache(new LruMemoryCache(cacheSize)).memoryCache(new WeakMemoryCache())
//                // implementation你可以通过自己的内存缓存实现
//                .memoryCacheSize(cacheSize).memoryCacheSizePercentage(13) // default
//                .discCacheSize(cacheSize)
//                // .discCacheFileNameGenerator(new Md5FileNameGenerator())
//                // 将保存的时候的URI名称用MD5加密
//                // .discCacheFileNameGenerator(new
//                // HashCodeFileNameGenerator())// 将保存的时候的URI名称用HASHCODE加密
//                .tasksProcessingOrder(QueueProcessingType.LIFO).discCacheFileCount(1000) // 缓存的File数量
//                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()).imageDownloader(new BaseImageDownloader(mContext, 5 * 1000, 30 * 1000))
//                // connectTimeout (5s), readTimeout(30s)超时时间
//                .writeDebugLogs() // Remove for release app
//                .build();
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(mContext);
        ImageLoader.getInstance().init(configuration);// 全局初始化此配置
    }
}
