package com.example.cachedemo.config;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheEventLogger
        implements CacheEventListener <Object, Object> {

    private static final Logger logger = LoggerFactory.getLogger(CacheEventLogger.class);

// let's also add the cache event listener which logs both CREATED and EXPIRED cache events:
    @Override
    public void onEvent(
            CacheEvent <? extends Object, ? extends Object> cacheEvent) {
        logger.info("key:{}|old-value:{}|new-value:{}", cacheEvent.getKey(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
    }
}
