package telas;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import colorFind.NivelDesmatamento;
import ordenacao.Ordenar;


public class Interface extends javax.swing.JFrame  {
	
	JTextField txtResultado = new JTextField();
    JButton btProcurar = new JButton();
    JButton btAnalisar = new JButton();
    JLabel lblFoto = new JLabel();
    JTextArea txtAnalise = new JTextArea();
    JButton btOrdenar = new JButton();
    
    JTextArea txtOrdQuickSort = new JTextArea();
    JTextArea txtOrdSelectionSort = new JTextArea();
    JTextArea txtOrdBubbleSort = new JTextArea();

    
	public Interface() {
		new JFrame();
		setTitle("APS 2020/2 - Analise de Desmatamento e Ordenação de Dados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 1050);
        setResizable(false);
        
        txtResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        lblFoto.setSize(400, 400);

        txtResultado.setText("Caminho Para a Imagem");
        txtResultado.setEditable(false);
        txtAnalise.setEditable(false);
        txtOrdQuickSort.setEditable(false);
        txtOrdSelectionSort.setEditable(false);
        txtOrdBubbleSort.setEditable(false);
        
        txtOrdQuickSort.setFont(txtOrdQuickSort.getFont().deriveFont(txtOrdQuickSort.getFont().getSize() - 1.5f));
        txtOrdSelectionSort.setFont(txtOrdSelectionSort.getFont().deriveFont(txtOrdSelectionSort.getFont().getSize() - 1.5f));
        txtOrdBubbleSort.setFont(txtOrdBubbleSort.getFont().deriveFont(txtOrdBubbleSort.getFont().getSize() - 1.5f));
        txtAnalise.setFont(txtAnalise.getFont().deriveFont(txtAnalise.getFont().getSize() - 1.5f));
        
        btProcurar.setText("Procurar");
        btAnalisar.setText("Analisar Imagem");
        btOrdenar.setText("Ordenar Níveis de Desmatamento");
        
        //setBounds(int x-coordinate, int y-coordinate, int width, int height)
        txtResultado.setBounds(5, 5, 390, 30);
        btProcurar.setBounds(395, 5, 100, 30);
        btAnalisar.setBounds(150, 40, 200, 30);
        lblFoto.setBounds(50, 80, 400, 400);
        txtAnalise.setBounds(50,490,400,330);
        btOrdenar.setBounds(95,830,300,30);
        
        txtOrdQuickSort.setBounds(5, 865, 490, 30);
        txtOrdSelectionSort.setBounds(5, 897, 490, 30);
        txtOrdBubbleSort.setBounds(5, 929, 490, 30);
        
        this.add(txtResultado);
        this.add(btProcurar);
        this.add(btAnalisar);
        this.add(lblFoto);
		this.add(btOrdenar);
		this.add(txtOrdBubbleSort);
        this.add(txtOrdQuickSort);
        this.add(txtOrdSelectionSort);
        this.add(txtAnalise);
        
		btOrdenar.setVisible(false);
		txtOrdBubbleSort.setVisible(false);
        txtOrdQuickSort.setVisible(false);
        txtOrdSelectionSort.setVisible(false);
        txtAnalise.setVisible(false);
		
        setLayout(null);
        
        //action listeners btprocurar
        btProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcurarActionPerformed(evt);
            }
        });
        //action listeners btprocurar
        
        //action listeners btanalisar
        btAnalisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
					btAnalisarActionPerformed(evt);
            }
        });
        //action listeners btanalisar
        
        //action listeners btordenar
        btOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
					try {
						btOrdenarActionPerformed(evt);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            }
        });
        //action listeners btordenar
        
	}
	
	//variáveis action performer procurar e analisar
	int resposta;
    File file;
   
	//btProcurar action performer
	private void btProcurarActionPerformed(java.awt.event.ActionEvent evt) { 
		
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        resposta = chooser.showOpenDialog(null);
        
        if (resposta == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();       

            if (file.isFile()){
            	txtResultado.setText(file.getAbsolutePath());
            }
        }
    }
	//btProcurar action performer
	
	//btOrdenar action performer
	private void btOrdenarActionPerformed(java.awt.event.ActionEvent evt) throws IOException { 
		NivelDesmatamento x = new NivelDesmatamento(file);
		
		ArrayList<Integer> niveisDESMATAMENTO = x.RetornaListaNivelDesmatamento();//LISTA DE NÍVEIS DE DESMATAMENTO (não está ordenado ainda) 
		
		int[] listaNaoOrdenada = niveisDESMATAMENTO.stream().mapToInt(i->i).toArray(); //isso é para converter uma arraylist para uma lista comum
		//precisa converter pra usar o sistema de ordenação sem dor de cabeça
		
		int[] listaOrdenadaQuickSort = listaNaoOrdenada;//precisa criar uma lista para cada método de ordenação porque os métodos irão mudar a ordem da lista, então é bom já ter uma de base
		Ordenar.QuickSort(listaOrdenadaQuickSort, 0, listaOrdenadaQuickSort.length-1);
		
		int[] listaOrdenadaSelectionSort = listaNaoOrdenada;//precisa criar uma lista para cada método de ordenação porque os métodos irão mudar a ordem da lista, então é bom já ter uma de base
		Ordenar.SelectionSort(listaOrdenadaSelectionSort);
		
		int[] listaOrdenadaBubbleSort = listaNaoOrdenada;//precisa criar uma lista para cada método de ordenação porque os métodos irão mudar a ordem da lista, então é bom já ter uma de base
		Ordenar.BubbleSort(listaOrdenadaBubbleSort);
		
		//fazer com que ele insira nas lbl e no txtfield
		
		/*
		lblOrdBubbleSort.setText("<html><body>BubbleSort:<br>"+Ordenar.tempoBubbleSort+"<br>nanosegundos</body><html>");
		lblOrdQuickSort.setText("<html><body>QuickSort:<br>"+Ordenar.tempoQuickSort+"<br>nanosegundos</body><html>");
		lblOrdSelectionSort.setText("<html><body>SelectionSort:<br>"+Ordenar.tempoSelectionSort+"<br>nanosegundos</body><html>");

		lblOrdBubbleSort.setVisible(true);
        lblOrdQuickSort.setVisible(true);
        lblOrdSelectionSort.setVisible(true);
		*/
		
		
		String stringQuick = "QuickSort -> Tempo: "+Ordenar.tempoQuickSort+" nanosegundos\nLista ordenada: ";
		String stringSelection = "SelectionSort -> Tempo: "+Ordenar.tempoSelectionSort+" nanosegundos\nLista ordenada: ";
		String stringBubble = "BubbleSort -> Tempo: "+Ordenar.tempoBubbleSort+" nanosegundos\nLista ordenada: ";
		
		for (int i = 0; i < listaOrdenadaQuickSort.length; i++) {
			stringQuick = stringQuick + listaOrdenadaQuickSort[i];
			stringQuick = stringQuick + " ";	
		}
		
		for (int i = 0; i < listaOrdenadaSelectionSort.length; i++) {
			stringSelection = stringSelection + listaOrdenadaSelectionSort[i];
			stringSelection = stringSelection + " ";	
		}
		
		for (int i = 0; i < listaOrdenadaBubbleSort.length; i++) {
			stringBubble = stringBubble + listaOrdenadaBubbleSort[i];
			stringBubble = stringBubble + " ";	
		}

		txtOrdQuickSort.setText(stringQuick);
		txtOrdBubbleSort.setText(stringBubble);
        txtOrdSelectionSort.setText(stringSelection);
		
        txtOrdBubbleSort.setVisible(true);
        txtOrdQuickSort.setVisible(true);
        txtOrdSelectionSort.setVisible(true);
        
        
    }
	//btOrdenar action performer
	
	//btAnalisar action performer
	private void btAnalisarActionPerformed(java.awt.event.ActionEvent evt){
		try {			
			NivelDesmatamento x = new NivelDesmatamento(file);
			
			ArrayList<Integer> niveisDESMATAMENTO = x.RetornaListaNivelDesmatamento();//LISTA DE NÍVEIS DE DESMATAMENTO (não está ordenado ainda) 
			ArrayList<Color> coresDOMINANTES = x.RetornaListaCoresDominantes();//LISTA DE CORES DOMINANTES (está na mesma ordem do nível de desmatamento, ou seja, a posição 0 da cor corresponde a posição 0 do desmatamento)
			
			ArrayList<Integer> listaDeIndex = new ArrayList<Integer>();//essa lista serve somente para melhorar a visualização para o usuário, mostrando assim o número da divisão (que agora é mostrada na imagem) (número da divisão é calculado basicamente com o número do index da lista sem ordenação +1)
			
			//COLOCANDO A IMAGEM JÁ SEPARADA DENTRO DA INTERFACE
			BufferedImage imagemFOTOSEPARADA = x.RetornaImagemSeparada();
			
			lblFoto.setText("");
			lblFoto.setIcon(new ImageIcon(imagemFOTOSEPARADA));
		
			for (int i = 1; i <= niveisDESMATAMENTO.size(); i++) {//for para adicionar todas as posições iniciais para reconhecimento do usuário
				listaDeIndex.add(i);
			}
			
			String desmatamentoAnalisado = "";
			
			for (int i = 0; i < niveisDESMATAMENTO.size(); i++) {
				desmatamentoAnalisado = desmatamentoAnalisado + listaDeIndex.get(i) + " -> Nível desmatamento: "+ niveisDESMATAMENTO.get(i) + " | Cor Dominante: RGB(" + coresDOMINANTES.get(i).getRed() + ", " + coresDOMINANTES.get(i).getGreen() + ", " + coresDOMINANTES.get(i).getBlue()+ ") ";
				desmatamentoAnalisado = desmatamentoAnalisado + "\n";
			}
			
			txtAnalise.setText(desmatamentoAnalisado);
			
			txtAnalise.setVisible(true);
			btOrdenar.setVisible(true);
			
		} catch (Exception e) {
			lblFoto.setIcon(null);
			lblFoto.setText("<html><body>Não foi possível carregar a foto, <br> por favor, tente nos formatos: <br> .png, .jpg, .gif ou .jpeg</body></html>");
			btOrdenar.setVisible(false);
			txtOrdBubbleSort.setVisible(false);
	        txtOrdQuickSort.setVisible(false);
	        txtOrdSelectionSort.setVisible(false);
	        txtAnalise.setVisible(false);
		}
    }
	//btAnalisar action performer
}
