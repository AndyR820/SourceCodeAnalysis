package annotation;

/**
 * Created by andy on 2018/9/25.
 */
public enum ElementTypeRC {
        /** Class, interface (including annotation type), or enum declaration
         * 类、接口（包括注释类型）或枚举声明
         */
        TYPE,

        /** Field declaration (includes enum constants)
         * 字段声明（包括枚举常量）
         * */
        FIELD,

        /** Method declaration
         * 方法声明
         * */
        METHOD,

        /** Formal parameter declaration
         * 参数声明
         * */
        PARAMETER,

        /** Constructor declaration
         * 构造方法声明
         * */
        CONSTRUCTOR,

        /** Local variable declaration
         * 局部变量声明
         * */
        LOCAL_VARIABLE,

        /** Annotation type declaration
         * 注释类型声明
         * */
        ANNOTATION_TYPE,

        /** Package declaration
         * 包声明
         * */
        PACKAGE,

        /**
         * Type parameter declaration
         *
         * @since 1.8
         */
        TYPE_PARAMETER,

        /**
         * Use of a type
         *
         * @since 1.8
         */
        TYPE_USE
}
