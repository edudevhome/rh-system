package br.com.payrollapi.services;

import java.util.Objects;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.payrollapi.domain.Payroll;
import br.com.payrollapi.feignClient.UserFeign;
import br.com.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@RequiredArgsConstructor
public class PayrollService {

	private final Environment environment;
	private final UserFeign userFeign;

	public Payroll getPayment(Long workerId, Payroll payroll) {
		log.info("PAYROLL_SERVICE ::: Get request on " + environment.getProperty("local.server.port") + " port");

		try {
			
				var user = userFeign.findById(workerId).getBody();
				
				if (Objects.nonNull(user)) {
					return new Payroll(
							user.getName(),
							payroll.getDescription(),
							user.getHourlyPrice(),
							payroll.getWorkedHours(),
							user.getHourlyPrice() * payroll.getWorkedHours()
							);
				}			
			
		} catch (FeignException.NotFound ex) {

			throw new ObjectNotFoundException("Object not found");
			
		} catch (ObjectNotFoundException ex) {

			throw new IllegalArgumentException("Illegal argument exception");
		}
		
		return null;
	}
}
