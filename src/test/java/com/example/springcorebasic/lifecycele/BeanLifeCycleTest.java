package com.example.springcorebasic.lifecycele;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {
        // destroyMethod : bean 삭제 될 시점의 메서드명은 close 로 default 설정 되어 있음
        // - 메서드를 설정 하지 않으면 자동으로 close() 라는 함수를 실행 시킴
        // @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://heelo-spring.dev");
            System.out.println("bean 생성자");
            return networkClient;
        }
    }
}
