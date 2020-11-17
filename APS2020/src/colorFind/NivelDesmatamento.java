package colorFind;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import separadorImagem.DividirImagem;


public class NivelDesmatamento {
	
	ArrayList<Integer> nivelDesmatamento = new ArrayList<Integer>();//0-5 (0 = totalmente verde/sem desmatamento) (5 = sem verde/com muito desmatamento)
	ArrayList<Color> cores = new ArrayList<Color>(); //corDominante = cor dominante em rgb
	
	public Color verdeBase = new Color(0,255,0);//nível 0 desmatamento
	
	//divisão de imagem (para quando for usado a divisão da imagem
	ArrayList<BufferedImage> imagens = new ArrayList<BufferedImage>();
	BufferedImage imagemJaSeparada;
	
	//chamada de método e envio de arquivo para a achada de cor dominante
	public NivelDesmatamento(File file) throws IOException{
		
		BufferedImage image = ImageIO.read(file); //pega o caminho do arquivo e transforma em bufferedimage para ser analisado em seguida

		//travar o tamanho da imagem em 400x400
		Image tmp = image.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		BufferedImage dimg =  new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    image = dimg;
		//travar o tamanho da imagem em 400x400
		
		DividirImagem imagemDividida = new DividirImagem(image);

		//pegar e divide imagem
		imagens = imagemDividida.RetornaListaImagens(); //retorna lista de imagens divididas
		imagemJaSeparada = imagemDividida.RetornaImagemSeparada();		
		
		//loop para adição e analise de rgb 
		for (int i = 0; i < imagens.size(); i++) {
			cores.add(new AcharCorDominante(imagens.get(i)).RetornaCorDominante());//adiciona todas as cores dominantes das imagens na lista corDominante
		}
	}
	
	//analisa a similaridade da cor com verde e vermelho
	public int Similaridade(Color corBase) {
		double distanciaVerde = verdeBase.getGreen() - corBase.getGreen();//distancia do verde padrão
		
		double base = 25.5;//255/10=25.5, essa será a base que calculará o nível de desmatamento
		
		int nivelDesmatamento = 0; //nível de desmatamento que será retornado
		
		if(distanciaVerde <= base) {//caso a distância entre o verdebase e a cor pesquisada seja menor que 1/10 de 255 (255 = espectro de cor verde)
			nivelDesmatamento = 0;//nível 0 de desmatamento (sem nenhum desmatamento)
		}
		else if(distanciaVerde <= base*2){//caso a distância entre o verdebase e a cor pesquisada seja maior que 1/10 e menor que 2/10 de 255 (255 = espectro de cor verde)
			nivelDesmatamento = 1;//nível 1 de desmatamento (com pouquíssimo desmatamento)
		}
		else if(distanciaVerde <= base*3){//caso a distância entre o verdebase e a cor pesquisada seja maior que 2/10 e menor que 3/10 de 255 (255 = espectro de cor verde)
			nivelDesmatamento = 2;//nível 2 de desmatamento (com pouco desmatamento)
		}
		else if(distanciaVerde <= base*4){//caso a distância entre o verdebase e a cor pesquisada seja maior que 3/10 e menor que 4/10 de 255 (255 = espectro de cor verde)
			nivelDesmatamento = 3;//nível 3 de desmatamento (com desmatamento moderado para baixo)
		}
		else if(distanciaVerde <= base*5){//caso a distância entre o verdebase e a cor pesquisada seja maior que 4/10 e menor que 5/10 de 255 (255 = espectro de cor verde)
			nivelDesmatamento = 4;//nível 4 de desmatamento (com desmatamento moderado para alto)
		}
		else if(distanciaVerde <= base*6){//caso a distância entre o verdebase e a cor pesquisada seja maior que 5/10 e menor que 6/10 de 255 (255 = espectro de cor verde)
			nivelDesmatamento = 5;//nível 5 de desmatamento (com desmatamento considerável)
		}
		else if(distanciaVerde <= base*7){//caso a distância entre o verdebase e a cor pesquisada seja maior que 6/10 e menor que 7/10 de 255 (255 = espectro de cor verde)
			nivelDesmatamento = 6;//nível 6 de desmatamento (com elevado nível de desmatamento)
		}
		else if(distanciaVerde <= base*8){//caso a distância entre o verdebase e a cor pesquisada seja maior que 7/10 e menor que 8/10 de 255 (255 = espectro de cor verde)
			nivelDesmatamento = 7;//nível 7 de desmatamento (com alto nível de desmatamento)
		}
		else if(distanciaVerde <= base*9){//caso a distância entre o verdebase e a cor pesquisada seja maior que 8/10 e menor que 9/10 de 255 (255 = espectro de cor verde)
			nivelDesmatamento = 8;//nível 8 de desmatamento (com muitíssimo desmatamento)
		}
		else if(distanciaVerde <= base*10){//caso a distância entre o verdebase e a cor pesquisada seja maior que 9/10 e menor que 10/10 de 255 (255 = espectro de cor verde)
			nivelDesmatamento = 9;//nível 9 de desmatamento (totalmente desmatado)
		}
		
		return nivelDesmatamento;
	}
	
	//faz os calculos de desmatamento e insere na lista
	public void CalculoDesmatamento() {
		//loop para calcular o nível de desmatamento e inserir dentro da lista nivelDesmatamento
		for (int i = 0; i < cores.size(); i++) {
			nivelDesmatamento.add(i, Similaridade(cores.get(i)));//corDominante e nivelDesmatamento tem o mesmo index
		}
	}
	
	
	//retorna a lista com as cores dominantes, os index são os mesmos das imagens e niveis de desmatamento
		public ArrayList<Color> RetornaListaCoresDominantes() {
			return cores;
		}
	
	//retorna a lista com niveis de desmatamento, os index são os mesmos das imagens e cores dominantes
	public ArrayList<Integer> RetornaListaNivelDesmatamento() {
		this.CalculoDesmatamento();
		return nivelDesmatamento;
	}
	
	//retorna imagem já separada para ser colocada dentro da interface gráfica
	public BufferedImage RetornaImagemSeparada() {
		return imagemJaSeparada;
	}
	
}
