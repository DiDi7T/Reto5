package misiontic2022;



import misiontic2022.view.FrmVista;

// import misiontic2022.view.ReportesView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // var view = new ReportesView();
        //var view = new NewJFrame();
        var view = new FrmVista();
        view.setVisible(true);
        // view.proyectosFinanciadosPorBanco("Bancolombia");
        // view.totalPagadoPorProyectosSuperioresALimite(40_000d);
        // view.lideresQueMenosGastan();
        
    }
}
