package misiontic2022.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import misiontic2022.model.vo.ComprasDeLiderVo;
import misiontic2022.util.JDBCUtilities;

public class ComprasDeLiderDao {

    public List<ComprasDeLiderVo> listarProyectosPorBanco(String Banco) throws SQLException {
        List<ComprasDeLiderVo> respuesta = new ArrayList<>();

        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            var query = "SELECT p.ID_Proyecto ID, p.Constructora, p.Ciudad, p.Clasificacion, t.Estrato,"
                    + " (l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido) AS LIDER"
                    + " FROM Proyecto p" + " INNER JOIN Tipo t ON t.ID_Tipo = p.ID_Tipo"
                    + " INNER JOIN Lider l ON l.ID_Lider = p.ID_Lider" + " WHERE p.Banco_Vinculado = (?)"
                    + " ORDER BY p.Fecha_Inicio DESC , p.Ciudad ASC , p.Constructora";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, Banco);
            rset = stmt.executeQuery();
            while (rset.next()) {
                var vo = new ComprasDeLiderVo();
                vo.setId(rset.getInt("ID"));
                vo.setConstructora(rset.getString("Constructora"));
                vo.setCiudad(rset.getString("Ciudad"));
                vo.setClasificacion(rset.getString("Clasificacion"));
                vo.setEstrato(rset.getInt("Estrato"));
                vo.setLider(rset.getString("LIDER"));
                respuesta.add(vo);
            }
        } finally {
            if (rset != null) {
                rset.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta;
    }

}
