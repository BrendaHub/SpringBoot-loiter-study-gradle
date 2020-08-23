import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.junit.Assert.assertEquals;

public class DemoTest {

    @Test
    public  void testBigDecimal() {
        BigDecimal bigDecimal = new BigDecimal(3980990092390238291732091472039487120934710927834019278340198273409127340198273401273409812734098127340981723049817203478120934710233840297340278340283234209820938409283402983409230298340923840928340928340928309482309482093.23);
        BigDecimal bigDecimal1 = new BigDecimal(3980990092390238291732091472039487120934710927834019278340198273409127340198273401273409812734098127340981723049817203478120934710233840297340278340283234209820938409283402983409230298340923840928340928340928309482309482093.23);

        System.out.println(bigDecimal.equals(bigDecimal1));
        System.out.println(bigDecimal.compareTo(bigDecimal1));


        double sum = 0.0d;
        for( int i=0; i<100; i++ ){
            sum = sum + 0.01;
        }

        // 结果是 true 还是 false ？
        System.out.println(sum);
        System.out.println("result is " + (sum==1.00d) );

        BigDecimal _sum = new BigDecimal(0.0);
        BigDecimal pre = new BigDecimal(0.01);
        for( int i = 0 ; i < 100; i++) {
            _sum = _sum.add(pre);
        }
        BigDecimal result = new BigDecimal(1.0);
        System.out.println(_sum.doubleValue());
        System.out.println(result.doubleValue());
        System.out.println(_sum.compareTo(result));
        System.out.println(_sum.scale() + "           " + result.scale());
    }

    @Test
    public void giveRangeOfLongs_whenSummedInParallel_shouldBeEqualToExpectedTotal() throws ExecutionException, InterruptedException {

        long firstNum = 1;
        long lastNum = 1_000_000;
        long LastNum1 = 1000000l;

        List<Long> aList = LongStream.rangeClosed(firstNum, lastNum).boxed()
                .collect(Collectors.toList());

        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        Long aLong = forkJoinPool.submit(
                () -> aList.parallelStream().reduce(0l, Long::sum)
        ).get();
        ForkJoinTask<Long> result = forkJoinPool.submit(() ->
                aList.parallelStream().reduce(0l, Long::sum));



        System.out.println(aLong);
        assertEquals(java.util.Optional.of((lastNum + firstNum) * lastNum / 2).get(), aLong);
    }
}
