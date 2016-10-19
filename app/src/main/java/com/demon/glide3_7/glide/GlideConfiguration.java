package com.demon.glide3_7.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;

/**
 * @author Demon
 * @version V1.0
 * @Description: Bitmap格式由RGB_565转换到ARGB_8888
 * @date 2016年10月19日14:26:51
 */
public class GlideConfiguration implements GlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        // 磁盘缓存设定 100MB
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, 104857600));


        // Glide 内部使用了 MemorySizeCalculator 类去决定内存缓存大小以及 bitmap 的缓存池。
        // MemorySizeCalculator默认计算。
        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();

        // 设置 Glide的 RAM缓存大小为 APP的20%。
        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);

        builder.setMemoryCache(new LruResourceCache(customMemoryCacheSize));
        builder.setBitmapPool(new LruBitmapPool(customBitmapPoolSize));

    }

    @Override
    public void registerComponents(Context context, Glide glide) {
    }
}
