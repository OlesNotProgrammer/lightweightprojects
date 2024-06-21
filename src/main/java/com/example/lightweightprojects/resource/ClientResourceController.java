package com.example.lightweightprojects.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping
public class ClientResourceController {
    private final ResourceService service;

    @GetMapping("/{file}")
    public String resourceRoot(@PathVariable String file) {
        return service.read(file);
    }
    
    @GetMapping("/js/{file}")
    public String resourceJs(@PathVariable String file) {
        return service.readPath("js/", file);
    }
    
    @GetMapping("/js/component/{file}")
    public String resourceJsComponent(@PathVariable String file) {
        return service.readPath("js/component/", file);
    }
    
    @GetMapping("/js/request/{file}")
    public String resourceJsRequest(@PathVariable String file) {
        return service.readPath("js/request/", file);
    }
    
    @GetMapping("/css/{file}")
    public String resourceCss(@PathVariable String file) {
        return service.readPath("css/", file);
    }
    
    @GetMapping("/bootstrap-5.3.3-dist/js/{file}")
    public String resourceBootstrapJs(@PathVariable String file) {
        return service.readPath("bootstrap-5.3.3-dist/js/", file);
    }
    
    @GetMapping("/bootstrap-5.3.3-dist/css/{file}")
    public String resourceBootstrapCss(@PathVariable String file) {
        return service.readPath("bootstrap-5.3.3-dist/css/", file);
    }
}
