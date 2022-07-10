package com.questgames.monster.tactics.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan("com.questgames.monster.tactics")
@EnableJpaRepositories("com.questgames.monster.tactics")
@EnableAsync
@EnableTransactionManagement
public class EntityConfiguration {
}
