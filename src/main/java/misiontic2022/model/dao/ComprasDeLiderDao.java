package misiontic2022.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import misiontic2022.model.vo.ComprasDeLiderVo;
import misiontic2022.util.JDBCUtilities;

public class ComprasDeLiderDao {

    public List<ComprasDeLiderVo> listarLideresQueMenosGastan() throws SQLException {
        List<ComprasDeLiderVo> respuesta = new ArrayList<>();

        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            var query = "SELECT (l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido) AS LIDER,"
                      + " SUM(c.Cantidad*mc.Precio_Unidad) AS VALOR"
                      + " FROM Proyecto p"
                      + " INNER JOIN Compra c ON c.ID_Proyecto = p.ID_Proyecto"
                      + " INNER JOIN MaterialConstruccion mc ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion"
                      + " INNER JOIN Lider l ON l.ID_Lider = p.ID_Lider"
                      + " GROUP BY l.Nombre, l.Primer_Apellido, l.Segundo_Apellido" 
                      + " ORDER BY VALOR LIMIT 10";
            stmt = conn.prepareStatement(query);
            rset = stmt.executeQuery();
            while (rset.next()) {
                var vo = new ComprasDeLiderVo();
                vo.setId(rset.getString("LIDER"));
                vo.setValor(rset.getDouble("VALOR"));
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
