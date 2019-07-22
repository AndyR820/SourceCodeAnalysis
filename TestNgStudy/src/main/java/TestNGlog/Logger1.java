package TestNGlog;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import org.testng.Assert;
import org.testng.collections.Maps;

public class Logger1 {

    private static int i = 0;
    private static final int TRACE;
    private static final int DEBUG;
    private static final int INFO;
    private static final int WARN;
    private static final int ERROR;
    private static final int FATAL;
    private static final int LEVEL_COUNT;
    private static final String PREFIX = "log4testng.";
    private static final String LOGGER_PREFIX = "log4testng.logger.";
    private static final String ROOT_LOGGER = "log4testng.rootLogger";
    private static final String DEBUG_PROPERTY = "log4testng.debug";
    private static PrintStream err;
    private static PrintStream out;
    private static final String[] levelNames;
    private static final Map<String, Integer> levelMap;
    private static boolean initialized;
    private static final Map<String, Integer> loggerLevels;
    private static final Map <Class, Logger1> loggers;
    private static int rootLoggerLevel;
    private static boolean debug;
    private final int level;
    private final Class klass;
    private final String m_className;

    //构造方法，初始化类和日志级别
    private Logger1(Class pClass, int pLevel) {
        this.level = pLevel;
        this.klass = pClass;
        this.m_className = pClass.getName().substring(pClass.getName().lastIndexOf(46) + 1);
    }

    static {
        TRACE = i++;
        DEBUG = i++;
        INFO = i++;
        WARN = i++;
        ERROR = i++;
        FATAL = i++;
        LEVEL_COUNT = i;
        //默认为NULL
        err = System.err;
        //默认为NULL
        out = System.out;
        levelNames = new String[LEVEL_COUNT];
        levelNames[TRACE] = "TRACE";
        levelNames[DEBUG] = "DEBUG";
        levelNames[INFO] = "INFO";
        levelNames[WARN] = "WARN";
        levelNames[ERROR] = "ERROR";
        levelNames[FATAL] = "FATAL";
        //初始化级别Map，<级别，级别ID>
        levelMap = Maps.newHashMap();
        for(i = 0; i < LEVEL_COUNT; ++i) {
            levelMap.put(levelNames[i], i);
        }
        //<空的>
        loggerLevels = Maps.newHashMap();
        //定义一个空的MAP
        loggers = Maps.newHashMap();
        //默认的日志级别
        rootLoggerLevel = WARN;
        //debug是否开启
        debug = false;
    }



    public static synchronized Logger1 getLogger(Class pClass) {
        initialize();
        Logger1 logger = loggers.get(pClass);
        if (logger != null) {
            return logger;
        } else {
            int level = getLevel(pClass);
            logger = new Logger1(pClass, level);
            loggers.put(pClass, logger);
            return logger;
        }
    }

    public boolean isTraceEnabled() {
        return this.isLevelEnabled(TRACE);
    }

    public void trace(Object message) {
        this.log(TRACE, message, (Throwable)null);
    }

    public void trace(Object message, Throwable t) {
        this.log(TRACE, message, t);
    }

    public boolean isDebugEnabled() {
        return this.isLevelEnabled(DEBUG);
    }

    public void debug(Object message) {
        this.log(DEBUG, message, (Throwable)null);
    }

    public void debug(Object message, Throwable t) {
        this.log(DEBUG, message, t);
    }

    public boolean isInfoEnabled() {
        return this.isLevelEnabled(INFO);
    }

    public void info(Object message) {
        this.log(INFO, message, (Throwable)null);
    }

    public void info(Object message, Throwable t) {
        this.log(INFO, message, t);
    }

    public void warn(Object message) {
        this.log(WARN, message, (Throwable)null);
    }

    public void warn(Object message, Throwable t) {
        this.log(WARN, message, t);
    }

    public void error(Object message) {
        this.log(ERROR, message, (Throwable)null);
    }

    public void error(Object message, Throwable t) {
        this.log(ERROR, message, t);
    }

    public void fatal(Object message) {
        this.log(FATAL, message, (Throwable)null);
    }

    public void fatal(Object message, Throwable t) {
        this.log(FATAL, message, t);
    }


    private static synchronized void initialize() {
        //initialized默认为false
        if (!initialized) {
            initialized = true;
            //读取ClassPath路径下的配置文件log4testng.properties
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("log4testng.properties");
            //如果文件存在
            if (is != null) {
                Properties properties = new Properties();

                try {
                    properties.load(is);
                } catch (IOException var3) {
                    throw new RuntimeException(var3);
                }

                checkProperties(properties);
            }
        }
    }

    private static void checkProperties(Properties pProperties) {
        //从配置文件里读key：log4testng.debug
        String rootLevelStr = pProperties.getProperty("log4testng.debug");
        //如有key：log4testng.debug
        if (rootLevelStr != null) {
            //判断如果值=true
            if (rootLevelStr.equalsIgnoreCase("true")) {
                //给debug赋值
                debug = true;
            } else {
                //如果不等于true&&不等于false
                if (!rootLevelStr.equalsIgnoreCase("false")) {
                    //抛出异常
                    throw new IllegalArgumentException("Unknown log4testng.debug value " + rootLevelStr);
                }
                //给debug赋值
                debug = false;
            }
        }

        //打印debug日志，前提是debug=true;
        loglog4testng("log4testng.debug set to " + debug);
        //获取log4testng.rootLogger配置的日志级别
        rootLevelStr = pProperties.getProperty("log4testng.rootLogger");
        //不等于空
        if (rootLevelStr != null) {
            //  取出来赋值给ilevel
            Integer ilevel = (Integer)levelMap.get(rootLevelStr.toUpperCase());
            //赋值失败
            if (ilevel == null) {
                throw new IllegalArgumentException("Unknown level for log4testng.rootLogger " + rootLevelStr + " in log4testng.properties");
            }
            //如果有值将值赋给rootLoggerLevel，默认WARN
            rootLoggerLevel = ilevel;
            loglog4testng("Root level logger set to " + rootLevelStr + " level.");
        }

        //定义了一个集合，将配置文件里的值放到集合里
        Iterator it = pProperties.entrySet().iterator();

        while(it.hasNext()) {
            Entry entry = (Entry)it.next();
            String logger = (String)entry.getKey();
            String level = (String)entry.getValue();
            if (!logger.startsWith("log4testng.")) {
                throw new IllegalArgumentException("Illegal property value: " + logger);
            }
            //如果没有debug和root相关的配置信息，抛出异常
            if (!logger.equals("log4testng.debug") && !logger.equals("log4testng.rootLogger")) {
                if (!logger.startsWith("log4testng.logger.")) {
                    throw new IllegalArgumentException("Illegal property value: " + logger);
                }

                Integer ilevel = (Integer)levelMap.get(level.toUpperCase());
                if (ilevel == null) {
                    throw new IllegalArgumentException("Unknown level " + level + " for logger " + logger + " in log4testng.properties");
                }

                //配置日志级别默认为WARN，如果配置文件有配置，配置优先
                loggerLevels.put(logger.substring("log4testng.logger.".length()), ilevel);
                loglog4testng("logger " + logger + " set to " + ilevel + " level.");
            }
        }

    }

    private static int getLevel(Class pClass) {
        //获取类名
        String name = pClass.getName();
        loglog4testng("Getting level for logger " + name);

        while(true) {
            //根据类名取日志级别
            Integer level = (Integer)loggerLevels.get(name);
            //如果级别不为null
            if (level != null) {
                loglog4testng("Found level " + level + " for logger " + name);
                return level;
            }

            // 返回指定字符在此字符串中最后一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
            int dot = name.lastIndexOf(46);
            //没找到，返回默认配置的日志级别：WARN
            if (dot == -1) {
                loglog4testng("Found level " + rootLoggerLevel + " for root logger");
                return rootLoggerLevel;
            }
            //截取正确的名字
            name = name.substring(0, dot);
        }
    }

    private boolean isLevelEnabled(int pLevel) {
        return this.level <= pLevel;
    }

    private void log(int pLevel, Object pMessage, Throwable pT) {
        if (this.isLevelEnabled(pLevel)) {
            PrintStream ps = pLevel >= ERROR ? err : out;
            if (null != pT) {
                synchronized(ps) {
                    ps.println("[" + this.m_className + "] [" + levelNames[pLevel] + "] " + pMessage);
                    pT.printStackTrace(ps);
                }
            } else {
                ps.println("[" + this.m_className + "] [" + levelNames[pLevel] + "] " + pMessage);
            }
        }

    }

    private static void loglog4testng(String pmessage) {
        if (debug) {
            out.println("[log4testng] [debug] " + pmessage);
        }

    }

    private static synchronized void testInitialize(Properties pProperties, PrintStream pOut, PrintStream pErr) {
        initialized = true;
        loggers.clear();
        rootLoggerLevel = WARN;
        debug = false;
        out = pOut;
        err = pErr;
        checkProperties(pProperties);
    }

    private static void testDebugDefault() {
        Properties props = new Properties();
        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
        ByteArrayOutputStream err1 = new ByteArrayOutputStream();
        PrintStream out2 = new PrintStream(out1);
        PrintStream err2 = new PrintStream(err1);
        props.put("log4testng.rootLogger", "WARN");
        testInitialize(props, out2, err2);
        Assert.assertEquals(out1.toString(), "");
        Assert.assertEquals(err1.toString(), "");
    }

    private static void testDebugOn() {
        Properties props = new Properties();
        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
        ByteArrayOutputStream err1 = new ByteArrayOutputStream();
        PrintStream out2 = new PrintStream(out1);
        PrintStream err2 = new PrintStream(err1);
        props.put("log4testng.debug", "true");
        props.put("log4testng.rootLogger", "WARN");
        testInitialize(props, out2, err2);
        System.out.println(out1.toString());
        Assert.assertTrue(out1.toString().startsWith("[log4testng] [debug]"));

        Assert.assertEquals(err1.toString(), "");
    }

    private static void testDebugOff() {
        Properties props = new Properties();
        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
        ByteArrayOutputStream err1 = new ByteArrayOutputStream();
        PrintStream out2 = new PrintStream(out1);
        PrintStream err2 = new PrintStream(err1);
        props.put("log4testng.debug", "false");
        props.put("log4testng.rootLogger", "WARN");
        testInitialize(props, out2, err2);
        Assert.assertEquals(out1.toString(), "");
        Assert.assertEquals(err1.toString(), "");
    }

    private static void testDebugError() {
        Properties props = new Properties();
        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
        ByteArrayOutputStream err1 = new ByteArrayOutputStream();
        PrintStream out2 = new PrintStream(out1);
        PrintStream err2 = new PrintStream(err1);
        props.put("log4testng.debug", "unknown");
        props.put("log4testng.rootLogger", "WARN");

        try {
            testInitialize(props, out2, err2);
            throw new RuntimeException("failure");
        } catch (IllegalArgumentException var6) {
            Assert.assertEquals(out1.toString(), "");
            Assert.assertEquals(err1.toString(), "");
        }
    }

    private static void testRootLoggerDefault() {
        Properties props = new Properties();
        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
        ByteArrayOutputStream err1 = new ByteArrayOutputStream();
        PrintStream out2 = new PrintStream(out1);
        PrintStream err2 = new PrintStream(err1);
        testInitialize(props, out2, err2);
        Logger1 strLogger = getLogger(String.class);
        strLogger.trace("trace should not appear");
        Assert.assertEquals(out1.toString(), "");
        Assert.assertEquals(err1.toString(), "");
        strLogger.debug("debug should not appear");
        Assert.assertEquals(out1.toString(), "");
        Assert.assertEquals(err1.toString(), "");
        strLogger.info("info should not appear");
        Assert.assertEquals(out1.toString(), "");
        Assert.assertEquals(err1.toString(), "");
        strLogger.warn("warn should appear");
        int outlength = out1.toString().length();
        System.out.println(out1);
        Assert.assertTrue(out1.toString().indexOf("String] [WARN] warn should appear")!=-1);
        Assert.assertEquals(err1.toString(), "");
        strLogger.error("error should appear");
        Assert.assertEquals(out1.toString().length(), outlength);
        Assert.assertTrue(err1.toString().startsWith("[String] [ERROR] error should appear"));
        strLogger.fatal("fatal should appear");
        Assert.assertEquals(out1.toString().length(), outlength);
        Assert.assertTrue(err1.toString().contains("[String] [FATAL] fatal should appear"));
    }

    private static void testRootLoggerSet() {
        Properties props = new Properties();
        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
        ByteArrayOutputStream err1 = new ByteArrayOutputStream();
        PrintStream out2 = new PrintStream(out1);
        PrintStream err2 = new PrintStream(err1);
        props.put("log4testng.rootLogger", "DEBUG");
        testInitialize(props, out2, err2);
        Logger1 strLogger = getLogger(String.class);
        strLogger.trace("trace should appear");
        Assert.assertEquals(out1.toString(), "");
        Assert.assertEquals(err1.toString(), "");
        strLogger.debug("debug should appear");
        Assert.assertTrue(out1.toString().startsWith("[String] [DEBUG] debug should appear"));
        Assert.assertEquals(err1.toString(), "");
    }

    private static void testRootLoggerSetError() {
        Properties props = new Properties();
        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
        ByteArrayOutputStream err1 = new ByteArrayOutputStream();
        PrintStream out2 = new PrintStream(out1);
        PrintStream err2 = new PrintStream(err1);
        props.put("log4testng.rootLogger", "unknown");

        try {
            testInitialize(props, out2, err2);
            throw new RuntimeException("failure");
        } catch (IllegalArgumentException var6) {
            Assert.assertEquals(out1.toString(), "");
            Assert.assertEquals(err1.toString(), "");
        }
    }

    private static void testUserLoggerSet() {
        Properties props = new Properties();
        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
        ByteArrayOutputStream err1 = new ByteArrayOutputStream();
        PrintStream out2 = new PrintStream(out1);
        PrintStream err2 = new PrintStream(err1);
        props.put("log4testng.logger.java.lang.String", "DEBUG");
        testInitialize(props, out2, err2);
        Logger1 strLogger = getLogger(String.class);
        strLogger.trace("trace should not appear");
        Assert.assertEquals(out1.toString(), "");
        Assert.assertEquals(err1.toString(), "");
        strLogger.debug("debug should appear");
        int outLength = out1.toString().length();
        Assert.assertTrue(out1.toString().startsWith("[String] [DEBUG] debug should appear"));
        Assert.assertEquals(err1.toString(), "");
        Logger1 classLogger = getLogger(Class.class);
        classLogger.debug("debug should not appear");
        Assert.assertEquals(out1.toString().length(), outLength);
        Assert.assertEquals(err1.toString(), "");
        classLogger.warn("warn should appear");
        System.out.println(out1);
        Assert.assertTrue(out1.toString().contains("[Class] [WARN] warn should appear"));
        Assert.assertEquals(err1.toString(), "");
    }

    private static void testUserLoggerSetError() {
        Properties props = new Properties();
        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
        ByteArrayOutputStream err1 = new ByteArrayOutputStream();
        PrintStream out2 = new PrintStream(out1);
        PrintStream err2 = new PrintStream(err1);
        props.put("log4testng.logger.java.lang.String", "unknown");

        try {
            testInitialize(props, out2, err2);
            throw new RuntimeException("failure");
        } catch (IllegalArgumentException var6) {
            Assert.assertEquals(out1.toString(), "");
            Assert.assertEquals(err1.toString(), "");
        }
    }

    private static void testUserLoggerSetHierarchy() {
        Properties props = new Properties();
        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
        ByteArrayOutputStream err1 = new ByteArrayOutputStream();
        PrintStream out2 = new PrintStream(out1);
        PrintStream err2 = new PrintStream(err1);
        props.put("log4testng.logger.java.lang", "DEBUG");
        testInitialize(props, out2, err2);
        Logger1 strLogger = getLogger(String.class);
        strLogger.trace("trace should not appear");
        Assert.assertEquals(out1.toString(), "");
        Assert.assertEquals(err1.toString(), "");
        strLogger.debug("debug should appear");
        Assert.assertTrue(out1.toString().startsWith("[String] [DEBUG] debug should appear"));
        Assert.assertEquals(err1.toString(), "");
    }

    public static void main(String[] pArgs) {
//        testDebugDefault();
//        testDebugOn();
//        testDebugOff();
//        testDebugError();
//        testRootLoggerDefault();
//        testRootLoggerSet();
//        testRootLoggerSetError();
//        testUserLoggerSet();
//        testUserLoggerSetError();
//        testUserLoggerSetHierarchy();
        Logger1 logger=Logger1.getLogger(Logger1.class);
        System.out.println(logger);
    }

}
