# cadastro-pessoa
Cadastro pessoa CRUD usando Spring boot - Java

- Diretório:

>> cadPessoas: front-end (Angular)

>> pessoa: back-end (Java Spring-Boot)

Código backend contruído em JAVA - SpringBoot 

>> REQUISITOS:

classe controller principal: PessoaController.java

*** endpoints GET: ***

>> GET(Buscar uma única Pessoa), opção feita para retornar apenas uma pessoa filtrando no parâmetro o campo "cpf", exemplo: http://localhost:8080/consultaPessoaCpf?cpf=28067480036

>> GET (busca paginada opção de filtro para retornar várias pessoas), opção feita para retornar pessoas de uma consulta por nome, exemplo http://localhost:8080/consultaPessoaNome?nome=MARIA, retornaria todas as pesssoas que comecem por MARIA.

>> GET (busca TODOS os registros), opção retornará todos os cadastros/registros inseridos no banco de dados, exemplo http://localhost:8080/consultaPessoaCpf (end pont passado sem parâmetro)

*** endpoints PUT (inserção) ***

>> endpoints criados para inserção de dados, PESSOA: "/inserirPessoa" e PESSOA_CONTATO: "/inserirPessoaContato", ambos necessitam de que seja passado por parâmetro o objeto para ser inserido.

*** endpoints POST (atualização) ***

>> endpoints criados para inserção de dados, PESSOA: "/atualizarPessoa" e PESSOA_CONTATO: "/atualizarPessoaContato", ambos necessitam de que seja passado por parâmetro o objeto para ser atualizado.

*** endpoints DELETE ***

>> endpoints criados para remoção de dados, PESSOA: "/deletarPessoa" e PESSOA_CONTATO: "/deletarPessoaContato", ambos necessitam de que seja passado por parâmetro o objeto para ser removido.

-------------------------------------------------------------------------------------------------------

>> VALIDACOES:

>> TODOS os campos são obrigatórios (Pessoa e Pessoa Contato), todos os campos criados com a anotação @NotNull, validando então a obrigação dos campos no banco de dados.

>> A pessoa deve possuir ao menos um contato, ligação criada.

>> O CPF deve ser um CPF válido, criado função de validação dentro do controller principal (que é usado antes da inclusão/alteração de registros da tabela pessoa).

>> A data de Nascimento não deve ser uma data futura, criado função de validação da data de nascimento dentro do controller principal (que é usada antes da inclusão/alteração de registros da tabela pessoa).

>> Validar sintaxe do email do contato, criado função de validação do email dentro do controller principal (que é usada antes da inclusão/alteração de registros da tabela pessoa_contato).

-------------------------------------------------------------------------------------------------------

>> REQUISITOS TÉCNICOS

>> Deverão ser criados testes unitários, criado teste unitário reforçando a utilização das principais requisições/validações criadas. 
Classe: PessoaTeste.java (localização: src/teste/java/br.com.jessica.cadastro.pessoa.teste.unitario).

>> Publicar o código em respositório público (teste será publicado em diretório do git hub).

-------------------------------------------------------------------------------------------------------

>> DIFERENCIAL

>> Implementação de front-end

  Tentei fazer a construção/implementação para uso completo do cadastro desenvolvido em backend, utilizando front-end voltado para Angular. 
  Como não tenho experiência sólida com essa ferramenta não finalizei essa etapa, está disponível até o ponto que consegui desenvolver nesse momento, que foi a ligação dos servidores back-end(localhost:8080)/front-end(localhost:4200) onde retornei uma lista/relatório de uma das apis de consulta GET, feita no backend.

-------------------------------------------------------------------------------------------------------

>> CONFIGURAÇÕES GERAIS E DO BANCO DE DADOS RELACIONAL UTILIZADO

Spring: Versão: 2.3.3.RELEASE Java: Versão: 11 PostgreSql: Versão: 12.4.1 (Win x64) Obs.: Arquivo com configurações do banco (application.properties) >>DataBase: jdbc:postgresql://localhost:5432/bancocep IMPORTANTE: Antes de executar criar base de dados "bancocep" pois o hibernate não cria o data base automático, as tabelas (e caso tenha triggers/procedures/indexes) essas sim são criadas automaticamente (de acordo com o que o projeto possuir) ao executar a application. >>Username: postgres >>password: a (configurado durante instalação do postgresql)


