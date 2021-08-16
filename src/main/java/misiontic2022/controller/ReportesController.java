package misiontic2022.controller;

import java.sql.SQLException;
import java.util.List;

import misiontic2022.model.dao.ProyectoBancoDao;
import misiontic2022.model.dao.ComprasDeLiderDao;
import misiontic2022.model.dao.PagadoPorProyectoDao;
import misiontic2022.model.vo.ProyectoBancoVo;
import misiontic2022.model.vo.PagadoPorProyectoVo;
import misiontic2022.model.vo.ComprasDeLiderVo;

public class ReportesController {
    
    private ProyectoBancoDao proyectoBancoDao;
    private PagadoPorProyectoDao pagadoPorProyectoDao;
    private ComprasDeLiderDao comprasDeLiderDao;

    public ReportesController() {
        proyectoBancoDao = new ProyectoBancoDao();
        pagadoPorProyectoDao = new PagadoPorProyectoDao();
        comprasDeLiderDao = new ComprasDeLiderDao();
    }

    public List<ProyectoBancoVo> listarProyectosPorBanco(String banco)throws SQLException {
        return proyectoBancoDao.listarProyectosPorBanco(banco);
    }

    public List<PagadoPorProyectoVo> listarPagadoPorProyecto(Double limiteInferior) throws SQLException{
        return pagadoPorProyectoDao.listarPagadoPorProyecto(limiteInferior);
    }

    public List<ComprasDeLiderVo> listarLideresQueMenosGastan()throws SQLException{
        return comprasDeLiderDao.listarLideresQueMenosGastan();
    }
}
