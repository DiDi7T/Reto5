package misiontic2022.view;

import java.sql.SQLException;

import misiontic2022.controller.ReportesController;
import misiontic2022.model.vo.ProyectoBancoVo;
import misiontic2022.model.vo.ComprasDeLiderVo;
import misiontic2022.model.vo.PagadoPorProyectoVo;

public class ReportesView {

    private ReportesController reportesController;

    public ReportesView() {
        reportesController = new ReportesController();
    }

    private String repitaCaracter(Character caracter, Integer veces) {
        var respuesta = "";
        for (int i = 0; i < veces; i++) {
            respuesta += caracter;
        }
        return respuesta;
    }

    public void proyectosFinanciadosPorBanco(String banco) {
        try {

            System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO " + repitaCaracter('=', 37));
            if (banco != null && !banco.isBlank()) {
            System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s", "ID", "CONSTRUCTORA", "CIUDAD",
                    "CLASIFICACION", "ESTRATO", "LIDER"));
            System.out.println(repitaCaracter('-', 105));}

            var lista = reportesController.listarProyectosPorBanco(banco);
            for (ProyectoBancoVo proyecto : lista) {
                System.out.printf("%3d %-25s %-20s %-15s %7d %-30s %n", proyecto.getId(), proyecto.getConstructora(),
                        proyecto.getCiudad(), proyecto.getClasificacion(), proyecto.getEstrato(), proyecto.getLider());
            }

        } catch (SQLException e) {
            System.err.println(":c malu" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void totalPagadoPorProyectosSuperioresALimite(Double limiteInferior){
        try {

            System.out.println(repitaCaracter('=', 1) + " TOTAL PAGADO POR PROYECTO " + repitaCaracter('=', 1));
            if (limiteInferior != null) {
            System.out.println(String.format("%3s %14s", "ID", "VALOR "));
            System.out.println(repitaCaracter('-', 29));}

            var lista = reportesController.listarPagadoPorProyecto(limiteInferior);
            for (PagadoPorProyectoVo proyecto : lista) {
                System.out.printf("%3s %,15.1f %n", proyecto.getId(), proyecto.getValor());
            }    

        } catch (SQLException e) {
            System.err.println("Error" + e.getMessage());
            e.printStackTrace();
        }
    }


    public void lideresQueMenosGastan() {
        try {
            System.out.println(repitaCaracter('=', 5) + " 10 LIDERES MENOS COMPRADORES "
            + repitaCaracter('=', 6));
            System.out.println(String.format("%-25s %14s", "LIDER", "VALOR "));
            System.out.println(repitaCaracter('-', 41));

            var lista = reportesController.listarLideresQueMenosGastan();
            for (ComprasDeLiderVo proyecto : lista){
                System.out.printf("%-25s %,15.1f %n", proyecto.getId(), proyecto.getValor());
            }

        } catch (SQLException e) {
           System.err.println("Error" + e.getMessage());
            e.printStackTrace();
        }
    }
       

}
