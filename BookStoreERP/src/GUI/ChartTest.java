package GUI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartTest {

	public ChartTest() {
	}

	// getChart() 메서드. Chart 를 만들어서 리턴함
	public JFreeChart getChart() {

		JFreeChart chart = ChartFactory.createBarChart(getClass().getName(), // title
				"Category", // categoryAxisLabel
				"Value", // valueAxisLabel
				getDataSet(), // dataset
				PlotOrientation.VERTICAL, // orientation
				true, // legend
				true, // tooltips
				false); // url

		return chart;
	}

	// getDataSet() 메서드. dataset 을 만들어서 리턴함 - getChart() 내에서 사용
	private DefaultCategoryDataset getDataSet() {
		
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		String category1 = "category#1";
		String category2 = "category#2";
		String test1 = "test#1";
		String test2 = "test#2";
		String test3 = "test#3";
		String test4 = "test#4";
		String test5 = "test#5";

		// addValue() 메서드를 이용해서 값을 추가함
		dataSet.addValue(30.0, category1, test1);
		dataSet.addValue(39.0, category1, test2);
		dataSet.addValue(22.0, category1, test3);
		dataSet.addValue(45.0, category1, test4);
		dataSet.addValue(7.0, category1, test5);
		// addValue() 메서드를 이용해서 값을 추가함
		dataSet.addValue(37.0, category2, test1);
		dataSet.addValue(26.0, category2, test2);
		dataSet.addValue(32.0, category2, test3);
		dataSet.addValue(49.0, category2, test4);
		dataSet.addValue(23.0, category2, test5);

		return dataSet;
	}

	// 메인 메서드. 챠트 프레임을 보여줌
	public static void main(String[] args) {
		JFreeChart chart = new ChartTest().getChart();
		ChartFrame cf = new ChartFrame("My Chart", chart);
		cf.setSize(500, 500);
		cf.setVisible(true);
	}
}
