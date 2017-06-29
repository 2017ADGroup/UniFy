package jp.co.axiz.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dto.userinfoDto;

@Repository
public class userinfoDao {

	@Autowired
	private JdbcTemplate jdbc;
	@Autowired
	private userinfoDto dto2;

	// 検索メソッド
	public List<userinfoDto> select(String id, String name, String tel) {
		ArrayList<userinfoDto> list = new ArrayList<userinfoDto>();

		jdbc.query("SELECT user_id,user_name, telephone FROM user_info ORDER BY  user_id ",
				new BeanPropertyRowMapper<userinfoDto>(userinfoDto.class) {
					public userinfoDto mapRow(ResultSet rs, int rowNum) throws SQLException {

							if ((id.equals(rs.getString("user_id")) || (id.equals("")))
									&& ((name.equals(rs.getString("user_name")) || (name.equals("")))
											&& ((tel.equals(rs.getString("telephone")) || (tel.equals("")))))) {
								userinfoDto a = new userinfoDto(rs.getLong("user_id"), rs.getString("user_name"),
										rs.getString("telephone"));
								System.out.println(rs.getLong("user_id"));
								list.add(a);

						}
						return dto2;

					}

				});
		return list;

	}

	public void insert(String name, String tel, String pass) {

		jdbc.update("INSERT INTO user_info (user_name, telephone, password) VALUES (?, ?, ?)", name, tel, pass);

	}

	public userinfoDto syutoku(String id) {

		jdbc.query("SELECT * FROM user_info", new BeanPropertyRowMapper<userinfoDto>(userinfoDto.class) {

			public userinfoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				while (rs.next()) {
					if (id.equals(rs.getString("user_id"))) {
						dto2 = new userinfoDto(rs.getLong("user_id"), rs.getString("user_name"),
								rs.getString("telephone"), rs.getString("password"));
						return dto2;

					}
				}
				return dto2;

			}
		});
		return dto2;
	}

	public void delete(Long id) {
		jdbc.update("DELETE FROM user_info WHERE user_id=?", id);
	}

	// 更新メソッド
	public void update(String name, String tel, String pass, Long id) {

		jdbc.update("UPDATE user_info SET user_name=?, telephone=?, password=? WHERE user_id=?", name, tel, pass, id);

	}

	public Integer MAX() {

		Integer list = jdbc.queryForObject("SELECT MAX(user_id) FROM user_info",
				Integer.class);
		{
System.out.println(list);
			return list;
		}
	}
}
