package clzzclass;

import clzzclass.vo.InterfaceDescVo;
import clzzclass.vo.MethodDescVo;
import clzzclass.vo.ParamDescVo;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 工具类
 * @author rongjingjing
 */
public class ApiJarPomUtil {
	
	/**
	 * 读取jar包中所有接口
	 * @param path
	 * @throws Exception
	 */
	public static List<InterfaceDescVo> loadJar(String path) throws Exception{
		List<String> classPathList = getClassPath(path);
		URLClassLoader myClassLoader = getClassLoader(path);
		List<InterfaceDescVo> interList = new ArrayList<InterfaceDescVo>();
		for (String classPath : classPathList) {
			Class<?> clazz = myClassLoader.loadClass(classPath);
			if (clazz.isInterface()) {// 验证是否是接口
				List<MethodDescVo> list = getMethodDesc(clazz);
				if(list != null && list.size() > 0){
					interList.add(new InterfaceDescVo(clazz.getName(),list));
				}
			}
		}
		return interList;
	}
	
	/**
	 * 根据class 获得全部方法
	 * @param clazz
	 * @return
	 */
//	private String paramnamePath;//参数类型
//	private String paramvalue;//参数值
//	private boolean isBaseType;//是否是基础类型 true:是  false:不是(对象类型)
	public static List<MethodDescVo> getMethodDesc(Class<?> clazz){
		List<MethodDescVo> methodDescList = new ArrayList<MethodDescVo>();
		// 获取接口中的方法
		try {
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				//验证参数类型
				List<ParamDescVo> paramDescList = new ArrayList<ParamDescVo>();
				Class<?>[] parameterTypes = method.getParameterTypes();
				for(Class<?> c : parameterTypes){
					paramDescList.add(new ParamDescVo(c.getName(), isVerBaseType(c)));
				}
				methodDescList.add(new MethodDescVo(method.getName(), method.getReturnType().getName(), paramDescList));
			}
			return methodDescList;
		} catch (Throwable e) {
			System.out.println("接口参数为第三方，暂不支持，接口名:"+clazz.getName());
//			e.printStackTrace();
		}
		return methodDescList;
	}
	
	
	/**
	 * 获取jar包的classloader
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static URLClassLoader getClassLoader(String path) throws Exception{
		File f = new File(path); 
		URL url1 = f.toURI().toURL(); 
        URLClassLoader myClassLoader = new URLClassLoader(new URL[]{url1},Thread.currentThread().getContextClassLoader());
        return myClassLoader;
	}
	
	/**
	 * 获得所有class文件 全路径
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static List<String> getClassPath(String path) throws Exception {
		List<String> list = new ArrayList<String>();
		JarFile jar = new JarFile(path);//加载jar包
		Enumeration<JarEntry> enumFiles = jar.entries();
		JarEntry entry = null;
		while (enumFiles.hasMoreElements()) {//遍厉整个jar包路径
			entry = (JarEntry)enumFiles.nextElement();
			String classFullName = entry.getName();
			if(classFullName.endsWith(".class")){
				//去掉.class后辍
				list.add(classFullName.substring(0, classFullName.indexOf(".class")).replace("/", "."));
			}
		}
		jar.close();
		return list;
	}
	
	/**
	 * 验证是否是基础类型
	 * @param clazz
	 * @return
	 */
	public static boolean isVerBaseType(Class<?> clazz){
		return String.class == clazz 
				|| int.class == clazz || Integer.class == clazz 
				|| byte.class == clazz || Byte.class == clazz 
				|| short.class == clazz || Short.class == clazz 
				|| long.class == clazz || Long.class == clazz
				|| float.class == clazz || Float.class == clazz
				|| boolean.class == clazz || Boolean.class == clazz
				|| char.class == clazz || Character.class == clazz
				|| double.class == clazz || Double.class == clazz;
	}
	
	public static void main(String[] args) throws Exception {
		String path = "/Users/andy/.m2/repository/com/bj58/mism/meishi-service-facade/1.0.8/meishi-service-facade-1.0.8.jar";
		List<InterfaceDescVo> list = loadJar(path);
		System.out.println(list+"=====");
	}
	
}
