package com.zkwb.resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class CustomerResource extends ServerResource {

	String customerId = "";

	@Override
	protected void doInit() throws ResourceException {
		customerId = (String) this.getRequestAttributes().get("customerId");
	}
	
	@Override
	protected Representation get() throws ResourceException {
		String msg = "测试";
		JSONObject js = new JSONObject();
		js.put("msg", msg);
		js.put("id",customerId);
		js.element("element", "element");
		
		JSONArray arr = new JSONArray();
		arr.add(js);
		return new StringRepresentation(arr.toString());
	}
}
