package org.s3valkov.cooking4love.config;

import org.s3valkov.cooking4love.web.interceptors.FaviconInterceptor;
import org.s3valkov.cooking4love.web.interceptors.TitleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationWebConfiguration implements WebMvcConfigurer {

   private final TitleInterceptor interceptor;
    private final FaviconInterceptor faviconInterceptor;

    @Autowired
    public ApplicationWebConfiguration(TitleInterceptor interceptor, FaviconInterceptor faviconInterceptor) {
        this.interceptor = interceptor;
        this.faviconInterceptor = faviconInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.interceptor);
        registry.addInterceptor(this.faviconInterceptor);
    }
}
