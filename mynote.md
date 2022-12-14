

XxlJobAdminConfig

public void afterPropertiesSet() throws Exception {
    adminConfig = this;

    xxlJobScheduler = new XxlJobScheduler();
    xxlJobScheduler.init();   // todo 启动后台线程
}


# 步骤

## 添加执行器