package com.liuen.springcloud.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Author: En Liu
 * Email: liuen@sungbio.com
 * Date: 2018/2/8 0008
 * Description: 需要在actuator endpoint下加载监控某些配置或者连接
 */
@Component
public class ConfigActuator implements HealthIndicator{
    @Override
    public Health health() {
        Health.down().withDetail("someConfig",checkSomeConfig());
        return Health.up().build();
    }

    private String checkSomeConfig(){
        return "yes";
    }
}
