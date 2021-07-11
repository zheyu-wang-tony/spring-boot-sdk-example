package com.example.multimodule.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class CommandBeanFactoryProcessor extends BaseBeanFactoryPostProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandBeanFactoryProcessor.class);

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        final BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) beanFactory;
        Set<BeanDefinition> beanDefinitionSet = scanComponents(CommandHandler.class);
        LOGGER.info("Scanning for command handlers found {} beans", beanDefinitionSet.size());

        for (BeanDefinition beanDefinition : beanDefinitionSet) {
            BeanDefinitionBuilder builder = BeanDefinitionBuilder
                    .genericBeanDefinition(beanDefinition.getBeanClassName())
                    .setInitMethodName("register")
                    .addPropertyReference("commandDispatcher", "commandDispatcherImpl");

            beanDefinitionRegistry.registerBeanDefinition(
                    beanDefinition.getBeanClassName(), builder.getBeanDefinition());
        }
    }
}
