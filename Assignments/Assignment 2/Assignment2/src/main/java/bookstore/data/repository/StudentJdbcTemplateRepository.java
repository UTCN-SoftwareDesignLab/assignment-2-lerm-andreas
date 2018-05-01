package bookstore.data.repository;

import org.springframework.stereotype.Repository;

@Repository
public class StudentJdbcTemplateRepository
{
//	@Autowired
//	private DataSource dataSource;
//
//	private String selectAllQuery = "SELECT * from students ";
//	private String byFirstNameQuery = "SELECT * from students WHERE first_name=?";
//
//	public List<User> getStudentsByFirstName(String firstName)
//	{
//		List<User> students = new ArrayList<User>();
//		List<Map<String, Object>> studentsLowLevelDbMapList = new ArrayList<Map<String, Object>>();
//		try
//		{
//			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//			studentsLowLevelDbMapList = jdbcTemplate.queryForList(byFirstNameQuery, new Object[] { firstName });
//
//			for (Map<String, Object> m : studentsLowLevelDbMapList)
//			{
//				User s = new User();
//				s.setId((int) m.get("id"));
//				s.setFirstName((String) m.get("first_name"));
//				s.setLastName((String) m.get("last_name"));
//
//				students.add(s);
//			}
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//
//		return students;
//	}
//

}