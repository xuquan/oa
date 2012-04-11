package cn.edu.zhku.oa;

import java.util.List;

public class PagerModel {
	
	/**
	 * 总记录数
	 */
	private int total;
	
	/**
	 * 当前结果集
	 */
	private List datas;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
}
