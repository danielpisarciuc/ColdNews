package eu.unicredit.fiipractic.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import eu.unicredit.fiipractic.integration.ConnectionFactory;
import eu.unicredit.fiipractic.integration.NewsDAOImpl;
import eu.unicredit.fiipractic.integration.NewsDAO;
import eu.unicredit.fiipractic.model.News;

public class MainTest {

	static NewsDAO news;

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {

		news = new NewsDAOImpl(ConnectionFactory.getConnection());

		saveInsertStatementTest();
		loadStatementByIdTest();
		updateStatementTest();
		deleteStatementTest();
		loadAllStatementsTest();
		loadAllStatementsSortedByDateTest();

	}

	private static void loadAllStatementsTest() throws SQLException {
		List<News> res = news.loadAll();
		displayAllList(res);
	}

	private static void loadAllStatementsSortedByDateTest() throws SQLException {
		List<News> res = news.loadAllSortedByDateDesc();
		displayAllList(res);
	}

	private static void saveInsertStatementTest() {
		News newsObject = new News();
		newsObject.setId(2000);
		newsObject.setAuthor("Author");
		newsObject.setDate(new Date());
		newsObject.setLongText("Looooooooooooooooong text");
		newsObject.setShortText("Short Text");
		newsObject.setTitle("title");
		news.save(newsObject);
	}

	private static void updateStatementTest() {
		News newsObject = new News();
		newsObject.setId(1);
		newsObject.setAuthor("Author");
		newsObject.setDate(new Date());
		newsObject.setLongText("Looooooooooooooooong text updated");
		newsObject.setShortText("Short Text");
		newsObject.setTitle("title");
		news.save(newsObject);
	}

	public static void displayAllList(List<News> res) {
		System.out.println("----------------------------------------------");
		for (News obj : res) {
			System.out.println(obj);
		}
		System.out.println("----------------------------------------------");
	}

	public static void deleteStatementTest() {
		try {
			List<News> result = news.loadAll();
			if(!result.isEmpty()){
			news.delete(result.get(0).getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void loadStatementByIdTest() {
		try {
			List<News> result = news.loadAll();
			News load = news.load(result.get(0).getId());
			System.out.println(load);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
