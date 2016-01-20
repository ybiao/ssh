package com.zkwb.resource;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import org.springframework.stereotype.Component;

import com.zkwb.entity.Customer;
import com.zkwb.service.CustomerService;

@Component(value="registResource")
public class RegistResource extends ServerResource {
	private static final Logger log = Logger.getLogger(RegistResource.class);
	
	@Resource(name="customerService")
	private CustomerService customerService;

	private String cname;

	@Override
	protected void doInit() throws ResourceException {
		cname = (String) this.getRequestAttributes().get("cname");
		try {
			//处理get请求中文编码问题
			cname = URLDecoder.decode(cname, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * http://localhost:8080/01_spring_restlet/resources/regist/yao
	 */
	@Override
	protected Representation get() throws ResourceException {
		log.info("这是一个测试的日志信息");
		
		Customer cus = new Customer();
		cus.setCid(1);
		cus.setCname(cname);
		customerService.save(cus);

		return new StringRepresentation("注册成功");
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

}
