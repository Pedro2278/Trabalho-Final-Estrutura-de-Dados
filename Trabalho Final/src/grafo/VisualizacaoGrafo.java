package grafo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

public class VisualizacaoGrafo extends JPanel {
    private Grafo grafo;

    public VisualizacaoGrafo(Grafo grafo) {
        this.grafo = grafo;
        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Desenhar arestas
        g2d.setColor(Color.BLACK);
        for (Aresta a : grafo.getArestas()) {
            Point origem = getPosicaoVertice(a.getOrigem());
            Point destino = getPosicaoVertice(a.getDestino());
            drawArrowLine(g2d, origem, destino);
            g2d.drawString(String.valueOf(a.getPeso()), (origem.x + destino.x) / 2, (origem.y + destino.y) / 2);
        }

        // Desenhar vértices
        g2d.setColor(Color.RED);
        for (Vertice v : grafo.getVertices().values()) {
            Point p = getPosicaoVertice(v);
            g2d.fillOval(p.x - 15, p.y - 15, 30, 30);
            g2d.setColor(Color.WHITE);
            g2d.drawString(String.valueOf(v.getId()), p.x - 5, p.y + 5);
            g2d.setColor(Color.RED);
        }
    }

    private Point getPosicaoVertice(Vertice v) {
        // Melhorar o posicionamento dos vértices para uma disposição mais bonita
        int n = grafo.getVertices().size();
        int angle = (360 / n) * v.getId();
        int radius = 250;
        int x = (int) (getWidth() / 2 + radius * Math.cos(Math.toRadians(angle)));
        int y = (int) (getHeight() / 2 + radius * Math.sin(Math.toRadians(angle)));
        return new Point(x, y);
    }

    private void drawArrowLine(Graphics2D g2d, Point p1, Point p2) {
        // Desenhar linha com seta
        g2d.setColor(Color.BLACK);
        g2d.drawLine(p1.x, p1.y, p2.x, p2.y);

        // Desenhar a ponta da seta
        final int ARROW_SIZE = 10;
        double angle = Math.atan2(p2.y - p1.y, p2.x - p1.x);
        int x1 = (int) (p2.x - ARROW_SIZE * Math.cos(angle - Math.PI / 6));
        int y1 = (int) (p2.y - ARROW_SIZE * Math.sin(angle - Math.PI / 6));
        int x2 = (int) (p2.x - ARROW_SIZE * Math.cos(angle + Math.PI / 6));
        int y2 = (int) (p2.y - ARROW_SIZE * Math.sin(angle + Math.PI / 6));
        g2d.fillPolygon(new int[]{p2.x, x1, x2}, new int[]{p2.y, y1, y2}, 3);
    }
}