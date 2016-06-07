package org.roof.hbs.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class TemplateSubmitVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String templateHtml;
	
	private List<Map<String,Object>> dataList;

	public String getTemplateHtml() {
		return templateHtml;
	}

	public void setTemplateHtml(String templateHtml) {
		this.templateHtml = templateHtml;
	}

	public List<Map<String, Object>> getDataList() {
		return dataList;
	}

	public void setDataList(List<Map<String, Object>> dataList) {
		this.dataList = dataList;
	}


}
