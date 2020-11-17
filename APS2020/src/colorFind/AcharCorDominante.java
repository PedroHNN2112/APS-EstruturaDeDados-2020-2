package colorFind;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class AcharCorDominante {

	BufferedImage foto; //pega foto
	int altura; //pega altura da foto
	int largura; //pega largura da foto
	
	ArrayList<Color> listaCores = new ArrayList<Color>();//lista de todas as cores de todos os pixels encontrados na foto
	
	Color corMaisUsada;
	
	//chamada de método, pega a foto e já coloca todas as cores de pixels dentro da listaCores
	public AcharCorDominante(BufferedImage foto)  throws IOException{
		this.foto = foto; 
		this.altura = this.foto.getHeight();
		this.largura = this.foto.getWidth();
		
		//loop duplo para pegar a cor de cada pixel e inserir dentro da listaCores
		for (int x = 0; x < this.largura; x++) {
		    for (int y = 0; y < this.altura; y++) {

		    	if(this.foto.getRGB(x, y) != -1 && this.foto.getRGB(x, y) != -16777216) {//caso a cor for preto(-1) ou branco(-16777216), não será incluída, ou seja, todo pixel preto e branco é descartado
		    		int pixel = this.foto.getRGB(x, y);//pega a cor do pixel correspondente nos eixos x e y
		        	
		    		//analisa qual o rgb da cor pega no pixel acima
			        int red = (pixel >> 16) & 0xff;
			        int green = (pixel >> 8) & 0xff;
			        int blue = (pixel) & 0xff;
			        
			        this.listaCores.add(new Color(red,green,blue)); //insere a cor dentro da listaCores
		    	}                                                                          
		    }
		}
		
	}
	
	//contagem de quantas vezes uma cor especifica é usada e salva a cor mais usada na variável corMaisUsada
	public void Contagem() {
		
		ArrayList<Color> cores = new ArrayList<Color>(); //guarda as cores sem repetição (caso haja repetição, irá ser ignorado)
		ArrayList<Integer> contador = new ArrayList<Integer>(); //contador de quantas vezes uma cor foi usada, USA O MESMO INDEX que o cores
		
		//loop para adicionar as cores do listaCores no cores e usar o contador
		for (int i = 0; i < listaCores.size(); i++) {
			
			if(cores.contains(listaCores.get(i))) {//se encontra a mesma cor no cores
					contador.set(cores.indexOf(listaCores.get(i)), contador.get(cores.indexOf(listaCores.get(i)))+1);//adiciona no mesmo index da cor +1 no contador
			}else { //caso não encontre a mesma cor no cores
					cores.add(listaCores.get(i));//adiciona a cor no cores
					contador.add(1); //adiciona 1 no contador com o mesmo index
			} 
		}
		
		int maiorNumero = 0;//variável que armazena o maior número dentro do contador
		int indexMaiorNumero = 0;//variável que armazena o index do maior número dentro do contador
		
		//loop para pegar o maior número dentro do contador
		for (int i = 0; i < contador.size(); i++) {
			
			if(maiorNumero < contador.get(i)) { //se o maiorNumero for menor que o número contado pelo loop, ele é substituído e o indexMaiorNumero vira o index usado no loop
					maiorNumero = contador.get(i);
					indexMaiorNumero = i;
			}
		}

		this.corMaisUsada = cores.get(indexMaiorNumero);
	}
	
	//chama a contagem e retorna a cor mais usada
	public Color RetornaCorDominante() {
		this.Contagem();
		return corMaisUsada;
	}
	
}
