

#启动admin
com.xxl.job.admin.XxlJobAdminApplication

## 地址
http://localhost:8080/xxl-job-admin/toLogin

账号:  admin
密码:  123456

# XxlJobAdminConfig

public void afterPropertiesSet() throws Exception {
    adminConfig = this;

    xxlJobScheduler = new XxlJobScheduler();
    xxlJobScheduler.init();   // todo 启动后台线程
}


## JobTriggerPoolHelper
### addTrigger
addTrigger(final int jobId,......)


# 步骤

## 添加执行器


# Client

## XxlJobSpringExecutor
通过@Bean方式加载

```yaml
XxlJobSpringExecutor extends XxlJobExecutor {}
```


### afterSingletonsInstantiated

1. 注册当前spring容器中所有的@XxlJob
2. 把@XxlJob封装成MethodJobHandler
3. 然后统一放到jobHandlerRepository
ConcurrentMap<String, IJobHandler> jobHandlerRepository = new ConcurrentHashMap
```yaml
initJobHandlerMethodRepository(applicationContext);
```

```yaml
registJobHandler(name, new MethodJobHandler(bean, executeMethod, initMethod, destroyMethod));
```

## XxlJobExecutor

### XxlJobExecutor.registJobThread

JobThread初始化并启动

```yaml

public static JobThread registJobThread(int jobId, IJobHandler handler, String removeOldReason){
    JobThread newJobThread = new JobThread(jobId, handler);
    newJobThread.start();
    logger.info(">>>>>>>>>>> xxl-job regist JobThread success, jobId:{}, handler:{}", new Object[]{jobId, handler});

    JobThread oldJobThread = jobThreadRepository.put(jobId, newJobThread);	// putIfAbsent | oh my god, map's put method return the old value!!!
    if (oldJobThread != null) { // 如果已存在JobThread，则终止该线程
        oldJobThread.interrupt();
    }

    return newJobThread;
}

```

### registJobThread哪里调用
ExecutorBizImpl.run()

```yaml
// replace thread (new or exists invalid)
if (jobThread == null) {
    jobThread = XxlJobExecutor.registJobThread(triggerParam.getJobId(), jobHandler, removeOldReason);
}
```
哪里调用

JobTriggerPoolHelper.trigger(触发执行器) -> JobTriggerPoolHelper.addTrigger -> XxlJobTrigger.trigger-> XxlJobTrigger.processTrigger 
-> XxlJobTrigger.runExecutor(TriggerParam triggerParam, String address) -> ExecutorBizImpl.run()


# 具体id
job_id 是xxl_job_info的id


# 分片

```yaml
// script params：0=param、1=分片序号、2=分片总数
// 分片参数:  0=zj,1=js,2=gd
String[] scriptParams = new String[3];
scriptParams[0] = XxlJobHelper.getJobParam();
scriptParams[1] = String.valueOf(XxlJobContext.getXxlJobContext().getShardIndex());
scriptParams[2] = String.valueOf(XxlJobContext.getXxlJobContext().getShardTotal());
```


