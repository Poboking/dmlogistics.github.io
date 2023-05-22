package rog.sziit.dynamicplus.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author:poboking
 * @version:1.0
 * @time:2023/5/22 15:10
 */
public class SyncDataBaseJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String dataSourceName = (String) context.getMergedJobDataMap().get("dataSourceName");

    }
}
