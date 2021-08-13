package misiontic2022;

import java.sql.SQLException;

import misiontic2022.controller.ReportesController;
import misiontic2022.model.dao.ComprasDeLiderDao;
import misiontic2022.model.vo.ComprasDeLiderVo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
        try {
            var controller = new ReportesController();
            var lista = controller.listarProyectosPorBanco("Davivienda");
            for(ComprasDeLiderVo consulta :lista){
                System.out.println(consulta);
            }
            System.out.println("listu");
            
        } catch (SQLException e) {
            System.err.println(":c malu"+ e);
            e.printStackTrace();
        }
        
        
    }
}
