package MT.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class RestaurantDAO {
	
	// Connection pool
	private static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			// Connection pool����
			String resource = "MT/mapper/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<RestaurantVO> getMenuRestaurant(String menu_id) {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<RestaurantVO> restList = session.selectList("selectMenuRest", menu_id);
		session.close();
		return restList;
	}
}
