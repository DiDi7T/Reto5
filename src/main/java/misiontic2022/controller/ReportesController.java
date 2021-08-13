package misiontic2022.controller;

import java.sql.SQLException;
import java.util.List;

import misiontic2022.model.dao.ComprasDeLiderDao;
import misiontic2022.model.vo.ComprasDeLiderVo;

public class ReportesController {
    
    private ComprasDeLiderDao comprasDeLiderDao;

    public ReportesController() {
        comprasDeLiderDao = new ComprasDeLiderDao();
    }

    public List<ComprasDeLiderVo> listarProyectosPorBanco(String Banco)throws SQLException {
        return comprasDeLiderDao.listarProyectosPorBanco(Banco);
    }

}
