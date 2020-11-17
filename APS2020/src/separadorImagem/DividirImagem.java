package separadorImagem;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class DividirImagem {
	ArrayList<BufferedImage> imagensSeparadas = new ArrayList<BufferedImage>();//lista de imagens depois da separação (são 9 imagens)
	BufferedImage imagemOriginalSeparada; //a imagem inicial, porém com as separações desenhadas para mostrar dentro da interface
	
	int alturaImagemDividida; //altura de cada divisão 
	int larguraImagemDividida; //largura de cada divisão
	
	//chamada de método e já separação de todas as imagens
	public DividirImagem(BufferedImage fotoInicial) throws IOException {
		int tamanhoDivisao = 5; //para dividir a imagem (seja na imagem da interface quanto nas imagens usadas para analise)
		//para calcular a quantidade de imagens que a imagem principal será dividida, só multiplicar tamanhoDivisao*tamanhoDivisao, por exemplo, se tamanhoDivisao = 5, então será um total de 25 imagens
		
		alturaImagemDividida = fotoInicial.getHeight()/tamanhoDivisao;//pega a altura da foto inicial e divide por tamanhoDivisao
		larguraImagemDividida = fotoInicial.getWidth()/tamanhoDivisao;//pega a largura da foto inicial e divide por tamanhoDivisao
		
		//desenhando linhas dentro da imagem para separar em 27 partes
		this.imagemOriginalSeparada = fotoInicial;
		Graphics2D linhas = this.imagemOriginalSeparada.createGraphics(); //criar gráficos dentro da imagem (gráficos = desenhos/modificações na imagem)
		BasicStroke bs = new BasicStroke(2);//"pincel" que será usado para desenhar  na imagem
		linhas.setStroke(bs);
		linhas.setFont(new Font("Serif", Font.BOLD, 10));//fonte que será usada para desenhar números na imagem da interface
		
		int cont = 1;//contador exclusivo para a imagem da interface 
		
		//adicionando todas as separações da imagem inicial dentro da lista e desenha na imagem para a interface
		for (int i = 0; i < tamanhoDivisao; i++) {
			for (int j = 0; j < tamanhoDivisao; j++) {
				//getSubimage(xinicial,yinicial,largura,altura)
				imagensSeparadas.add(fotoInicial.getSubimage(larguraImagemDividida*i, alturaImagemDividida*j, larguraImagemDividida, alturaImagemDividida));//adicionando imagens na lista imagensSeparadas
				
				//desenho na imagem para a interface
				//drawLine(x1,y1,x2,y2) (x1 = x inicial, x2 = x final) (y1 = y inicial, y2 = y final)
				linhas.drawLine(0, alturaImagemDividida*j, imagemOriginalSeparada.getWidth(), alturaImagemDividida*j);//desenhar as linhas horizontais
				linhas.drawLine(larguraImagemDividida*i, 0,larguraImagemDividida*i,imagemOriginalSeparada.getHeight());//desenhar as linhas verticais
				
				//drawString(string,x,y)
				linhas.drawString(Integer.toString(cont), (larguraImagemDividida*i)+(larguraImagemDividida/30),(alturaImagemDividida*j)+(alturaImagemDividida/tamanhoDivisao));
				cont++;
			}
		}
		
		linhas.dispose();
	}
	
	//retorna a lista de imagens separadas para a separação das cores e desmatamento
	public ArrayList<BufferedImage> RetornaListaImagens() {
		return imagensSeparadas;
	}
	
	//retorna a imagem original desenhada com as separações para a interface
	public BufferedImage RetornaImagemSeparada() {
		return imagemOriginalSeparada;
	}
	
}
