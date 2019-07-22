package clzzclass.vo;

/**
 * 参数描述
 * @author rongjingjing
 */
public class ParamDescVo implements Comparable<ParamDescVo>{
	
	private String paramtype;//参数类型

	private String paramvalue;//参数值
	
	private boolean isBaseType;//是否是基础类型 true:是  false:不是(对象类型)
	
	private int sort;//方法参数顺序

	
	public ParamDescVo(){
		
	}
	
	public ParamDescVo(String paramtype,boolean isBaseType){
		this.paramtype=paramtype;
		this.isBaseType=isBaseType;
		
	}

	public String getParamtype() {
		return paramtype;
	}

	public void setParamtype(String paramtype) {
		this.paramtype = paramtype;
	}

	public String getParamvalue() {
		return paramvalue;
	}

	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}

	public boolean isBaseType() {
		return isBaseType;
	}

	public void setBaseType(boolean isBaseType) {
		this.isBaseType = isBaseType;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	@Override
	public int compareTo(ParamDescVo o) {
		if(this.sort > o.getSort())
			return 1;
		return -1;
	}

	public static void main(String[] args) {
//		List<ParamDescVo> list = new ArrayList<ParamDescVo>();
//		ParamDescVo v1 = new ParamDescVo();
//		v1.setSort(0);
//		v1.setParamtype("adf");
//		
//		ParamDescVo v2 = new ParamDescVo();
//		v2.setSort(1);
//		v2.setParamtype("adf2222");
//		
//		ParamDescVo v3 = new ParamDescVo();
//		v3.setSort(2);
//		v3.setParamtype("adf3333");
//		list.add(v3);
//		list.add(v1);
//		list.add(v2);
//		
//		for(ParamDescVo v : list){
//			System.out.println(v.getSort() + "-" + v.getParamtype());
//		}
//		System.out.println("------------");
//		Collections.sort(list);
//		
//		for(ParamDescVo v : list){
//			System.out.println(v.getSort() + "-" + v.getParamtype());
//		}

		
	}
	
}
