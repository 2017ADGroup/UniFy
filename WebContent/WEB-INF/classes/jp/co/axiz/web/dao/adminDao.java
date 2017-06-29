package jp.co.axiz.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dto.adminDto;

@Repository
public class adminDao {

	@Autowired
	private JdbcTemplate jdbc;
	@Autowired
	private adminDto dto;


	public List<adminDto> login(String id, String pass) {

		ArrayList<adminDto> list = new ArrayList<adminDto>();
		jdbc.query("SELECT * FROM admin", new BeanPropertyRowMapper<adminDto>(adminDto.class) {
			public adminDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs.getString("admin_id").equals(id) && rs.getString("password").equals(pass)) {
					while (rs.next()) {
						adminDto a = new adminDto(rs.getString("admin_id"), rs.getString("admin_name"),
								rs.getString("password"));
						list.add(a);

					}

				}
				return dto;

			}
		});
		return list;
	}

	public List<adminDto> syutoku(String id) {

	List<adminDto> list	=jdbc.query("SELECT * FROM admin WHERE admin_id = ?", new BeanPropertyRowMapper<adminDto>(adminDto.class),id) ;{

		return  list;
	}

	}


}
