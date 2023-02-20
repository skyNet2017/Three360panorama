
**简介**

>大家好我是张鹏辉（道长）人如其名，我是天桥上算命的。
http://blog.csdn.net/qingtiangg/article/details/77719606

先看下三种实现的效果：
><font color=red>**1.OpenGL ES**</font>
![实现后的效果故宫全景](http://upload-images.jianshu.io/upload_images/3018588-e3a634aaaf1213aa.gif?imageMogr2/auto-orient/strip)

><font color=red>**2.Google VR（全景图模块）**</font>
![](http://upload-images.jianshu.io/upload_images/3018588-e41f47e628b7ca79.gif?imageMogr2/auto-orient/strip)

><font color=red>**3.Three.js（利用前端姿势）WebView混合开发**</font>
![Three.js（利用前端姿势）WebView混合开发](http://upload-images.jianshu.io/upload_images/3018588-3679b111c22b1a78.gif?imageMogr2/auto-orient/strip)



http://blog.csdn.net/qingtiangg/article/details/77719606



# 如何从exif识别一张图是否为全景图

## 参考1 某文献

> 某文献: https://patents.google.com/patent/CN106649570A/zh

步骤501，读取图片；

步骤502，获得图片的宽高；

步骤503，判断宽度是否大于1000；

步骤504，计算图片的宽高比是否大于等于2:1；

步骤505，计算图片的比例是否小于4:1。

## 参考2: 直接看图片exif

### 谷歌全景相机的图片exif的Xmp

![image-20230220103254429](https://cdn.jsdelivr.net/gh/shuiniuhss/myimages@main/imagemac3/image-20230220103254429.png)

### 大疆无人机exif里的Xmp:

```xml
    │ <?xpacket begin="???" id="W5M0MpCehiHzreSzNTczkc9d"?>
    │ <x:xmpmeta xmlns:x="adobe:ns:meta/">
    │  <rdf:RDF xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
    │   <rdf:Description rdf:about="DJI Meta Data"
    │     xmlns:tiff="http://ns.adobe.com/tiff/1.0/"
    │     xmlns:exif="http://ns.adobe.com/exif/1.0/"
    │     xmlns:xmp="http://ns.adobe.com/xap/1.0/"
    │     xmlns:xmpMM="http://ns.adobe.com/xap/1.0/mm/"
    │     xmlns:dc="http://purl.org/dc/elements/1.1/"
    │     xmlns:crs="http://ns.adobe.com/camera-raw-settings/1.0/"
    │     xmlns:drone-dji="http://www.dji.com/drone-dji/1.0/"
    │     xmlns:GPano="http://ns.google.com/photos/1.0/panorama/"
    │    xmp:ModifyDate="1970-01-01"
    │    xmp:CreateDate="1970-01-01"
    │    tiff:Make="DJI"
    │    tiff:Model="Test_Pro"
    │    dc:format="image/jpg"
    │    drone-dji:GpsLatitude="+25.4923373"
    │    drone-dji:GpsLongitude="+115.0950881"
    │    drone-dji:AbsoluteAltitude="+269.80"
    │    drone-dji:RelativeAltitude="+269.80"
    │    drone-dji:GimbalRollDegree="+0.00"
    │    drone-dji:GimbalYawDegree="-127.70"
    │    drone-dji:GimbalPitchDegree="-0.20"
    │    drone-dji:FlightRollDegree="+4.50"
    │    drone-dji:FlightYawDegree="-129.90"
    │    drone-dji:FlightPitchDegree="+2.50"
    │    drone-dji:CamReverse="0"
    │    drone-dji:GimbalReverse="0"
    │    drone-dji:SelfData=""
    │    GPano:ProjectionType="equirectangular"
    │    GPano:UsePanoramaViewer="True"
    │    GPano:CroppedAreaImageHeightPixels="4096"
    │    GPano:CroppedAreaImageWidthPixels="8192"
    │    GPano:CroppedAreaLeftPixels="0"
    │    GPano:CroppedAreaTopPixels="0"
    │    GPano:FullPanoHeightPixels="4096"
    │    GPano:FullPanoWidthPixels="8192"
    │    crs:Version="7.0"
    │    crs:HasSettings="False"
    │    crs:HasCrop="False"
    │    crs:AlreadyApplied="False">
    │   </rdf:Description>
    │  </rdf:RDF>
    │ </x:xmpmeta>
```



> 推定: 可以使用xmp里是否含有GPano:UsePanoramaViewer="True"标签来判断一张图是否为全景图

### 另外几张全景图

![image-20230220110354091](https://cdn.jsdelivr.net/gh/shuiniuhss/myimages@main/imagemac3/image-20230220110354091.png)

![image-20230220110428965](https://cdn.jsdelivr.net/gh/shuiniuhss/myimages@main/imagemac3/image-20230220110428965.png)

有的干脆就没有exif



再对比大疆

![image-20230220110717404](https://cdn.jsdelivr.net/gh/shuiniuhss/myimages@main/imagemac3/image-20230220110717404.png)

 谷歌全景

![image-20230220110843126](https://cdn.jsdelivr.net/gh/shuiniuhss/myimages@main/imagemac3/image-20230220110843126.png)

> 其他字段并无明显规律,无法作为识别手段.
>
> 只能提供按钮让用户自己点击切换到作为全景图来查看



# google VrPanoramaView

```groovy
api 'com.google.vr:sdk-panowidget:1.180.0'
```

