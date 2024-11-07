package com.zxx17.couple.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis的配置处理类。
 * 该类负责配置RedisTemplate，以确保Redis中的数据可以正确地进行序列化和反序列化。
 */
@Configuration
public class RedisConfig {

    /**
     * 创建并配置RedisTemplate bean。
     * 该bean将用于与Redis进行交互，包括读取和写入数据。
     *
     * @param redisConnectionFactory Redis连接工厂，用于创建Redis连接
     * @return 配置好的RedisTemplate对象
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 设置Redis连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 创建字符串序列化器，用于键的序列化
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        // 设置键的序列化器
        redisTemplate.setKeySerializer(redisSerializer);
        // 设置哈希键的序列化器
        redisTemplate.setHashKeySerializer(redisSerializer);
        // 设置值的序列化器，使用Jackson2JsonRedisSerializer进行JSON序列化
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer());
        // 设置哈希值的序列化器，同样使用Jackson2JsonRedisSerializer
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer());
        return redisTemplate;
    }

    /**
     * 创建并配置Jackson2JsonRedisSerializer。
     * 该序列化器将用于将对象转换为JSON格式的字符串，并将其存储在Redis中。
     *
     * @return 配置好的Jackson2JsonRedisSerializer对象
     */
    private Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer() {
        // 创建ObjectMapper对象，用于配置JSON序列化和反序列化的行为
        ObjectMapper objectMapper = new ObjectMapper();
        // 设置属性可见性，使所有属性都可被序列化和反序列化
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 关闭未知属性导致的反序列化失败
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 启用默认类型，以便在序列化时包含类型信息
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        // 使用构造函数传递ObjectMapper实例
        return new Jackson2JsonRedisSerializer<>(objectMapper, Object.class);
    }

}