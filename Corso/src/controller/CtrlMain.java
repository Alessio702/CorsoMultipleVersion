package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CtrlMain
 */
@WebServlet({ "/CtrlMain", "/CorsiDiFormazione" })
public class CtrlMain extends HttpServlet 
{
 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrlMain() 
    {
        super();
    }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
  // TODO Auto-generated method stub
  // response.getWriter().append("Served at: ").append(request.getContextPath());
  // Dispacciamento JSP >>
  visualizzaMenu(request, response);
  
   
 }

 private void visualizzaMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
  // TODO Auto-generated method stub
  // 1 Definizione di un oggetto della classe Servlet Contest
  ServletContext oContesto = getServletContext();
  // 2 Definizione di un oggetto per la pubblicazione della PGS
  RequestDispatcher oDispatcher = oContesto.getRequestDispatcher("/Applicazione/PgsMain.jsp");
  // 3 Pubblicare
  oDispatcher.forward(request, response);
  // Attivare servlet ArchivioDocente (con Dispatcher)
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
 {
  // TODO Auto-generated method stub
  String controller = "";
  String valoreScelto = req.getParameter("rdoScelta");
  
  if (valoreScelto != null)
  {
   int valore = Integer.parseInt(valoreScelto);
   switch (valore)
   {
    case 0:
     controller = "/CtrlArchivioDocente";
     break;
    case 1:
     controller = "/CtrlArchivioDiscente";
     break;
    case 2:
     controller = "/CtrlGestioneCorso";
     break;
    case 3:
     controller = "/CtrlRicercaCorsoPerDocente";
     break;
    case 4:
        controller = "/CtrlRicercaCorsoPerDiscente";
        break;
    default:
     visualizzaMenu(req, res);
     break;
   }
  
   /*
   //doGet(request, response);
   // 1 Definizione di un oggetto della classe Servlet Contest
   ServletContext oContesto = getServletContext();
   // 2 Definizione di un oggetto per la pubblicazione della PGS
   RequestDispatcher oDispatcher = oContesto.getRequestDispatcher(controller);
   // 3 Pubblicare
   oDispatcher.forward(req, res);*/
   
   getServletContext().getRequestDispatcher(controller).forward(req, res);
  }
  else
  {
   visualizzaMenu(req, res);
  }
 }
}