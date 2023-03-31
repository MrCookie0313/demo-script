package com.example.demoscript.util;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.nio.charset.Charset;

@Component
public class BloomFilterUtil {
    /**
     * expectedInsertions：期望添加的数据个数
     * fpp：期望的误判率，期望的误判率越低，布隆过滤器计算时间越长
     * @return
     */
    @Bean
    public BloomFilter<String> goodsIDBloom(){
        BloomFilter<String> filter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 1000,0.00001);
        return filter;
    }

    @Bean
    public BloomFilter<String> orderBloom(){
        BloomFilter<String> filter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 1000,0.00001);
        return filter;
    }
}
