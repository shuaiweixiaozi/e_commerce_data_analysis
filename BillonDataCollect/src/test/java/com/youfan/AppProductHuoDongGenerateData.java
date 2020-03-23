package com.youfan;

import com.alibaba.fastjson.JSONObject;
//import com.youfan.enums.LogType;
//import com.youfan.input.AppProductHuoDong;
//import com.youfan.input.AppProductLog;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class AppProductHuoDongGenerateData {
//    static Random random = new Random();
//    private static int[] days  = new int[]{3,4,5,6};
//    private static String[] userIds = new String[]{"1","2"};
//    private static String[] deviceIds = new String[]{"deviceId1","deviceId2"};
//    static long openTimeStamp = genernateDateData(new Date());
//    private static String openTimeStampstring = openTimeStamp+"";//打开时间
//    private static String leaveTimeStamp = (openTimeStamp+10*1000l)+"";//退出时间
//    private static String[] appPlatforms = new String[]{"andriod","ios"};//平台，安卓，IOS
//    private static String[] deviceStyles = new String[]{"红米6","小米7","华为荣耀6"};//型号
//    private static String[] brands = new String[]{"华为","小米","苹果"};//品牌
//    private static String[] screenSizes = new String[]{"200*400","600*1000"} ;//分辨率
//    private static String[] osTypes = new String[]{"andriod4.5","andriod5.6","ios5","iso6","iso7"};//操作系统
//
//    private static String[] huodongIds = new String []{"1","2","3"};//活动id
//
//    static long scantimeStamp = genernateDateData(new Date());
//    private static String scantime = scantimeStamp+"";//浏览的时间
//    private static String jumpTime = (scantimeStamp+5*1000l)+"";//跳出商品的时间
//    private static String[] ips = new String[]{"192.168.4.5","192.168.4.6"};//用户app访问的ip
//    private static String[] countrys = new String[]{"china"};//国家
//    private static String[] provinces = new String[]{"guangdong","beijing","shanghai"};//省
//    private static String[] citys = new String[]{"shenzheng","beijing","shanghai"};//市
//    private static String[] networks = new String[]{"wifi","4G"};//网络方式
//    private static String[] yunYinShangs = new String[]{"联通","移动","电信"};//运营商
//    private static String[] appVersions = new String[]{"4.5.1","4.5.6","6.7.4"};//app版本
//    private static String[] appChannels = new String[]{"安卓市场","小米市场"};//渠道
//
//
//
//    private static AppProductHuoDong genernateData(){
//        AppProductHuoDong appProductHuoDong = new AppProductHuoDong();
//        appProductHuoDong.setUserId(userIds[random.nextInt(userIds.length)]);
//        appProductHuoDong.setDeviceId(deviceIds[random.nextInt(deviceIds.length)]);
//        appProductHuoDong.setAppPlatform(appPlatforms[random.nextInt(appPlatforms.length)]);
//        appProductHuoDong.setDeviceStyle(deviceStyles[random.nextInt(deviceStyles.length)]);
//        appProductHuoDong.setBrand(brands[random.nextInt(brands.length)]);
//        appProductHuoDong.setScreenSize(screenSizes[random.nextInt(screenSizes.length)]);
//        appProductHuoDong.setOsType(osTypes[random.nextInt(osTypes.length)]);
//        appProductHuoDong.setHuodongId(huodongIds[random.nextInt(huodongIds.length)]);
//        appProductHuoDong.setIp(ips[random.nextInt(ips.length)]);
//        appProductHuoDong.setCountry(countrys[random.nextInt(countrys.length)]);
//        appProductHuoDong.setProvince(provinces[random.nextInt(provinces.length)]);
//        appProductHuoDong.setCity(citys[random.nextInt(citys.length)]);
//        appProductHuoDong.setNetwork(networks[random.nextInt(networks.length)]);
//        appProductHuoDong.setYunYinShang(yunYinShangs[random.nextInt(yunYinShangs.length)]);
//        appProductHuoDong.setAppVersion(appVersions[random.nextInt(appVersions.length)]);
//        appProductHuoDong.setAppChannel(appChannels[random.nextInt(appChannels.length)]);
//        appProductHuoDong.setOpenTimeStamp(openTimeStampstring);
//        appProductHuoDong.setLeaveTimeStamp(leaveTimeStamp);
//        appProductHuoDong.setScantime(scantime);
//        appProductHuoDong.setJumpTime( jumpTime);
//        appProductHuoDong.setLogType(LogType.APPHUODONG);
//        return  appProductHuoDong;
//
//    }
//
//    private static long genernateDateData(Date date){
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.set(Calendar.DAY_OF_MONTH,-days[random.nextInt(days.length)]);
//        long resultTime = calendar.getTime().getTime();
//        return resultTime;
//    }
//    private static void postHttpMethod(String urlpath,String data){
//        try {
//            URL url = new URL(urlpath);
//            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
//            urlConnection.setRequestMethod("POST");
//            urlConnection.setDoInput(true);
//            urlConnection.setDoOutput(true);
//            urlConnection.setInstanceFollowRedirects(true);
//            urlConnection.setUseCaches(true);
//            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0");
//            urlConnection.setRequestProperty("Content-Type", "application/json");
//            urlConnection.setConnectTimeout(1000 * 5);
//            urlConnection.connect();
//            OutputStream outputStream = urlConnection.getOutputStream();
//            outputStream.write(data.getBytes("utf-8"));
//            outputStream.flush();
//            outputStream.close();
//            InputStream inputStream = urlConnection.getInputStream();
//            int httpCode = urlConnection.getResponseCode();
//            byte[] inputdata = new byte[1024];
//            StringBuffer stringBuffer = new StringBuffer();
//            while(inputStream.read(inputdata,0,1024) != -1){
//                stringBuffer.append(new String (inputdata));
//            }
//            System.out.println(httpCode);
//            System.out.println(stringBuffer.toString());
//            inputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public static void main(String[] args) {
//        for(int i =0;i<50;i++) {
//            AppProductHuoDong appProductHuoDong = genernateData();
//            System.out.println(JSONObject.toJSON(appProductHuoDong));
//            postHttpMethod("http://127.0.0.1:8081/collectAppData", JSONObject.toJSONString(appProductHuoDong));
//        }
//    }
}
