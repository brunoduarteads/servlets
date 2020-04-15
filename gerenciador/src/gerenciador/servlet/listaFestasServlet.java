package gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/listaFestas")
public class listaFestasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	Banco banco = new Banco();
	List<FestasCadastradas> lista = banco.getFestasCadastradas();
	
	PrintWriter out = response.getWriter();
	
	out.println("<html><body>");
	out.println("<ul>");
	
	for (FestasCadastradas festa : lista) {
		out.println("<li>Tema da festa:" + festa.getTemaSelecionado() +
	                "Nome do(a) Aniversariante:" + festa.getNomeAniversariante() +
	                "Nome do contratante:" + festa.getNomeCliente() +
	                "Data do evento:" + festa.getDataText() +
	                "Horario de início:" + festa.getHoraInicio() +
	                "Horario de Término:" + festa.getHoraFim() +
	               	"</li>");
	}
	out.println("</ul>");
	out.println("</html></body>");
	out.close();
	
	
	}

}
