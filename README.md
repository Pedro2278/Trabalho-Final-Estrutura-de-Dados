# Trabalho-Final-Estrutura-de-Dados

# Projeto de Grafo em Java

## Descrição

Este projeto é uma implementação de um sistema de gerenciamento de grafos em Java. O sistema permite a criação, modificação e visualização de grafos, oferecendo diversas funcionalidades para manipulação de vértices e arestas, além de algoritmos como Dijkstra para encontrar o caminho mínimo entre dois vértices. A aplicação possui uma interface gráfica simples, construída com Swing, que facilita a interação do usuário com o grafo.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para desenvolver o projeto.
- **Swing**: Biblioteca gráfica do Java utilizada para criar a interface do usuário.
- **Coleções Java (Map, List, Set, Queue)**: Utilizadas para armazenar e manipular os vértices e arestas do grafo.

## Funcionalidades

O sistema oferece as seguintes funcionalidades:

1. **Inserir Vértice**: Adiciona um novo vértice ao grafo.
2. **Inserir Aresta**: Adiciona uma aresta entre dois vértices, especificando um peso.
3. **Remover Vértice**: Remove um vértice e todas as arestas associadas a ele.
4. **Remover Aresta**: Remove uma aresta específica entre dois vértices.
5. **Visualizar Grafo**: Exibe graficamente o grafo atual em uma nova janela.
6. **Informar Grau**: Calcula e exibe o grau de um vértice específico.
7. **Verificar Conexidade**: Verifica se o grafo é conexo, ou seja, se há um caminho entre todos os pares de vértices.
8. **Converter para Matriz de Adjacência**: Transforma a lista de adjacências em uma matriz de adjacências e a exibe.
9. **Caminho Mínimo (Dijkstra)**: Implementa o algoritmo de Dijkstra para encontrar o caminho mais curto entre dois vértices.

## Como Executar

Para executar o projeto, siga os passos abaixo:

1. **Clone o repositório**:
    ```bash
    git clone https://github.com/seu-usuario/seu-repositorio.git
    ```
2. **Compile os arquivos Java**:
    - Navegue até a pasta `src` e compile todos os arquivos `.java` utilizando o seguinte comando:
    ```bash
    javac grafo/*.java
    ```

3. **Execute o programa**:
    - Após compilar, execute o programa através da classe `Main`:
    ```bash
    java grafo.Main
    ```

4. **Interaja com o sistema**:
    - A interface gráfica será aberta, permitindo a interação com as funcionalidades listadas.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

```plaintext
src/
└── grafo/
    ├── Aresta.java
    ├── Grafo.java
    ├── Main.java
    ├── Vertice.java
    └── VisualizacaoGrafo.java
```

Esse README oferece uma visão clara e organizada do projeto, suas funcionalidades, e como executá-lo, sendo ideal para inclusão em um repositório Git.

Link para o video no canal do Youtube:
https://youtu.be/-wXSvaS5W5s
