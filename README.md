# casedesenvolvedor
casedesenvolvedor

  Uma aplicação que visa desenvolvimento de um processo de automatização do fluxo de
monitoramento da recepção dos arquivos enviados pelas adquirentes para uma determinada
empresa. 
  Software desenvolvido para automatizar o fluxo de uma empresa tem como modelo CARD que 
armazena os dados recebidos de cartões de uma empresa, que são salvos em um banco de dados 
SQL. Os arquivos recebidos das empresas estão em um backup na pasta com o nome ARQUIVOS.
  A aplicação mostrar seus resultados em um front-end produzido em ReactJs, contendo as telas
de Mostrar cartões ja cadastrados, mostrar arquivos para serem recepcionados e um grafico
que lista a quantidade de arquivos não recepcionados e recepcionados.

## Comandos para execução
  No projeto Spring boot é necessário acessar a pasta /casedesenvolvedor/src/main/resources/application.properties
e alterar o username,senha e trocar o nome do banco de dados para o desejado.
  MYSQL 8.0 Commando line é necessario criar o banco de dados. Faça a autenticação e utilize os comandos:
    (create database XXX;) XXX sendo o nome do seu banco de dados ja alterado
     use XXX;
   e para inicial o front-end é necessário utilizar o comando (npm start) e se caso necessário npm install.
 Pronto !!! Agora as URLs para acesso do usuários são :
    http://localhost:3000/verGraph
    http://localhost:3000/viewCards
    http://localhost:3000/arquivoRecepcionados



## Tecnologia de implementação

- Spring Framework ([https://spring.io](https://spring.io/))
- ReactJs ([https://pt-br.reactjs.org](https://pt-br.reactjs.org/))
- MySQL  ([https://mysql.com](https://mysql.com))

## Autor

Guilherme Henrique de Melo
