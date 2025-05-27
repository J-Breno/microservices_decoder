# 📘 Introdução a Arquitetura de Microservices

Arquitetura de microservices são conceitos e princípios que devem ser sempre adaptados ao negócio, não é um modelo e nem um padrão pronto e replicável.

O entendimento do negócio juntamente com a experiência e conhecimento adquiridos, como o de Microservices Patters, são essenciais para você fazer as melhores escolhas e definir as melhores soluções.

Comando é quando o microservice diz faça uma coisa
um evento é quando microservice avisa que uma coisa aconteceu

---

## 🧱 Arquitetura Monolítica vs Microservices

### 🧱 Arquitetura Monolítica

- Toda a aplicação é desenvolvida e implantada como uma única unidade.
- Exemplo: um sistema de e-commerce com cadastro de produtos, pedidos, pagamentos e usuários em um único projeto.
- Compartilha o mesmo banco de dados.
- Mais simples de desenvolver e testar no início.
- Problemas:
  - Dificuldade de escalar partes específicas.
  - Deploys são mais arriscados (qualquer erro afeta toda a aplicação).
  - Código pode se tornar muito acoplado e difícil de manter.

### 🔗 Arquitetura de Microservices

- A aplicação é dividida em vários **serviços independentes**, cada um responsável por uma **única funcionalidade** (ex: serviço de pagamento, serviço de pedidos, serviço de usuários).
- Cada serviço:
  - Pode ter seu **próprio banco de dados**.
  - É **implantado** e **escalado** de forma independente.
  - Se comunica com os outros via **APIs** ou **mensagens**.
- Vantagens:
  - Escalabilidade e flexibilidade.
  - Maior isolamento de falhas.
  - Equipes podem trabalhar em serviços diferentes.
- Desvantagens:
  - Maior complexidade.
  - Requer infraestrutura robusta (ex: monitoramento, descoberta de serviços, mensageria).

---

## ✉️ O que é uma Mensagem?

No contexto de microservices, uma **mensagem** é um pacote de dados enviado de um serviço para outro com a intenção de comunicar alguma informação ou instrução.

Exemplo: o serviço de "Pedidos" envia uma mensagem para o serviço de "Pagamentos" dizendo que um novo pedido foi criado.

---

## 🔄 Conceitos de Mensageria

### 🟢 Producer (Produtor)

- É quem **envia** a mensagem.
- Exemplo: o serviço de pedidos envia uma mensagem de que um pedido foi criado.

### 🟡 Consumer (Consumidor)

- É quem **recebe** e processa a mensagem.
- Exemplo: o serviço de pagamento recebe a mensagem de pedido criado e tenta realizar o pagamento.

---

## 📢 Publish e Subscribe

- **Publish (Publicar)**: o produtor envia uma mensagem sem saber quem vai receber.
- **Subscribe (Assinar)**: os consumidores se inscrevem para receber certas mensagens.
- Permite comunicação **assíncrona e desacoplada**.

Exemplo:
- O serviço de pedidos publica um evento "PedidoCriado".
- Os serviços de estoque, pagamento e notificação se inscrevem para esse evento.
- Cada um reage de forma independente.

---

## 🐇 RabbitMQ: Exchanges e Filas

RabbitMQ é um sistema de mensageria baseado no protocolo AMQP. Ele funciona com:

### 📬 Exchange (Trocador)

- Recebe as mensagens dos **producers**.
- Decide **para qual fila** a mensagem deve ir, com base nas **regras de roteamento**.

Tipos de exchange:
- **direct**: envia para filas com nome exato (roteamento direto).
- **fanout**: envia para **todas as filas** (broadcast).
- **topic**: roteamento baseado em padrão (ex: `pedido.*`).
- **headers**: roteia com base em cabeçalhos.

### 📥 Queue (Fila)

- Armazena mensagens até que sejam **consumidas**.
- O **consumer** escuta a fila e processa as mensagens.

---

## 🧭 Comandos vs Eventos

### 📘 Comando (Command)

- Representa uma **ação que deve ser executada**.
- É **intencional** e tem um **destinatário específico**.
- Exemplo: "CriarPedido", "EfetuarPagamento".

### 📗 Evento (Event)

- Representa **algo que já aconteceu**.
- Não há um destinatário definido, apenas **quem quiser reagir ao evento**.
- Exemplo: "PedidoCriado", "PagamentoConfirmado".

📌 **Resumo:**
| Tipo     | Representa           | É direcionado? | Exemplo              |
|----------|----------------------|----------------|----------------------|
| Comando  | Pedido para fazer algo | Sim            | CriarPedido          |
| Evento   | Algo que aconteceu     | Não            | PedidoCriado         |

---

## 🧠 Dicas Extras

- Use **comunicação síncrona** (HTTP/REST) apenas quando **precisar de resposta imediata**.
- Prefira **mensageria (RabbitMQ, Kafka)** quando puder usar **comunicação assíncrona**.
- Microservices devem ser **independentes**, mas devem **cooperar** entre si.
- Utilize **observabilidade** (monitoramento, logs, tracing) para entender o que acontece entre os serviços.

## Ecosistema Spring

Spring framework é a base para todo projeto spring

Inversão de controle é um padrão de projeto, em que um objeto apenas declara suas dependências sem cria-las e delega a tarefa de construir tais dependências a um Container Ioc(Core Container);

Injeção de Dependência é a implementação utilizada pelo Spring Framework de aplicar a inversão de controle quando necessário.

Bean consiste em um objeto que é instanciado, montado e gerenciado por um container do Spring através de Inversão de Controle (IoC) e Injeção de Dependência.

Spring boot é a junção do spring framework + servidor embutido(tomcat) - xml

## API REST vs API RESTFuL

api é uma aplicação que serve para comunicar serviços

Rest é o modelo arquitetural, conjunto de padrões que trazem boas praticas para o desenvolvimento dessas api
rest full é a implementação do rest;

@JsonView vai servir tipo um DTO, voc~e implementar um interface e diz onde somente tal coisa pode ser usada/alterada etc
    