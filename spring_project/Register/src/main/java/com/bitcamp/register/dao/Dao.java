package com.bitcamp.register.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.bitcamp.register.domain.Member;

public interface Dao {

	public int insertMember(Connection conn, Member member) throws SQLException;
}
