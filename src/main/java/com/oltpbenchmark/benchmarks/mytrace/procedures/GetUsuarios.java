package com.oltpbenchmark.benchmarks.mytrace.procedures;

import com.oltpbenchmark.api.Procedure;
import com.oltpbenchmark.api.SQLStmt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetUsuarios extends Procedure {

  public final SQLStmt getUsuarios = new SQLStmt("SELECT * FROM usuario");

  public void run(Connection conn) throws Exception {

    try (PreparedStatement stmt = this.getPreparedStatement(conn, getUsuarios)) {

      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        rs.getInt("id");
        rs.getString("nome");
        rs.getInt("idade");
      }

      rs.close();
    }
  }
}
