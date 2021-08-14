package misiontic2022;


import misiontic2022.view.ReportesView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var view = new ReportesView();
        view.proyectosFinanciadosPorBanco("Davivienda");
        view.totalPagadoPorProyectosSuperioresALimite(50_000d);
        view.lideresQueMenosGastan();
        
    }
}
