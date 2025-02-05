/**
 * Copyright 2006-2015 handu.com
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.handu.open.dubbo.monitor.config;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * DubboConfig
 *
 * @author Jinkai.Ma
 */
@Configuration
@DubboComponentScan(basePackages = "com.handu.open.dubbo.monitor")
public class DubboConfig {
    
    private static final String REGISTRY_PROTOCOL = "dubbo.registry.protocol";
    private static final String REGISTRY_ADDRESS = "dubbo.registry.address";
    private static final String REGISTRY_CLIENT = "dubbo.registry.client";
    private static final String APPLICATION_NAME = "dubbo.application.name";
    private static final String APPLICATION_OWNER = "dubbo.application.owner";
    private static final String PROTOCOL_PORT = "dubbo.protocol.port";

    @Autowired
    private Environment env;

//    @Bean
//    public static Annotation annotationBean() {
//        AnnotationBean annotationBean = new AnnotationBean();
//        annotationBean.setPackage("com.handu.open.dubbo.monitor");
//        AnnotationUtils.
//        return annotationBean;
//    }

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(env.getProperty(APPLICATION_NAME, "dubbo-monitor"));
        applicationConfig.setOwner(env.getProperty(APPLICATION_OWNER));
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol(env.getProperty(REGISTRY_PROTOCOL, "dubbo"));
        registryConfig.setAddress(env.getProperty(REGISTRY_ADDRESS));
        registryConfig.setClient(env.getProperty(REGISTRY_CLIENT));
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig("dubbo");
        protocolConfig.setPort(Integer.parseInt(env.getProperty(PROTOCOL_PORT, "20880")));
        return protocolConfig;
    }
}
