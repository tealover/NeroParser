package org.tinos.test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.tinos.engine.Analyzer;
import org.tinos.engine.imp.BinaryForestAnalyzerImp;
import org.tinos.engine.imp.CogsBinaryForestAnalyzerImp;
import org.tinos.engine.imp.BaseAnalyzerImp;
import org.tinos.engine.imp.PrettyAnalyzerImp;
import timeProcessor.TimeCheck;
@SuppressWarnings("unused")
public class Demoex{
	public static void main(String args[]) throws IOException{
		Analyzer analyzer = new CogsBinaryForestAnalyzerImp();  //哈希森林索引 多核线程安全 支持并发
		//Analyzer analyzer = new BinaryForestAnalyzerImp();  //哈希森林索引 单线程
		//Analyzer analyzer = new FastAnalyzerImp();        //快速线性索引 单线程
		//Analyzer analyzer = new PrettyAnalyzerImp();      //线性森林索引 单线程
		//Analyzer analyzer = new BaseAnalyzerImp();        //一元线性索引
		//Analyzer analyzer = new ScoreAnalyzerImp();       //森林打分索引
		analyzer.init();
		//返回分词数据集合
		List<String> sets = new ArrayList<String>();
		TimeCheck tc = new TimeCheck();
		String ss = "如果从容易开始于是从容不迫天下等于是非常识时务必为俊杰沿海南方向逃跑他说的确实在"
				  + "结婚的和尚的提高产品质量中外科学名著内科学是临床医学的基础 内科学作为临床医未结婚"
				  +"如果从容易开始于是从容不迫天下等于是非常识时务必为俊杰沿海南方向逃跑他说的确实在"
				  + "结婚的和尚未结婚的提高产品质量中外科学名著内科学是临床医学的基础 内科学作为临床医"
				  + "结婚的和尚未结婚的提高产品质量中外科学名著内科学是临床医学的基础 内科学作为临床医"; //400
		System.out.println("");
		System.out.println("计时开始");
		tc.begin();
		for(int i = 0; i < 25000; i++) {//重复执行 2.5万次 相当于1000 万字分词
			sets = analyzer.parserString(ss); 
		}
		tc.end();;
		System.out.println("计时结束");
		tc.duration();
		System.out.println("分词效果如下");
		int j=0;
		for(int i = 0; i < sets.size(); i++){
			System.out.print(sets.get(i)+"  |  ");
			j++;
			if(j>15) {//每行15个词语输出
				j=0;
				System.out.println("");
			}
		}
	}
}