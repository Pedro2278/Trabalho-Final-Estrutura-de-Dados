package grafo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static Grafo grafo = new Grafo();

    public static void main(String[] args) {
        // Menu principal
        JFrame frame = new JFrame("Menu Principal");
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton inserirVerticeButton = new JButton("Inserir Vértice");
        inserirVerticeButton.setBounds(10, 20, 160, 25);
        panel.add(inserirVerticeButton);
        inserirVerticeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do vértice:"));
                grafo.adicionarVertice(new Vertice(id));
            }
        });

        JButton inserirArestaButton = new JButton("Inserir Aresta");
        inserirArestaButton.setBounds(10, 50, 160, 25);
        panel.add(inserirArestaButton);
        inserirArestaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idOrigem = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do vértice de origem:"));
                int idDestino = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do vértice de destino:"));
                int peso = Integer.parseInt(JOptionPane.showInputDialog("Digite o peso da aresta:"));
                grafo.adicionarAresta(idOrigem, idDestino, peso);
            }
        });

        JButton removerVerticeButton = new JButton("Remover Vértice");
        removerVerticeButton.setBounds(10, 80, 160, 25);
        panel.add(removerVerticeButton);
        removerVerticeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do vértice a ser removido:"));
                grafo.removerVertice(id);
            }
        });

        JButton removerArestaButton = new JButton("Remover Aresta");
        removerArestaButton.setBounds(10, 110, 160, 25);
        panel.add(removerArestaButton);
        removerArestaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idOrigem = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do vértice de origem:"));
                int idDestino = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do vértice de destino:"));
                grafo.removerAresta(idOrigem, idDestino);
            }
        });

        JButton visualizarGrafoButton = new JButton("Visualizar Grafo");
        visualizarGrafoButton.setBounds(10, 140, 160, 25);
        panel.add(visualizarGrafoButton);
        visualizarGrafoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarGrafo();
            }
        });

        JButton informarGrauButton = new JButton("Informar Grau");
        informarGrauButton.setBounds(10, 170, 160, 25);
        panel.add(informarGrauButton);
        informarGrauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do vértice:"));
                int grau = grafo.grauVertice(id);
                JOptionPane.showMessageDialog(null, "Grau do vértice " + id + ": " + grau);
            }
        });

        JButton verificarConexoButton = new JButton("Verificar Conexo");
        verificarConexoButton.setBounds(10, 200, 160, 25);
        panel.add(verificarConexoButton);
        verificarConexoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean conexo = grafo.verificarConexo();
                JOptionPane.showMessageDialog(null, "O grafo é conexo? " + conexo);
            }
        });

        JButton converterMatrizButton = new JButton("Converter para Matriz");
        converterMatrizButton.setBounds(10, 230, 160, 25);
        panel.add(converterMatrizButton);
        converterMatrizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[][] matriz = grafo.converterParaMatrizAdjacencia();
                StringBuilder sb = new StringBuilder();
                for (int[] linha : matriz) {
                    for (int valor : linha) {
                        sb.append(valor).append(" ");
                    }
                    sb.append("\n");
                }
                JOptionPane.showMessageDialog(null, "Matriz de Adjacência:\n" + sb.toString());
            }
        });

        JButton caminhoMinimoButton = new JButton("Caminho Mínimo");
        caminhoMinimoButton.setBounds(10, 260, 160, 25);
        panel.add(caminhoMinimoButton);
        caminhoMinimoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idOrigem = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do vértice de origem:"));
                int idDestino = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do vértice de destino:"));
                grafo.caminhoMinimoDijkstra(idOrigem, idDestino);
            }
        });
    }

    private static void visualizarGrafo() {
        JFrame frame = new JFrame("Visualização do Grafo");
        VisualizacaoGrafo painel = new VisualizacaoGrafo(grafo);
        frame.add(painel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
