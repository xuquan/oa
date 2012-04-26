package cn.edu.zhku.oa.web.common.util;

import cn.edu.zhku.oa.model.DWZResponser;

public class DWZResponseFactory {
	
	private DWZResponseFactory(){};
	
	public static DWZResponser create(){
		return new DWZResponser();
	}
	
}
