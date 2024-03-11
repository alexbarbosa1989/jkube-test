package com.redhat.jkubetest;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JvmStatsService {

    @GetMapping("/jvmstats")
    public String GetJvmStats() throws Exception {

        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryUsage = memoryBean.getNonHeapMemoryUsage();

        String javaVersion = System.getProperty("java.version");

        StringBuilder stats = new StringBuilder();
        stats.append("<html><body><h2>JVM Memory Usage</h2>");
        stats.append("<table border=\"1\">");
        stats.append("<tr><th></th><th>Initial (MB)</th><th>Used (MB)</th><th>Committed (MB)</th><th>Max (MB)</th></tr>");
        stats.append("<tr><td>Heap Memory</td><td>")
             .append(bytesToMegabytes(heapMemoryUsage.getInit())).append("</td><td>")
             .append(bytesToMegabytes(heapMemoryUsage.getUsed())).append("</td><td>")
             .append(bytesToMegabytes(heapMemoryUsage.getCommitted())).append("</td><td>")
             .append(bytesToMegabytes(heapMemoryUsage.getMax())).append("</td></tr>");
        stats.append("<tr><td>Non-Heap Memory</td><td>")
             .append(bytesToMegabytes(nonHeapMemoryUsage.getInit())).append("</td><td>")
             .append(bytesToMegabytes(nonHeapMemoryUsage.getUsed())).append("</td><td>")
             .append(bytesToMegabytes(nonHeapMemoryUsage.getCommitted())).append("</td><td>")
             .append(bytesToMegabytes(nonHeapMemoryUsage.getMax())).append("</td></tr>");
        stats.append("</table>");
        stats.append("<h2>Java Version</h2>");
        stats.append("<p>").append(javaVersion).append("</p>");
        stats.append("</body></html>");


        return stats.toString();
    }

    private long bytesToMegabytes(long bytes) {
        return bytes / (1024 * 1024);
    }

}