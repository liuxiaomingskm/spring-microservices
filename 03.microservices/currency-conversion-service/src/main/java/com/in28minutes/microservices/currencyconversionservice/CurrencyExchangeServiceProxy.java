package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// name is the application name that the feign want to talk to
// enable Ribbon on the proxy, 指定ribbon后就不需要在FeignClient设置url了 可以在application.properties中设定
//@FeignClient(name="currency-exchange-service", url="localhost:8000")
//@FeignClient(name="currency-exchange-service")
// 因为希望任何request都能通过Zuul API gateway所以FeignClient不再链接currency-exchange-service而是链接zuul 再通过zuul链接exchange service
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	//response的exchangeValue entity 会自动转化成CurrencyConversionBean
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	// 必须使用annotation指明pathVariable 即参数前面必须有@PathVariable("from")
	public CurrencyConversionBean retrieveExchangeValue
		(@PathVariable("from") String from, @PathVariable("to") String to);
}
