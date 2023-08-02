package az.ingress.msredis.controller;

import az.ingress.msredis.model.UserDto;
import az.ingress.msredis.service.CacheService;
import az.ingress.msredis.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * @author caci
 */

@RestController
@RequestMapping("/v1/test-cache")
@RequiredArgsConstructor
@Tag(name = "Cache", description = "the Cache test api")
public class CacheTestController {

    private final CacheService service;

    @GetMapping
    @Operation(summary = "test save to cache", description = "test save to cache", tags = {"Cache"})
    public void addToCache(){
        service.addToCache();
    }

    @GetMapping
    @Operation(summary = "test get form cache", description = "test get form cache", tags = {"Cache"})
    public void getFromCache(){
        service.getFromCache();
    }

}
