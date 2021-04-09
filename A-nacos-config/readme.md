### 隐私数据保护  
使用spring.profiles.include也可以用于include bootstrap.yaml相关配置。  文件名如：bootstrap-***.yaml  

### Value相关
@RefreshScope  要使nacos配置文件的数值即时生效，应在引入数值的类上配置@RefreshScope注解  
@Value("${test:null}") 冒号后可用于指定默认值；  

### nacos-config 默认配置 
nacos-config 默认从nacos服务端导入：${prefix} - ${spring.profiles.active} . ${file-extension}  
| prefix默认为spring.application.name的值，也可以通过配置项spring.cloud.nacos.config.prefix来配置；
| spring.profiles.active即为当前环境对应的profile。注意，当spring.profiles.active为空时，对应的连接符-也将不存在，dataId的拼接格式变成${prefix}.${file-extension}；
| file-extension为配置内容的数据格式，可以通过配置项spring.cloud.nacos.config.file-extension来配置。

若项目中无指定开发环境则默认导入 'spring.application.name'.'spring.cloud.nacos.config.file-extension'  

### nacos-config 引入多个配置文件 
* 同时获取多个配置文件的内容
```yaml
spring:
  cloud:
    nacos:
      config:
        server-addr: localhost:8848
        extension-configs:
          - dataId: ext-config-one.yaml
            group: DEFAULT_GROUP
            refresh: true
          - dataId: ext-config-two.yaml
            group: DEFAULT_GROUP
            refresh: false
```
| spring.cloud.nacos.config.extension-configs[n].dataId，指定多个配置的dataId，必须包含文件格式，支持properties、yaml或yml；
| spring.cloud.nacos.config.extension-configs[n].group，指定分组；
| spring.cloud.nacos.config.extension-configs[n].refresh，是否支持刷新。

* 多配置共享  
```yaml
spring:
  cloud:
    nacos:
      config:
        server-addr: localhost:8848
        shared-configs: ext-config-one.yaml,ext-config-two.yaml
```
以上spring.cloud.nacos.config.shared-configs指定了共享ext-config-one.yaml和ext-config-two.yaml的配置。  

### 实践证明 @RefreshScope不能动态改变swagger的是否生效状态
