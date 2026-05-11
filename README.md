
# Sistema de Classificação de Notícias

Um sistema interativo de linha de comando (CLI) desenvolvido em Java para o cadastro, gerenciamento e análise de confiabilidade de notícias. 

Este projeto foi construído com um forte foco em **Clean Code**, **Orientação a Objetos** e **Princípios SOLID**, garantindo uma arquitetura robusta, altamente coesa, fracamente acoplada e fácil de testar.

---

##  Funcionalidades

* **Cadastro Manual de Notícias:** Permite ao usuário inserir o texto de uma notícia e definir manualmente a sua classificação de confiabilidade (ex: CONFIAVEL, DUVIDOSA, FALSA).
* **Cadastro Automático:** O usuário insere apenas o texto da notícia. O sistema utiliza um analisador interno que calcula uma pontuação de risco baseada em padrões de texto comumente encontrados em Fake News e classifica a notícia automaticamente.
* **Listagem de Notícias:** Exibe todas as notícias cadastradas no sistema, formatadas de maneira clara e legível.
* **Tratamento de Erros Resiliente:** O sistema previne a entrada de dados inválidos (como notícias em branco) através do padrão *Fail Fast*, capturando exceções graciosamente sem interromper a execução do menu.

---

## 🏗️ Arquitetura e Padrões Utilizados

O projeto abandonou a abordagem procedural e adotou padrões profissionais de engenharia de software:

* **Injeção de Dependência (DI):** As dependências das classes são injetadas via construtor através de interfaces (`ISistema`, `IAnalisadorNoticia`, `IScannerHelper`). O arquivo `App.java` atua como a entrada principal do programa.
* **Princípio da Responsabilidade Única (SRP):** Cada pacote e classe possui uma única razão para mudar. O menu não conhece as regras de negócio, e o sistema de armazenamento não sabe como exibir dados na tela.
* **Princípio da Inversão de Dependência (DIP):** Módulos de alto nível não dependem de módulos de baixo nível; ambos dependem de abstrações (Interfaces).
* **Encapsulamento seguro de I/O:** Toda a interação de leitura de teclado foi encapsulada em um utilitário (`ScannerHelper`) para prevenir bugs de buffer de teclado (como o salto de linhas indesejado).

---

## 📂 Estrutura do Projeto

A base de código está organizada de forma semântica em pacotes:

   
    src/
    └── app/
        ├── menu/
        │   ├── IMenuSistema.java
        │   └── MenuSistema.java          # Gerencia o laço de execução e UI do console
        ├── noticia/
        │   ├── enums/
        │   │   └── ClassificacaoNoticiaEnum.java    # Classificações pré-cadastradas para notícias
        │   ├── model/
        │   │   └── Noticia.java          # Entidade de domínio
        │   ├── IAnalisadorNoticia.java
        │   └── AnalisadorNoticia.java    # Lógica de cálculo de score 
        ├── sistema/
        │   ├── ISistema.java
        │   └── Sistema.java              # Regras de negócio
        ├── utils/
        │   ├── IScannerHelper.java
        │   └── ScannerHelper.java        # Leitura segura do teclado e tratamento de buffer
        └── App.java                      # Ponto de entrada (Main) 

## Como Compilar e Executar

### Pré-requisitos
* Java (JDK)  - 17 ou superior .

### Passo a Passo

1. Clone o Projeto:

       git clone https://github.com/rodrigofnobrega/Disciplinas.git

2. Abra o terminal (Prompt de Comando, PowerShell ou Terminal Linux/Mac) e navegue até a pasta `Java` do projeto:

       cd  Disciplinas/2026/1/BPP/Unidades/1/Trabalho/Java

3. Compilar Projeto:

       javac -d bin -sourcepath . app/*.java app/menu/*.java app/noticia/*.java app/noticia/enums/*.java app/noticia/model/*.java app/sistema/*.java app/utils/*.java

4. Executar Projeto:

       java -cp bin app.App 

## Gerar Documentação (JavaDocs)
1. Clone o Projeto:

       git clone https://github.com/rodrigofnobrega/Disciplinas.git

2. Abra o terminal (Prompt de Comando, PowerShell ou Terminal Linux/Mac) e navegue até a pasta `Java` do projeto:

       cd  Disciplinas/2026/1/BPP/Unidades/1/Trabalho/Java

3. Gerar Documentação:

       javadoc -d docs -sourcepath . -subpackages app

4. Abrir Documentação:

       firefox docs/overview-summary.html

