Documento de Especificação de Requisitos

Projeto: Tecnologia social com foco na geração de renda para coletores de frutos nativos da Caatinga e produtores de seus derivados.

Data de criação:

Autor: Aurora Rodrigues Maciel

Cargo:




Revisão: 01

Conteúdo 
1 Introdução 
1.1 Objetivo 
1.2 Escopo do produto 
1.3 Definições, Acrônimos e Abreviações 
2 Descrição geral 
2.1 Modo de Operação 
2.2 Funções do produto 
2.3 Usuários e sistemas externos 
2.4 Restrições 
2.5 Requisitos Adiados 
3 Requisitos específicos 
3.1 Requisitos Funcionais 
3.2 Requisitos Não-Funcionais 
3.2.1 Desempenho 
3.2.2 Usabilidade 
3.2.3 Segurança 
3.2.4 Expansibilidade 
3.3 Requisitos de Interface 
3.3.1 Interfaces de Usuário 
3.3.2 Interfaces de Hardware 
3.3.3 Interfaces de Software 
3.3.4 Interfaces de Comunicação 
4 Restrições e Limitações 
5 Glossário 
6 Referências 
7 Aprovação
8 Diagrama de casos de uso







1 Introdução

A implementação dessa tecnologia social tem a finalidade de conectar coletores de frutos nativos da Caatinga e produtores de seus derivados  com possíveis compradores e consumidores desses produtos.
Público-alvo: Cidadãos que trabalham com a coleta de frutos nativos desse bioma e produtores de seus derivados, associações rurais, empresas, indústrias de alimentos e sociedade em geral.

1.1 Objetivo

Este documento tem como objetivo apresentar de forma detalhada os requisitos funcionais e não funcionais da tecnologia social com foco em geração de renda para coletores de frutos nativos da Caatinga e produtores de seus derivados. Ele servirá como guia para o desenvolvimento do software, descrevendo as funcionalidades, características e necessidades que serão abordadas na implementação.

1.2 Escopo do produto

O escopo deste documento abrange as funcionalidades e características da tecnologia social com foco em geração de renda para coletores de frutos nativos da Caatinga e produtores de seus derivados, desde o cadastro de coletores, produtores de derivados, compradores e possíveis transportadores, a negociação do produto através de um chat integrado, avaliação de vendedores e clientes,  até a emissão de notas fiscais.

1.3 Definições, Acrônimos e Abreviações 

Nº - Sigla - Definição

01 - RF - Requisito funcional

02 - RFN - Requisito não funcional

03 - RG - Registro Geral (documento de identidade)

04 - CPF - Cadastro da Pessoa Física

05 - CNPJ - Cadastro Nacional da Pessoa Jurídica

2 Descrição geral

2.1 Modo de Operação

A tecnologia social com foco na geração de renda para coletores de frutos nativos da Caatinga e produtores de seus derivados opera como uma funcionalidade voltada para conectar vendedores e compradores desses produtos. Ela visa interligar cidadãos, associações e empresas, proporcionando uma compra confiável, valorização dos produtos e aumento do lucro dos coletores e produtores. Os principais atores incluem o coletor, o produtor, o cliente e o transportador.

2.2 Funções do produto 

Nº - Função - Descrição

01 - Cadastrar coletores - O cidadão ou associação pode se cadastrar como coletora.

02 - Cadastrar produtor de derivados - O cidadão ou associação pode se cadastrar como produtor de derivados.

03 - Cadastrar cliente - O cidadão ou a empresa pode se cadastrar como cliente.

04 - Cadastrar transportadores - O cidadão ou a empresa pode se cadastrar como transportador.

05 - Anexar documentos - O cidadão anexa os documentos básicos exigidos no momento da venda e cadastro.

06 - Realizar compra - O comprador entra em contato com um vendedor para realizar uma compra.

07 - Realizar encomenda - O comprador entra em contato com um vendedor para realizar uma encomenda.

08 - Analisar cadastro - O administrador do sistema analisa a solicitação de cadastro.

2.3 Usuários e sistemas externos 

Nº - Usuário - Descrição

01 - Empresa - Empresa que se cadastra como cliente.

02 - Associação - Entidade que se cadastra como coletora ou produtora de derivados.

03 - Cidadão - Pessoa que se cadastra como coletor, produtor ou cliente.

04 - Administrador - Responsável por analisar as solicitações de cadastro, aceitar, rejeitar ou aceitar com ressalvas, e gerenciar o sistema.

2.4 Restrições

Nº - Tipo - Descrição

01 - Software - O ambiente operacional a ser utilizado será compatível com dispositivos Android, iOS e computadores. 

02 - Hardware - Dispositivos com acesso a internet.

03 - Segurança - Documentos pessoais anexados devem ser armazenados de forma protegida e acessível apenas a autorizados.
 
04 - Segurança - O produto deverá restringir o acesso através de login individual para cada perfil de usuário.

05 - Processo - A venda só pode ser realizada com o acordo de ambas as partes.


2.5 Requisitos Adiados

Nº - Referência - Detalhes

01 - Filtro por Associação - Na tela de cadastro do Vendedor, coloque um Dropdown que carrega dinamicamente as Associações já cadastradas no banco de dados.

02 - Logística de Escoamento - Na tela do Transportador, adicione campos para delimitar as cidades ou comunidades da Caatinga que ele atende, ajudando a entender quem pode transportar os produtos de cada vendedor. 

3 Requisitos específicos 

3.1 Requisitos Funcionais 

Código - Nome - Descrição

RF01 - Cadastro de coletores - O cidadão poderá se cadastrar como coletor, oferecer produtos disponíveis para venda, fechar negócio e receber encomendas.

RF02 - Cadastro de produtores - O cidadão poderá se cadastrar como produtor de derivados, oferecer produtos disponíveis para a venda, fechar negócio e receber encomendas.

RF03 - Cadastro de clientes - O cliente poderá se cadastrar na plataforma, escolher de quem comprar, buscar o que deseja comprar e definir a quantidade.

RF04 - Cadastro de transportador - O cidadão ou empresa poderá se cadastrar como transportadora, definir áreas de atuação e porte suportado.

RF05 - Anexar documentos - O cidadão anexa os documentos básicos necessários para o cadastro ou venda.

RF06 - Realizar compra - O cliente escolhe de quem comprar, o que comprar, a quantidade, a forma de pagamento e adiciona no carrinho/entra em contato com o vendedor através do chat.

RF07 - Realizar encomenda - O cliente escolhe de quem comprar, o que comprar, a quantidade, a forma de pagamento.

RF08 - Analisar cadastro - O administrador do sistema analisa as informações e os documentos anexados pelo usuário no momento do cadastro de coletores, produtores e transportadores.

RF09 - Acompanhamento - O usuário deve acompanhar o andamento de cada fase do processo.

RF10 - Fazer login - Os usuários devem realizar autenticação usando as credenciais de acesso.


3.2 Requisitos Não-Funcionais 

3.2.1 Desempenho 

Código Requisito / Aplicação - Descrição

RNF01 - Aplicação - A compra deve ser realizada sem interrupções.

RNF02 - Aplicação - O aplicativo deve apresentar tempos de resposta rápidos para envio da solicitação e arquivos.

3.2.2 Usabilidade

Código Requisito / Aplicação - Descrição

RNF03 - Design intuitivo - A plataforma deve possuir um design intuitivo e de fácil uso, tanto para o usuário quanto para o administrador. 

RNF04 - Fluidez - Que seja leve, intuitivo, explicativo e fácil de usar.

3.2.3 Segurança 

Código Requisito / Aplicação - Descrição

RNF05 - Autenticação segura - A autenticação segura deve ser implementada para acesso aos perfis de coletor, produtor, cliente, transportador e administrador.

3.2.4 Expansibilidade

Código Requisito / Aplicação - Descrição

RNF06 - Arquitetura Modular - O sistema deve ser desenvolvido de forma modular para permitir a futura expansão e integração de novos produtos de forma simplificada.

3.3 Requisitos de Interface 

3.3.1 Interfaces de Usuário 

Nº - Nome - Descrição

01 - Tela de cadastro de coletor - Interface online para o cidadão ou associação se cadastrar.

02 - Tela de cadastro de produtor - Interface online para o cidadão ou associação se cadastrar.

03 - Tela de cadastro de cliente - Interface online para o cidadão ou empresa se cadastrar.

04 - Tela de cadastro de transportador - Interface online para o cidadão ou empresa se cadastrar.

05 - Tela de cadastro de administrador - Interface online para o cidadão ou associação se cadastrar.

06 - Upload de documentos - Interface online para anexo dos documentos básicos exigidos.

07 - Painel do administrador - Interface online para o administrador visualizar, analisar e decidir sobre as solicitações.

08 - Painel de busca de produtos - Interface online onde o cliente busca pelo produto desejado.

09 - Painel gestão de vendas - Interface online onde os vendedores visualizam as vendas.

10 - Carrinho de compra - Interface online onde o cliente visualiza os produtos escolhidos, a quantidade e o valor unitário e total.

11 - Painel de gestão de entregas - Interface online onde o transportador verá as entregas que precisam ser feitas e as já concluídas.

3.3.2 Interfaces de Hardware

O aplicativo deve utilizar a câmera do dispositivo para captura/anexo de fotos dos documentos. 

3.3.3 Interfaces de Software 

Não aplicável no escopo atual. 

3.3.4 Interfaces de Comunicação 

O aplicativo deve utilizar serviço de notificações push para comunicar ao cidadão a análise, o aceite, a rejeição ou o aceite com ressalvas da solicitação, bem como a venda.

4 Restrições e Limitações

● As compras só poderão ser realizadas a partir da quantidade disponibilizada pelo vendedor, qualquer quantidade excedente fica indicado para encomenda.

● [Listar quaisquer outras restrições ou limitações que possam impactar o desenvolvimento ou a implantação do software] 

5 Glossário 

Termo - Definição

Ressalva - Observação registrada pelo servidor ao aceitar uma solicitação, indicando pendências ou orientações ao cidadão.

6 Referências 

Não encontradas. 

7 Aprovação 

Este documento foi revisado e aprovado por: 

Nome: _____________________________ 

Cargo: _____________________________ 