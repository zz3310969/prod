package org.roof.hbs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.roof.hbs.vo.TemplateSubmitVo;
import org.roof.hbs.vo.UserDemo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

@Controller
@RequestMapping("templateController")
public class TemplateController {
	 private final static Logger logger = Logger.getLogger(TemplateController.class);	
	
	@RequestMapping("/submit")
	@ResponseBody
	public Object submitHbs(@RequestBody TemplateSubmitVo templateVo){
		Handlebars handlebars = new Handlebars();
	    
		try {
			Template template = handlebars.compileInline(templateVo
					.getTemplateHtml());
			List<Map<String,Object>> dataList = templateVo.getDataList();
			Map<String,Object> applyMap = new HashMap<String,Object>();
			for (Map<String, Object> map : dataList) {
				//TODO 改成取数据源
				applyMap.put(String.valueOf(map.get("key")), getTestList());
			}
			
			
			String html = template.apply(applyMap);
			
			
			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("success", true);
			resultMap.put("data", html);
			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping("/submit2")
	public Object submitHbs2(@RequestBody List<Map<String,Object>> list){
		
		System.out.println("sadf");
		
		return null;
	}
	
	private List<UserDemo> getTestList(){
		List<UserDemo> list = new ArrayList<UserDemo>();
		list.add(new UserDemo("张三",12));
		list.add(new UserDemo("马子",5));
		list.add(new UserDemo("李四",6));
		return list;
		
	}
	
	
}
