package com.keroro.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangpeng
 * @since 2024年01月22日 19:01
 */
@RestController
public class DcController {

    private final Logger logger = LoggerFactory.getLogger(DcController.class);

    private final DiscoveryClient discoveryClient;

    public DcController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/dc")
    public String dc(HttpServletRequest request) {
        logger.info("eureka-client，触发了/dc");
        logger.info("=== traceContent: TraceId={}, SpanId={}, parentSpanId={}, sampled={}, spanName={} ===",
                request.getHeader("X-B3-TraceId"),
                request.getHeader("X-B3-SpanId"),
                request.getHeader("X-B3-ParentSpanId"),
                request.getHeader("X-B3-Sampled"),
                request.getHeader("X-Span-Name"));
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}
