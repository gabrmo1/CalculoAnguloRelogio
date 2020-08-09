import java.util.Calendar;
//importando calendário.
import javax.swing.JOptionPane;

//Importando JoptionPane.
public class GregorianCalendar {
//determinando a classe.
	Calendar cal = Calendar.getInstance();
	// Criando uma variável para iniciar o calendário.

	double ponteiroDosMinutos, variacao = 0, ponteiroDasHoras, resultado, hora = cal.get(Calendar.HOUR_OF_DAY);
	// Criando e iniciando as variáveis a serem utilizadas.

	public void retornaAnguloRelogio() {
		// Abrindo método para execução do código através da outra classe.

		if (hora < 12) {
			JOptionPane.showMessageDialog(null, "Bom dia! ");
			// Exibindo uma mensagem de bom dia caso seja antes do meio dia.

		} else if (hora >= 12 && hora < 18) {
			JOptionPane.showMessageDialog(null, "Boa Tarde! ");
			// Exibindo uma mensagem de boa tarde caso esteja entre 12 e 18h.

		} else {
			JOptionPane.showMessageDialog(null, "Boa Noite! ");
			// Exibindo uma mensagem de boa noite caso já tenha passado das 18h.
		}

		ponteiroDasHoras = Double
				.parseDouble(JOptionPane.showInputDialog("Por gentileza, Informe a hora (insira um número de 0 a 12)"));
		// Solicitando a entrada de um dos dados fundamentais para a execução do
		// programa.

		if (ponteiroDasHoras == 12) {
			ponteiroDasHoras = 0;
			// Convertendo o horário "12 horas" para "0 horas" pelo relógio se limitar a no
			// máximo 11 horas e 59 minutos.
		}
		if (ponteiroDasHoras > 12) {
			JOptionPane.showMessageDialog(null, "Informe um número entre 0 e 12 após executar o programa novamente!");
			// Impedindo que o programa continue a ser executado caso se encaixe nessa
			// condição(maior que 12).

			System.exit(0);
		}
		// criando uma condição para caso o número da hora seja menor do que zero
		if (ponteiroDasHoras < 0) {
			JOptionPane.showMessageDialog(null, "Informe um número entre 0 e 12 após executar o programa novamente!");
			// Apontando irregularidade perante a solicitação.

			System.exit(0);
			// Impedindo que o programa continue a ser executado caso se encaixe nessa
			// condição.
		}
		ponteiroDosMinutos = Double
				.parseDouble(JOptionPane.showInputDialog("e agora os minutos (insira um número de 0 a 59)"));
		// Limitando os dados de entrada para serem no máximo 59.

		if (ponteiroDosMinutos > 59) {
			JOptionPane.showMessageDialog(null, "Informe um número entre 0 e 59 após executar o programa novamente!");
			// Apontando irregularidade.

			System.exit(0);
			// Impedindo que o programa continue a ser executado caso se encaixe nessa
			// condição
		}

		if (ponteiroDosMinutos < 0) {
			// Criando uma condição para o número solicitado não poder ser menor que 0.
			JOptionPane.showMessageDialog(null, "Informe um número entre 0 e 59 após executar o programa novamente!");
			// Apontando irregularidade, caso haja.
			System.exit(0);
			// Impedindo que o programa continue a ser executado caso se encaixe nessa
			// condição(menor que 0).

			/*
			 * AVISO: O resultado obtido leva em consideração o movimento do ponteiro
			 * menor(das horas) em relação à rotação do ponteiro maior(dos minutos), ou
			 * seja, às 03:30h, o ponteiro menor esteria entre o número 3 e o 4 no relógio,
			 * assim variando a relação angular.
			 */
		}

		if (ponteiroDasHoras * 30 > ponteiroDosMinutos * 6) {
			// Definindo uma condição para maior precisão e execução correta do cálculo
			variacao = -ponteiroDosMinutos / 2;
			// Definindo para negativo caso o ponteiro das horas tenha percorrido um
			// percurso maior.

		} else if (ponteiroDasHoras * 30 < ponteiroDosMinutos * 6) {
			variacao = ponteiroDosMinutos / 2;
			// Definindo para positivo caso o ponteiro dos minutos tenha percorrido um
			// percurso maior.
		}

		resultado = ponteiroDasHoras * 30 - ponteiroDosMinutos * 6 + variacao;
		// Fazendo a execução da fórmula para obter o resultado.

		JOptionPane.showMessageDialog(null,
				"O ângulo entre os dois ponteiros do relógio é " + Math.abs(resultado) + " graus.");
		// Exibe o resultado, convertendo em um número positivo.
	}

}
