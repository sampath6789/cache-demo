We can see the details of the cache using below actuator endpoint

data to below response will load when we make the first api call and cache ge loaded. once restarted cacheManagers object
get empty

https://localhost:8001/actuator/caches

{
    "cacheManagers": {
        "cacheManager": {
            "caches": {
                "books": {
                    "target": "java.util.concurrent.ConcurrentHashMap"
                },
                "square-cache": {
                    "target": "java.util.concurrent.ConcurrentHashMap"
                }
            }
        }
    }
}


https://localhost:8001/actuator/caches/square-cache

{
    "target": "java.util.concurrent.ConcurrentHashMap",
    "name": "square-cache",
    "cacheManager": "cacheManager"
}

The actual content of the cache can not be read due to security reasons