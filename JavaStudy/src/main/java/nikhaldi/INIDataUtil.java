package nikhaldi;

import com.nikhaldimann.inieditor.IniEditor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2018/9/20.
 * INI文件功能解析
 *
 配置文件.ini格式
 INI文件由节、键、值组成。
 节:[section/option]
 参数（键=值）:name=value
 注解
 注解使用分号表示（;）。在分号后面的文字，直到该行结尾都全部为注解。
 ; comment textINI文件的数据格式的例子（配置文件的内容）　[Section1 Name]
 */
public class INIDataUtil {
    public static void main(String[] args) {
        System.out.println(getData("data/getPukeyTestData","getPukeyTestData_01"));

    }

    public  static Object[][] getData(String FileName,String caseName){
        int Plength=0;
        int max=0;
        String splitstr=",";
        IniEditor iniEditor = new IniEditor();
        if(FileName.indexOf("/")==-1){
            FileName="data/"+FileName;
        }
        try {
            iniEditor.load(FileName);
        } catch (IOException e) {
            System.out.println("File Read Error:"+FileName);
            e.printStackTrace();
            return null;
        }
//      取出所有CASE名字
        List<String> paramList = iniEditor.optionNames(caseName);
        if(paramList==null){
            System.out.println("File info Error:"+FileName);
            return null;
        }
        Plength=paramList.size();
        List<String[]> ls = new ArrayList<String[]>();
//      根据CASE+参数名 取VALUE
        for (int i=0;i<paramList.size();i++) {
            String params = iniEditor.get(caseName, paramList.get(i));
            if(params.length()==0){
                System.out.println("value is null :"+caseName+"-"+paramList.get(i));
            }
            String[] paramsl = (params.trim()).split(splitstr);
            //取测试数据宽度
            max = paramsl.length > max ? paramsl.length : max;
            ls.add(i,paramsl);
        }
        //将结果放到二维数组Obj中
        Object[][] cases=new String[max][Plength];
        for(int i=0;i<Plength;i++){
            for(int j=0;j<max;j++){
                if(j>=ls.get(i).length){
                    cases[j][i] = "";
                }else {
                    cases[j][i] = ls.get(i)[j];
                }
            }
        }
        return cases;
    }



}
