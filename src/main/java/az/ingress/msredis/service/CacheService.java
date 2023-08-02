package az.ingress.msredis.service;

import az.ingress.msredis.model.UserDto;
import az.ingress.msredis.util.CacheUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

import static org.aspectj.runtime.internal.Conversions.shortValue;

@Service
@RequiredArgsConstructor
@Slf4j
public class CacheService {

    private final CacheUtil cacheUtil;

    public void addToCache(){
        var pin = "123";
        cacheUtil.saveToCache("ms-user-" + pin,
                new UserDto(1L, "Javid", (short) 27), 1L, ChronoUnit.HOURS);
    }

    public void getFromCache(){
        var pin = "123";
        var user = cacheUtil.getBucket("ms-user-" + pin);
        log.info("user-> {}", user);
    }
}
