package test;

import org.apache.poi.ss.formula.functions.T;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author GuanBin
 * @version QuartzTest.java, v1 2018/4/19 下午8:23 GuanBin Exp $$
 */
public class QuartzTest implements Job {
    //ThreadLocal是对于同步时使用同一个变量用的，但是quartz按吧·秒调度时是每次一个线程，所以ThreadLocal中的值是不变的
    ThreadLocal<Integer> num = new ThreadLocal<>();
    Integer i=0;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("测试代码");
        num.set(i++);

        System.out.println(num.get());
    }
    public static void main(String args[])throws SchedulerException{
        JobDetail jobDetail = JobBuilder
                .newJob(QuartzTest.class)
                .withIdentity("job1", "group1")
                .build();

        //简单的触发器,有cron触发器和节假日触发器和延迟触发都要学习，坚持
        //泛型上限和泛型下限
        SimpleTrigger simpleTrigger = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1")
                .withDescription("测试代码")
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(10, 2))
                .startNow()
                .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, simpleTrigger);
        scheduler.start();
    }


}
