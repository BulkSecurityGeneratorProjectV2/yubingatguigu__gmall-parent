package com.atguigu.gmall.order.client;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.order.OrderInfo;
import com.atguigu.gmall.order.client.impl.OrderDegradeFeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author gao
 * @create 2020-05-04 23:29
 */
@FeignClient(name = "service-order",fallback = OrderDegradeFeignClient.class)
public interface OrderFeignClient {

    @GetMapping("/api/order/auth/trade")
    Result<Map<String,Object>> trade();

    @GetMapping("/api/order/inner/getOrderInfo/{orderId}")
    public OrderInfo getOrderInfo(@PathVariable Long orderId);

    //提交秒杀订单
    @PostMapping("/api/order/inner/seckill/submitOrder")
    Long submitOrder(@RequestBody OrderInfo orderInfo);
}
