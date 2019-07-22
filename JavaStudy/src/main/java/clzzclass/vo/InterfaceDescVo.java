package clzzclass.vo;

import java.util.List;


public class InterfaceDescVo {
	private long id;//接口方法ID
	private long pid;//项目ID
	private String interfacenamePath;//接口全路径
	private String methodName;//接口对应方法	
	private String methodResType;//方法返回类型

	
	private List<ParamDescVo> paramDescVoList;//参数详情
	private List<MethodDescVo> methodDescVoList ;//接口下对应的方法
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public InterfaceDescVo() {}
	
	public InterfaceDescVo(String namePath, List<MethodDescVo> methodDescVoList) {
		this.interfacenamePath = namePath;
		this.methodDescVoList = methodDescVoList;
	}

	public String getInterfacenamePath() {
		return interfacenamePath;
	}

	public void setInterfacenamePath(String interfacenamePath) {
		this.interfacenamePath = interfacenamePath;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMethodResType() {
		return methodResType;
	}

	public void setMethodResType(String methodResType) {
		this.methodResType = methodResType;
	}

	public List<MethodDescVo> getMethodDescVoList() {
		return methodDescVoList;
	}

	public void setMethodDescVoList(List<MethodDescVo> methodDescVoList) {
		this.methodDescVoList = methodDescVoList;
	}

	public List<ParamDescVo> getParamDescVoList() {
		return paramDescVoList;
	}

	public void setParamDescVoList(List<ParamDescVo> paramDescVoList) {
		this.paramDescVoList = paramDescVoList;
	}
	


	
}
