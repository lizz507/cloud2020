import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author lizz
 * @date 2020/3/15 20:54
 */
public class T {
    public static void main(String[] args) {
//        final Set<String> set = ZoneId.getAvailableZoneIds();
//        set.forEach(q -> System.out.println(q));
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
//        zonedDateTime.
        System.out.println(zonedDateTime);
        final ExecutorService executorService = Executors.newFixedThreadPool(1);
    }
}
