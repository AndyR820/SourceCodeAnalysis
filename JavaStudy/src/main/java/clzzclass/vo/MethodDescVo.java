package clzzclass.vo;

import java.util.List;


public class MethodDescVo {
	
	private String name;//方法名
	
	private String returnObjPath;//返回的参数类型全路径
	
	private List<ParamDescVo> paramDescVoList;//参数详情

	
	public MethodDescVo() {}
	
	public MethodDescVo(String name,String returnObjPath,List<ParamDescVo> paramDescVoList) {
		this.name = name;
		this.returnObjPath = returnObjPath;
		this.paramDescVoList = paramDescVoList;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReturnObjPath() {
		return returnObjPath;
	}

	public void setReturnObjPath(String returnObjPath) {
		this.returnObjPath = returnObjPath;
	}

	public List<ParamDescVo> getParamDescVoList() {
		return paramDescVoList;
	}

	public void setParamDescVoList(List<ParamDescVo> paramDescVoList) {
		this.paramDescVoList = paramDescVoList;
	}


}
