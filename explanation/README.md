https://www.baeldung.com/spring-boot-ehcache

As you can see in the attached images, the initial call takes 4+ seconds to respond. But the next call took only 12ms which is super fast.

Caching works very when you are using @Cacheable, @CachePut, @CacheEvict annotations in proper way