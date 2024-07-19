package com.faircloud.platform.common.service;

/**
 * 领域服务 是领域服务规范，其中定义了DomainService，应用系统需要继承它
 *
 * 聚合根与领域服务负责封装实现业务逻辑。领域服务负责对聚合根进行调度和封装，同时可以对外提供各种形式的服务，对于不能直接通过聚合根完成的业务操作就需要通过领域服务。
 * 说白了就是，聚合根本身无法完全处理这个逻辑，例如支付这个步骤，订单聚合不可能支付，所以在订单聚合上架一层领域服务，在领域服务中实现支付逻辑，然后应用服务调用领域服务。
 * @author Fair Cheng
 */
public interface DomainService {

}
