package org.example.config;

import org.example.repository.ICatalogRepository;
import org.example.service.ICatalogService;
import org.example.service.impl.CatalogServiceImpl;
import org.example.service.mapper.ICatalogServiceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public ICatalogService catalogService(ICatalogRepository catalogRepository, ICatalogServiceMapper catalogServiceMapper){
        return new CatalogServiceImpl(catalogRepository, catalogServiceMapper);
    }
}
