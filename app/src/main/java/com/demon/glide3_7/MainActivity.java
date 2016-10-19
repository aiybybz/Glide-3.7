package com.demon.glide3_7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.demon.glide3_7.glide.CircleTransform;
import com.demon.glide3_7.glide.CornersTransform;

public class MainActivity extends AppCompatActivity {

    private ImageView ivP1;
    private ImageView ivP2;
    private ImageView ivP3;
    private ImageView ivP4;
    private ImageView ivP5;
    private ImageView ivP6;
    private ImageView ivP7;
    private ImageView ivP8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        useGlide1();
        useGlide2();
        useGlide3();
        useGlide4();
        useGlide5();
        useGlide7();
        useGlide8();
    }

    private void initView() {
        ivP1 = (ImageView) findViewById(R.id.ivP1);
        ivP2 = (ImageView) findViewById(R.id.ivP2);
        ivP3 = (ImageView) findViewById(R.id.ivP3);
        ivP4 = (ImageView) findViewById(R.id.ivP4);
        ivP5 = (ImageView) findViewById(R.id.ivP5);
        ivP6 = (ImageView) findViewById(R.id.ivP6);
        ivP7 = (ImageView) findViewById(R.id.ivP7);
        ivP8 = (ImageView) findViewById(R.id.ivP8);
    }

    /**
     * Glide基础使用 1
     */
    private void useGlide1() {
        Glide.with(this)
                .load("http://223.100.159.225:8081/image/c_mall_banner_002.png")
                .into(ivP1);
    }

    /**
     * Glide改变缓存策略
     */
    private void useGlide2() {
        Glide.with(this)
                .load("http://223.100.159.225:8081/image/c_mall_banner_002.png")
                // 既缓存全尺寸又缓存其他尺寸
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivP2);
    }

    /**
     * Glide图像缩放
     */
    private void useGlide3() {
        Glide.with(this)
                .load("http://223.100.159.225:8081/image/c_mall_banner_002.png")
                // 图像缩放
                .override(200, 200)
                .into(ivP3);
    }

    /**
     * Glide中心裁剪
     */
    private void useGlide4() {
        Glide.with(this)
                .load("http://223.100.159.225:8081/image/c_mall_banner_002.png")
                // 中心裁剪
                .centerCrop()
                .into(ivP4);
    }

    /**
     * Glide设置占位图或者加载错误图
     */
    private void useGlide5() {
        Glide.with(this)
                .load("http://223.100.159.225:8081/image/c_mall_banner_002.png")
                // 占位图
                .placeholder(R.mipmap.ic_launcher)
                // 加载错误图
                .error(R.mipmap.ic_launcher)
                .into(ivP5);
    }

    /**
     * Glide加载GIF
     */
    private void useGlide6() {
        Glide.with(this)
                .load("http://jcodecraeer.com/uploads/20150327/1427445366503084.gif")
                .into(ivP6);
    }

    /**
     * Glide 加载圆形图片
     */
    private void useGlide7() {
        Glide.with(this)
                .load("http://223.100.159.225:8081/image/c_mall_banner_002.png")
                .transform(new CircleTransform(this))
                .into(ivP7);
    }

    /**
     * Glide 加载圆角图片
     */
    private void useGlide8() {
        Glide.with(this)
                .load("http://223.100.159.225:8081/image/c_mall_banner_002.png")
                .transform(new CornersTransform(this))
                .into(ivP8);
    }

}