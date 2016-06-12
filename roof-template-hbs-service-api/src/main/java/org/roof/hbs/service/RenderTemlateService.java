package org.roof.hbs.service;

import java.util.Map;

public interface RenderTemlateService {

	String renderByTemplateId(String templateId,Map<String,Object> dataMap);
	
	String renderBtTemplateStream(String templateBuffer,Map<String,Object> dataMap);
	
	
}
