package info.programese.presentation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import info.programese.model.AreaComputacao;
import info.programese.model.AssuntoPedagogico;
import info.programese.model.FormaAbordagem;
import info.programese.model.ObjetoAprendizado;

public class GeradorTXTDetalhesObjeto {
	public static void main(ObjetoAprendizado objeto) {

		
		String home = System.getProperty("user.home");
		File arquivo = new File(home+"/Downloads/detalhes_objeto_" + objeto.getId() + ".txt");

		try {
			if (!arquivo.exists()) {
				// cria um arquivo (vazio)
				arquivo.createNewFile();
			}

			// escreve no arquivo
			FileWriter fileWriter = new FileWriter(arquivo, true);

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write("Objeto de Aprendizado");
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			
			bufferedWriter.write("Titulo: "+objeto.getTitulo());
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			
			bufferedWriter.write("Autor(a): "+objeto.getUsuarioCriador().getNome());
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			
			bufferedWriter.write("Assuntos Pedaggogicos: ");
			for(AssuntoPedagogico assunto : objeto.getAssuntosPedagogicos()){
				bufferedWriter.write(assunto.getTitulo());
				bufferedWriter.write("   ");
			}
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			
			bufferedWriter.write("Conceitos de Computação: ");
			for(AreaComputacao area: objeto.getAreasComputacao()){
				bufferedWriter.write(area.getTitulo());
				bufferedWriter.write("   ");
			}
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			
			bufferedWriter.write("Formas de Abordagem:");
			for(FormaAbordagem formas: objeto.getFormasAbordagens()){
				bufferedWriter.write(formas.getTitulo());
				bufferedWriter.write("   ");
			}
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			
			bufferedWriter.write("Objetivos: "+objeto.getObjetivo());
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			
			bufferedWriter.write("Quantidade Minima de Pessoas: "+objeto.getQuantidadeMinimaPessoas());
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			
			bufferedWriter.write("Quantidade Maxima de Pessoas: "+objeto.getQuantidadeMaximaPessoas());
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			
			bufferedWriter.write("Descrição: "+objeto.getDescricao());
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			
			bufferedWriter.write("Feedback: "+objeto.getFeedback());
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			
			bufferedWriter.write("Referências: "+objeto.getReferencias());
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			
			bufferedWriter.close();
			fileWriter.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
