package gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastroFesta")
public class CadastroFestaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeAniversariante = request.getParameter("aniversariante");
        String nomeCliente = request.getParameter("nome");
        String temaSelecionado = request.getParameter("selecionaTema");
        String dataText = request.getParameter("data");
        String horaInicio = request.getParameter("horario_inicio");
        String horaFim = request.getParameter("horario_termino");
        
        request.setAttribute("aniversariante", nomeAniversariante);
    
        
        FestasCadastradas festa = new FestasCadastradas();
        festa.setNomeCliente(nomeCliente);
        festa.setDataText(dataText);
        festa.setNomeAniversariante(nomeAniversariante);
        festa.setTemaSelecionado(temaSelecionado);
        festa.setHoraInicio(horaInicio);
        festa.setHoraFim(horaFim);
        
        Banco banco = new Banco();
        banco.adiciona(festa);

    	PrintWriter out = response.getWriter();
        Calendar data = null;
        Calendar horaini = null;
        Calendar horafi = null;
  
        try {
        	Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataText);
        	data = Calendar.getInstance();
        	data.setTime(date);
        	
        	Date hora1 = new SimpleDateFormat("HH:mm").parse(horaInicio);
        	horaini = Calendar.getInstance();
        	horaini.setTime(hora1);
      
        	Date hora2 = new SimpleDateFormat("HH:mm").parse(horaFim);
        	horafi = Calendar.getInstance();
        	horafi.setTime(hora2);
        	
        	if(hora1.after(hora2)) {
        		out.print("O horario de início deve ser anterior ao de término");
            
            
        	}else{
        		RequestDispatcher rd = request.getRequestDispatcher("/cadastroConcluido.jsp");
        	rd.forward(request, response);
        	}

        }catch (ParseException e) {
        	out.println("Não foi possivel converter esta data");
        	return;
    	}

             out.close();
	}

	
}


