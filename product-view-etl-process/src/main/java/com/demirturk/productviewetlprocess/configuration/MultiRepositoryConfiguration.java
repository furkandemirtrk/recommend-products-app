package com.demirturk.productviewetlprocess.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.demirturk.productviewetlprocess.repository.jpa")
@EnableMongoRepositories(basePackages = "com.demirturk.productviewetlprocess.repository.mongo")
public class MultiRepositoryConfiguration {
}
