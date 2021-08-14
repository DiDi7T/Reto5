package misiontic2022.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import misiontic2022.model.vo.PagadoPorProyectoVo;
import misiontic2022.util.JDBCUtilities;

public class PagadoPorProyectoDao {

    public List<PagadoPorProyectoVo> listarPagadoPorProyecto(Double limiteInferior ) throws SQLException {
        List<PagadoPorProyectoVo> respuesta = new ArrayList<>();

        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;

        try {
            var query = "SELECT p.ID_Proyecto, SUM(c.Cantidad*mc.Precio_Unidad) AS VALOR"
                     + " FROM Proyecto p"
                     + " INNER JOIN Compra c ON c.ID_Proyecto = p.ID_Proyecto"
                     + " INNER JOIN MaterialConstruccion mc ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion"
                     + " WHERE c.Pagado = 'Si' "
                     + " GROUP BY p.ID_Proyecto"
                     + " HAVING SUM(c.Cantidad*mc.Precio_Unidad) > (?)"
                     + " ORDER BY  VALOR DESC";
            stmt = conn.prepareStatement(query);
            stmt.setDouble(1,limiteInferior);
            rset = stmt.executeQuery();
            while (rset.next()) {
                var vo = new PagadoPorProyectoVo();
                vo.setId(rset.getInt("ID_Proyecto"));
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
