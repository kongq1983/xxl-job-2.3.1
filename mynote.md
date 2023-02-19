

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


# 步骤

## 添加执行器