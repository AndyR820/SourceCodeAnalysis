package testsample;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testng.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Listeners({  ProgressTrackerListener.class })
public class SampleTest {

	@Test(groups = { OSNames.OS_LINUX })
	@TestDescription(item = "high", description="描述1",verification="验证1",CaseID="rjjtest001",Lever="high")
	public void test1() {
		sleep(5000);
		System.out.println(">>>test1");
		Method[] methods = SampleTest.class.getMethods();
		for (Method method : methods) {
			if(method.getName().equals("test1")){
				Annotation[] allMAnnos = method.getAnnotations();
				for(Annotation a:allMAnnos){
					System.out.println("allMAnnos"+a);
				}
			}
		}
	}

	@Test(groups = { OSNames.OS_LINUX, OSNames.OS_WINDOWS })
	@TestDescription(item = "middle", description="描述1",verification="验证1")
	public void test2() {
		sleep(3000);
		System.out.println(">>>test2");
	}

	@Test(groups = { OSNames.OS_LINUX, OSNames.OS_WINDOWS })
	public void test3() {
		sleep(2000);
		System.out.println(">>>test3");
	}

	@Test(groups = { OSNames.OS_WINDOWS })
	public void test4() {
		sleep(5000);
		System.out.println(">>>test4");
	}

	@Test(groups = { OSNames.OS_WINDOWS })
	public void test5() {
		sleep(5000);
		System.out.println(">>>test5");
	}

	private void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
