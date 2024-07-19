package com.faircloud.platform.common.application;

/**
 * 应用服务作为总体协调者，先通过资源库获取到聚合根，然后调用聚合根或者领域服务中的业务方法，最后再次调用资源库保存聚合根。
 * 作用：
 * 1、除了同步方法调用外，还可以发布或者订阅领域事件，权限校验、事务控制，一个事务对应一个聚合根。
 * 2、应用层方法主要执行服务编排等轻量级逻辑，尤其针对跨多个领域的业务场景，效果明显。
 * 3、参数校验，简单的crud，可直接调用仓库接口
 */
public interface ApplicationService {

}
