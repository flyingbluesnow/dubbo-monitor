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

import org.apache.dubbo.config.annotation.Service;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


/**
 * MonitorConfig
 *
 * @author Jinkai.Ma
 */
@Configuration
@ComponentScan(basePackages = {"com.handu.open.dubbo.monitor"}, includeFilters = {@ComponentScan.Filter(value = Service.class)})
@Import({WebConfig.class, DubboConfig.class, MyBatisConfig.class, Security.class})
@PropertySource("classpath:/application.properties")
public class MonitorConfig {
}
