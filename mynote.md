

XxlJobAdminConfig

public void afterPropertiesSet() throws Exception {
    adminConfig = this;

    xxlJobScheduler = new XxlJobScheduler();
    xxlJobScheduler.init();   // todo 启动后台线程
}