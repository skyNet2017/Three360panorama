package com.zph.three360panorama;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.zph.glpanorama.GLPanorama;
/**
 * Created by 張鵬輝 on 2017/8/29.
 *
 * E-mail: 1344670918@qq.com
 *
 * CSDN: http://blog.csdn.net/QingTianGG
 *
 * 有问题欢迎随时来找我共同解决
 */
public class OpenGLActivity extends AppCompatActivity {
    private GLPanorama mGLPanorama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_gl);
        mGLPanorama= (GLPanorama) findViewById(R.id.mGLPanorama);
        //传入全景图片
        mGLPanorama.setGLPanorama(
                //R.drawable.imggugong
                 R.drawable.pxl_20230218_093146894_photosphere
                //R.drawable.dji_fly_20230124_144636_723_1674542817436_pano
        );
    }

}
