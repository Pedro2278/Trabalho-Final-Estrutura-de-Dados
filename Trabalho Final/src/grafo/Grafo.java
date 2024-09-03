package grafo;

import java.util.*;

public class Grafo {
    private Map<Integer, Vertice> vertices = new HashMap<>();
    private List<Aresta> arestas = new ArrayList<>();

    public void adicionarVertice(Vertice v) {
        vertices.put(v.getId(), v);
    }

    public void removerVertice(int id) {
        Vertice v = vertices.remove(id);
        if (v != null) {
            arestas.removeIf(a -> a.getOrigem().equals(v) || a.getDestino().equals(v));
        }
    }

    public void adicionarAresta(int idOrigem, int idDestino, int peso) {
        Vertice origem = vertices.get(idOrigem);
        Vertice destino = vertices.get(idDestino);
        if (origem != null && destino != null) {
            arestas.add(new Aresta(origem, destino, peso));
        }
    }

    public void removerAresta(int idOrigem, int idDestino) {
        arestas.removeIf(a -> a.getOrigem().getId() == idOrigem && a.getDestino().getId() == idDestino);
    }

    public Map<Integer, Vertice> getVertices() {
        return vertices;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public int grauVertice(int id) {
        Vertice v = vertices.get(id);
        if (v == null) return 0;

        int grau = 0;
        for (Aresta a : arestas) {
            if (a.getOrigem().equals(v) || a.getDestino().equals(v)) {
                grau++;
            }
        }
        return grau;
    }

    public boolean verificarConexo() {
        if (vertices.isEmpty()) return true;

        Set<Vertice> visitados = new HashSet<>();
        Queue<Vertice> fila = new LinkedList<>();
        Vertice inicial = vertices.values().iterator().next();
        fila.add(inicial);
        visitados.add(inicial);

        while (!fila.isEmpty()) {
            Vertice atual = fila.poll();
            for (Aresta a : arestas) {
                if (a.getOrigem().equals(atual) && !visitados.contains(a.getDestino())) {
                    fila.add(a.getDestino());
                    visitados.add(a.getDestino());
                } else if (a.getDestino().equals(atual) && !visitados.contains(a.getOrigem())) {
                    fila.add(a.getOrigem());
                    visitados.add(a.getOrigem());
                }
            }
        }

        return visitados.size() == vertices.size();
    }

    public int[][] converterParaMatrizAdjacencia() {
        int n = vertices.size();
        int[][] matriz = new int[n][n];
        for (int[] linha : matriz) {
            Arrays.fill(linha, 0);
        }

        // Mapeando IDs dos vértices para índices
        Map<Integer, Integer> idParaIndice = new HashMap<>();
        int index = 0;
        for (int id : vertices.keySet()) {
            idParaIndice.put(id, index++);
        }

        for (Aresta a : arestas) {
            int i = idParaIndice.get(a.getOrigem().getId());
            int j = idParaIndice.get(a.getDestino().getId());
            matriz[i][j] = a.getPeso();
            matriz[j][i] = a.getPeso(); // se o grafo for não dirigido
        }

        return matriz;
    }

    public void caminhoMinimoDijkstra(int origemId, int destinoId) {
        Vertice origem = vertices.get(origemId);
        Vertice destino = vertices.get(destinoId);
        if (origem == null || destino == null) {
            System.out.println("Vértice não encontrado.");
            return;
        }

        // Implementação do Algoritmo de Dijkstra
        Map<Vertice, Integer> distancias = new HashMap<>();
        Map<Vertice, Vertice> predecessores = new HashMap<>();
        PriorityQueue<Vertice> pq = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

        for (Vertice v : vertices.values()) {
            distancias.put(v, Integer.MAX_VALUE);
            predecessores.put(v, null);
        }

        distancias.put(origem, 0);
        pq.add(origem);

        while (!pq.isEmpty()) {
            Vertice atual = pq.poll();
            int distanciaAtual = distancias.get(atual);

            for (Aresta a : arestas) {
                if (a.getOrigem().equals(atual)) {
                    Vertice vizinho = a.getDestino();
                    int novaDistancia = distanciaAtual + a.getPeso();
                    if (novaDistancia < distancias.get(vizinho)) {
                        distancias.put(vizinho, novaDistancia);
                        predecessores.put(vizinho, atual);
                        pq.add(vizinho);
                    }
                } else if (a.getDestino().equals(atual)) {
                    Vertice vizinho = a.getOrigem();
                    int novaDistancia = distanciaAtual + a.getPeso();
                    if (novaDistancia < distancias.get(vizinho)) {
                        distancias.put(vizinho, novaDistancia);
                        predecessores.put(vizinho, atual);
                        pq.add(vizinho);
                    }
                }
            }
        }

        // Construir caminho
        List<Vertice> caminho = new ArrayList<>();
        for (Vertice v = destino; v != null; v = predecessores.get(v)) {
            caminho.add(v);
        }
        Collections.reverse(caminho);

        System.out.println("Caminho mínimo de " + origemId + " para " + destinoId + ":");
        for (Vertice v : caminho) {
            System.out.print(v.getId() + " ");
        }
        System.out.println();
    }
}