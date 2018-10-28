package getclass;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by andy on 2018/9/28.
 * 用来保存扫描到的注解集合
 */
public class KeepAnnotation {

        private Class classzz;
        private Annotation classzzAnnotation;
        private Map<String,Annotation> methodAnnotation;

    public List<Map<String, Annotation>> getMethodAnnotationlist() {
        return methodAnnotationlist;
    }
    public void setMethodAnnotationlist(List<Map<String, Annotation>> methodAnnotationlist) {
        this.methodAnnotationlist = methodAnnotationlist;
    }
    private List<Map<String,Annotation>> methodAnnotationlist;

    public KeepAnnotation(Class classzz) {
            this.classzz = classzz;
        }
        public Class getClasszz() {
            return classzz;
        }
        public void setClasszz(Class classzz) {
            this.classzz = classzz;
        }
        public Annotation getClasszzAnnotation() {
            return classzzAnnotation;
        }
        public void setClasszzAnnotation(Annotation classzzAnnotation) {
            this.classzzAnnotation = classzzAnnotation;
        }
        public Map<String, Annotation> getMethodAnnotation() {
            return methodAnnotation;
        }
        public void setMethodAnnotation(Map<String, Annotation> methodAnnotation) {
            this.methodAnnotation = methodAnnotation;
        }

        @Override
        public String toString() {
            return "KeepAnnotation{" +
                    "classzz=" + classzz +
                    ", classzzAnnotation=" + classzzAnnotation +
                    ", methodAnnotation=" + methodAnnotation +
                    '}';
        }
}
